package com.tecyle.question.servlet;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tecyle.question.core.AccessTokenGenerator;
import com.tecyle.question.core.AccessTokenGenerator.UserLoginState;
import com.tecyle.question.core.MdQuestionDatabase;

public class LoginActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginActionServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(403);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
			response.sendError(400);
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
		
		Set<String> tokens = (Set<String>)getServletContext().getAttribute("yudukiTokens");
		if (tokens == null) {
			tokens = AccessTokenGenerator.loadTokens(getServletContext().getRealPath("/") + "/tokens");
			if (tokens != null)
				getServletContext().setAttribute("yudukiTokens", tokens);
		}
		
		// validate
		if (username.equals("admin") && password.equals("meiyoumima")) {
			// manager user
			session.setAttribute("loginYudukiUser", username);
			session.setAttribute("loginYudukiToken", password);
			response.sendRedirect("yuduki/manager.html");
		} else if (tokens != null && tokens.contains(password)) {
			session.setAttribute("loginYudukiUser", username);
			session.setAttribute("loginYudukiToken", password);
			UserLoginState state = AccessTokenGenerator.checkUserLoginState(getServletContext().getRealPath("/") + "/tokens", password);
			switch (state) {
			case FIRST_ACCESS:
			case TESTING:
				response.sendRedirect("test.html");
				break;
			case ALREADY_SUBMITTED:
				response.sendRedirect("gameOver.html");
				break;
			}
		} else {
			response.sendRedirect("login.html?error=iut");
		}
	}

	public void init() throws ServletException {
		
	}

}
