package com.tecyle.question.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tecyle.question.core.AccessTokenGenerator;
import com.tecyle.question.core.MdQuestionDatabase;

public class ReloadQuestionsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReloadQuestionsServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(404);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("loginYudukiUser");
		if (userName == null && userName!= "admin") {
			response.sendRedirect("/login.html");
			return;
		}
		
		// reload question database
		MdQuestionDatabase database = (MdQuestionDatabase)getServletContext().getAttribute("qdb");
		if (database == null) {
			database = new MdQuestionDatabase();
		}
		database.loadQuestionsFromFile(getServletContext().getRealPath("/") + "/questions.md", request.getContextPath());
		getServletContext().setAttribute("qdb", database);
		
		// re-generate tokens
		Integer tokenCount = (Integer)getServletContext().getAttribute("yudukiTokenCount");
		if (tokenCount == null) {
			tokenCount = 200;
		}
		String strTokenCount = request.getParameter("tokenCount");
		if (strTokenCount != null) {
			tokenCount = Integer.parseInt(strTokenCount);
		}
		if (tokenCount <= 0)
			tokenCount = 1;
		List<String> tokens = AccessTokenGenerator.generateTokens(tokenCount, 9);
		AccessTokenGenerator.resetTokensWorkspace(getServletContext().getRealPath("/")+ "/tokens", tokens);
		Set<String> mapTokens = AccessTokenGenerator.loadTokens(getServletContext().getRealPath("/") + "/tokens");
		getServletContext().setAttribute("yudukiTokens", mapTokens);
		
		// post message
		session.setAttribute("managerMsg", "题库已经重新加载，所有 token 也已经重新生成！");
		response.sendRedirect(request.getContextPath() + "/yuduki/manager.html");
	}

	public void init() throws ServletException {
		
	}

}
