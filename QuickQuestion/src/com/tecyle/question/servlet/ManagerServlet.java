package com.tecyle.question.servlet;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tecyle.question.core.AccessTokenGenerator;
import com.tecyle.question.model.ManagerTokenObject;

class UserNameScorePair {
	String username;
	double score;
}

public class ManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ManagerServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// check login state
		String username = (String)session.getAttribute("loginYudukiUser");
		if (username == null || !username.equals("admin")) {
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}
		
		// load tokens
		String tokensDir = getServletContext().getRealPath("/") + "/tokens";
		@SuppressWarnings("unchecked")
		Set<String> tokens = (Set<String>)getServletContext().getAttribute("yudukiTokens");
		if (tokens == null) {
			tokens = new HashSet<String>();
		}
		
		List<ManagerTokenObject> tokenStates = new ArrayList<ManagerTokenObject>();
		for (String t : tokens) {
			ManagerTokenObject mto = new ManagerTokenObject();
			AccessTokenGenerator.UserLoginState loginState = AccessTokenGenerator.checkUserLoginState(tokensDir, t);
			switch (loginState) {
			case FIRST_ACCESS:
				mto.setScore("-");
				mto.setState("未激活");
				mto.setStateClass("text-primary");
				mto.setTokenHtml(t);
				mto.setUserName("-");
				break;
			case TESTING:
				mto.setScore("-");
				mto.setState("答题中");
				mto.setStateClass("text-danger");
				mto.setTokenHtml(t);
				mto.setUserName(loadTestingUserName(tokensDir, t));
				break;
			case ALREADY_SUBMITTED:
				UserNameScorePair usp = loadUserNameAndScore(tokensDir, t);
				mto.setScore(String.format("%.2f", usp.score));
				mto.setState("已提交");
				mto.setStateClass("text-success");
				mto.setTokenHtml("<a target=\"_blank\" href=\"view.html?token=" + t + "\">" + t + "</a>");
				mto.setUserName(usp.username);
				break;
			}
			mto.setToken(t);
			tokenStates.add(mto);
		}
		
		Collections.sort(tokenStates);
		
		// return states
		request.setAttribute("tokenStates", tokenStates);
		request.getRequestDispatcher("/yuduki/manager.jsp").forward(request, response);
	}
	
	private UserNameScorePair loadUserNameAndScore(String tokensDir, String token) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(tokensDir + "/" + token + ".a"), "utf-8"));
			String username = reader.readLine().trim();
			reader.readLine();
			double score = Double.parseDouble(reader.readLine().trim());
			UserNameScorePair p = new UserNameScorePair();
			p.username = username;
			p.score = score;
			reader.close();
			return p;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private String loadTestingUserName(String tokensDir, String token) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(tokensDir + "/" + token + ".q"), "utf-8"));
			String username = reader.readLine().trim();
			reader.close();
			return username;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
		
	}

}
