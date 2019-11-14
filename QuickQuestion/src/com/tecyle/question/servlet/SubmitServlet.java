package com.tecyle.question.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tecyle.question.core.AccessTokenGenerator;
import com.tecyle.question.core.MdAnswerSheet;
import com.tecyle.question.core.MdQuestionDatabase;
import com.tecyle.question.core.MdQuestionsGenerator;
import com.tecyle.question.core.MdTestPaper;

public class SubmitServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SubmitServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(400);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String token = request.getParameter("token");
		if (token == null) {
			response.sendError(400);
			return;
		}
		
		// Compare with token in session
		String userName = (String)session.getAttribute("loginYudukiUser");
		if (userName != null && userName.equals("admin")) {
			response.sendError(403);
			return;
		}
		
		// Check if already submitted
		String tokensDir = getServletContext().getRealPath("/") + "/tokens";
		AccessTokenGenerator.UserLoginState state = AccessTokenGenerator.checkUserLoginState(tokensDir, token);
		if (state == AccessTokenGenerator.UserLoginState.ALREADY_SUBMITTED)
		{
			response.sendRedirect(request.getContextPath() + "/gameOver.html");
			return;
		}
		if (state == AccessTokenGenerator.UserLoginState.FIRST_ACCESS)
		{
			response.sendError(400);
			return;
		}
		
		MdQuestionDatabase database = (MdQuestionDatabase)getServletContext().getAttribute("qdb");
		MdTestPaper paper = new MdTestPaper();
		paper.load(tokensDir, token);
		MdAnswerSheet mas = new MdAnswerSheet(database, paper);
		
		// Process answers
		for (int i=0; i < MdQuestionsGenerator.singleChoiceCount; ++i) {
			String key = "S" + (i+1);
			String answer = request.getParameter(key);
			if (answer == null)
				answer = "";
			mas.markSingleChoiceScore(i, answer);
		}
		for (int i=0; i < MdQuestionsGenerator.multiChoiceCount; ++i) {
			String key = "M" + (i+1);
			String[] answers = request.getParameterValues(key);
			StringBuilder answer = new StringBuilder();
			if (answers != null) {
				for (String a : answers) {
					answer.append(a);
				}
			}
			mas.markMultiChoicesScore(i, answer.toString());
		}
		for (int i=0; i < MdQuestionsGenerator.judgementCount; ++i) {
			String key = "J" + (i+1);
			String[] answers = request.getParameterValues(key);
			String answer = "F";
			if (answers != null && answers[0].equals("T")) {
				answer = "T";
			}
			mas.markJudgmentScore(i, answer);
		}
		
		// save and exit
		mas.save(tokensDir, userName, token);
		response.sendRedirect(request.getContextPath() + "/gameOver.html");
	}

	public void init() throws ServletException {
		
	}

}
