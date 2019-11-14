package com.tecyle.question.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuestionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QuestionServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		List<MdQuestionCategory> qlist = null;
		if (session.getAttribute("questionList") == null) {
			MdQuestionDatabase loader = new MdQuestionDatabase();
			qlist = loader.loadQuestionsFromFile(getServletContext().getRealPath("/") + "/questions.md");
			session.setAttribute("questionList", qlist);
		} else {
			qlist = (List<MdQuestionCategory>)session.getAttribute("questionList");
		}
		
		int questionCount = 50;
		String qc = request.getParameter("qc");
		if (qc != null) {
			try {
				questionCount = Integer.parseInt(qc);
			} catch (Exception e) {
				questionCount = 50;
			}
		}
		if (questionCount > 50)
			questionCount = 50;
		if (questionCount < 10)
			questionCount = 10;
		MdQuestionsGenerator gen = new MdQuestionsGenerator(qlist);
		List<Integer> weights = new ArrayList<Integer>();
		weights.add(20);
		weights.add(10);
		weights.add(10);
		weights.add(4);
		weights.add(1);
		weights.add(5);
		gen.setQuestionWeights(weights);
		List<MdQuestion> questions = gen.generate(questionCount);
		session.setAttribute("questions", questions);
		request.getRequestDispatcher("/question.jsp").forward(request, response);*/
		response.sendError(404);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(404);
	}

	public void init() throws ServletException {
		
	}
}
