package com.tecyle.question.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tecyle.question.core.AccessTokenGenerator;
import com.tecyle.question.core.AccessTokenGenerator.UserLoginState;
import com.tecyle.question.core.MdChoiceQuestion;
import com.tecyle.question.core.MdJudgementQuestion;
import com.tecyle.question.core.MdQuestionDatabase;
import com.tecyle.question.core.MdQuestionsGenerator;
import com.tecyle.question.core.MdTestPaper;

public class TestServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> weights = new ArrayList<Integer>();
	
	public TestServlet() {
		super();
		weights.add(4);
		weights.add(2);
		weights.add(2);
		weights.add(2);
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("loginYudukiUser");
		String userToken = (String)session.getAttribute("loginYudukiToken");
		if (userName == null || userToken == null || userName.equals("admin")) {
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}
		
		// Check database exists
		MdQuestionDatabase database = (MdQuestionDatabase)getServletContext().getAttribute("qdb");
		if (database == null) {
			// reload database
			database = new MdQuestionDatabase();
			database.loadQuestionsFromFile(getServletContext().getRealPath("/") + "/questions.md", request.getContextPath());
			getServletContext().setAttribute("qdb", database);
		}
		
		// Check login state
		String tokensDir = getServletContext().getRealPath("/") + "/tokens";
		UserLoginState state = AccessTokenGenerator.checkUserLoginState(tokensDir, userToken);
		MdTestPaper paper = null;
		switch (state) {
		case FIRST_ACCESS:
			paper = generateNewPaper(userName, userToken, tokensDir);
			break;
		case TESTING:
			paper = new MdTestPaper();
			paper.load(tokensDir, userToken);
			break;
		case ALREADY_SUBMITTED:
			response.sendRedirect(request.getContextPath() + "/gameOver.html");
			return;
		}
		if (paper == null) {
			response.sendError(404);
		}
		
		List<MdChoiceQuestion> singles = database.pickUpSingleChoicesFromPaper(paper);
		List<MdChoiceQuestion> multis = database.pickUpMultiChoicesFromPaper(paper);
		List<MdJudgementQuestion> judgments = database.pickUpJudgementsFromPaper(paper);
		request.setAttribute("singles", singles);
		request.setAttribute("multis", multis);
		request.setAttribute("judgments", judgments);
		
		request.getRequestDispatcher("/test.jsp").forward(request, response);
	}
	
	private MdTestPaper generateNewPaper(String userName, String token, String tokensDir) {
		MdQuestionDatabase database = (MdQuestionDatabase)getServletContext().getAttribute("qdb");
		MdQuestionsGenerator generator = new MdQuestionsGenerator(database);
		generator.setQuestionWeights(weights);
		MdTestPaper paper = generator.generateTestPaper();
		paper.save(tokensDir, userName, token);
		
		return paper;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(403);
	}

	public void init() throws ServletException {
		
	}

}
