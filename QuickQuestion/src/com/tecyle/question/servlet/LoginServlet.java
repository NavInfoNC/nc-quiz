package com.tecyle.question.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String errorType = request.getParameter("error");
		if (errorType == null) {
			errorType = "";
		} else if (errorType.equals("iut")) {
			errorType = "无效的用户名或密钥！";
		} else {
			errorType = "发生了未知错误！";
		}
		
		if (errorType.isEmpty()) {
			session.removeAttribute("loginMsg");
		} else {
			session.setAttribute("loginMsg", errorType);
		}
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(403);
	}

	public void init() throws ServletException {
		
	}

}
