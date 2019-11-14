package com.tecyle.question.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AnswerServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(404);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		List<MdQuestion> questions = (List<MdQuestion>)session.getAttribute("questions");
		if (questions == null) {
			response.sendError(403);
			return;
		}
		
		int score = 0;
		String[][] userAnswer = new String[questions.size()][4];
		String[][] answerResult = new String[questions.size()][4];
		for (int i=0; i < questions.size(); ++i) {
			String[] ans = request.getParameterValues("Q" + (i+1));
			MdQuestion q = questions.get(i);
			boolean corrected = true;
			for (int j=0; j < 4; ++j) {
				userAnswer[i][j] = "";
				answerResult[i][j] = "";
			}
			if (ans != null) {
				for (int j=0; j < ans.length; ++j) {
					userAnswer[i][ans[j].charAt(0) - 'A'] = "checked";
				}
			}
			for (int j=0; j < 4; ++j) {
				if (userAnswer[i][j].isEmpty() && q.getChoice(j).isCorrect()) {
					answerResult[i][j] = "missed-answer";
					corrected = false;
				} else if (!userAnswer[i][j].isEmpty() && !q.getChoice(j).isCorrect()) {
					answerResult[i][j] = "error-answer";
					corrected = false;
				} else if (!userAnswer[i][j].isEmpty() && q.getChoice(j).isCorrect()) {
					answerResult[i][j] = "correct-answer";
				}
			}
			if (corrected) {
				score++;
			}
		}
		
		session.setAttribute("score", score * 100 / questions.size());
		session.setAttribute("userAnswers", userAnswer);
		session.setAttribute("answerResult", answerResult);
		
		request.getRequestDispatcher("/answer.jsp").forward(request, response);*/
		response.sendError(404);
	}

	public void init() throws ServletException {

	}

}
