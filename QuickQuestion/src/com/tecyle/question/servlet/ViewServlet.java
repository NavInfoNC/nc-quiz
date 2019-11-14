package com.tecyle.question.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tecyle.question.core.MdAnswerSheet;
import com.tecyle.question.core.MdChoiceQuestion;
import com.tecyle.question.core.MdJudgementQuestion;
import com.tecyle.question.core.MdQuestionDatabase;
import com.tecyle.question.core.MdQuestionsGenerator;
import com.tecyle.question.core.MdTestPaper;
import com.tecyle.question.model.ViewChoiceObject;
import com.tecyle.question.model.ViewJudgmentObject;
import com.tecyle.question.model.ViewScoreDetailObject;

public class ViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ViewServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginUser = (String)session.getAttribute("loginYudukiUser");
		if (loginUser == null || !loginUser.equals("admin")) {
			response.sendRedirect(request.getContextPath() + "/login.html");
			return;
		}
		
		String token = request.getParameter("token");
		if (token == null || token.isEmpty()) {
			response.sendError(400);
			return;
		}
		
		String tokensDir = getServletContext().getRealPath("/") + "/tokens";
		MdQuestionDatabase database = (MdQuestionDatabase)getServletContext().getAttribute("qdb");
		MdTestPaper paper = new MdTestPaper();
		paper.load(tokensDir, token);
		MdAnswerSheet mas = new MdAnswerSheet(database, paper);
		
		String viewUserName = mas.load(tokensDir, token);
		request.setAttribute("viewUserName", viewUserName);
		request.setAttribute("viewUserToken", token);
		request.setAttribute("viewUserScore", String.format("%.2f", mas.calcTotalScore()));
		
		// generate score details
		List<ViewScoreDetailObject> userDetailScores = new ArrayList<ViewScoreDetailObject>();
		ViewScoreDetailObject vsdo = new ViewScoreDetailObject();
		vsdo.setItemClass("");
		vsdo.setItemMaxScore(String.format("%.2f", mas.scScore * MdQuestionsGenerator.singleChoiceCount));
		vsdo.setItemName("单选题");
		int startIndex = userDetailScores.size();
		userDetailScores.add(vsdo);
		Map<String, Double> mapDetail = new HashMap<String, Double>();
		Map<String, Integer> mapDetailCount = new HashMap<String, Integer>();
		for (int i=0; i < database.getCategories().size(); ++i) {
			ViewScoreDetailObject vsdo2 = new ViewScoreDetailObject();
			vsdo2.setItemClass("indent-grid");
			vsdo2.setItemName("单选题 - " + database.getCategories().get(i));
			userDetailScores.add(vsdo2);
			mapDetail.put(database.getCategories().get(i), 0.0);
			mapDetailCount.put(database.getCategories().get(i), 0);
		}
		double totalScore = 0.0;
		for (int i=0; i < mas.singleChoicesScores.length; ++i) {
			String cate = mas.singleChoices.get(i).getCategoryName();
			Double sc = mas.singleChoicesScores[i] + mapDetail.get(cate);
			totalScore += mas.singleChoicesScores[i];
			int count = mapDetailCount.get(cate);
			mapDetail.put(cate, sc);
			mapDetailCount.put(cate, count + 1);
		}
		userDetailScores.get(startIndex).setItemScore(String.format("%.2f", totalScore));
		for (int i=0; i < database.getCategories().size(); ++i) {
			String cate = database.getCategories().get(i);
			userDetailScores.get(startIndex + 1 + i).setItemScore(String.format("%.2f", mapDetail.get(cate)));
			userDetailScores.get(startIndex + 1 + i).setItemMaxScore(String.format("%.2f", mapDetailCount.get(cate) * mas.scScore));
		}
		
		vsdo = new ViewScoreDetailObject();
		vsdo.setItemClass("");
		vsdo.setItemMaxScore(String.format("%.2f", mas.mcScore * MdQuestionsGenerator.multiChoiceCount));
		vsdo.setItemName("多选题");
		startIndex = userDetailScores.size();
		userDetailScores.add(vsdo);
		mapDetail.clear();
		mapDetailCount.clear();
		for (int i=0; i < database.getCategories().size(); ++i) {
			ViewScoreDetailObject vsdo2 = new ViewScoreDetailObject();
			vsdo2.setItemClass("indent-grid");
			vsdo2.setItemMaxScore(String.format("%.2f", mas.mcScore));
			vsdo2.setItemName("多选题 - " + database.getCategories().get(i));
			userDetailScores.add(vsdo2);
			mapDetail.put(database.getCategories().get(i), 0.0);
			mapDetailCount.put(database.getCategories().get(i), 0);
		}
		totalScore = 0.0;
		for (int i=0; i < mas.multiChoicesScores.length; ++i) {
			String cate = mas.multiChoices.get(i).getCategoryName();
			Double sc = mas.multiChoicesScores[i] + mapDetail.get(cate);
			totalScore += mas.multiChoicesScores[i];
			int count = mapDetailCount.get(cate);
			mapDetail.put(cate, sc);
			mapDetailCount.put(cate, count + 1);
		}
		userDetailScores.get(startIndex).setItemScore(String.format("%.2f", totalScore));
		for (int i=0; i < database.getCategories().size(); ++i) {
			String cate = database.getCategories().get(i);
			userDetailScores.get(startIndex + 1 + i).setItemScore(String.format("%.2f", mapDetail.get(cate)));
			userDetailScores.get(startIndex + 1 + i).setItemMaxScore(String.format("%.2f", mapDetailCount.get(cate) * mas.mcScore));
		}
		
		vsdo = new ViewScoreDetailObject();
		vsdo.setItemClass("");
		vsdo.setItemMaxScore(String.format("%.2f", mas.jdScore * MdQuestionsGenerator.judgementCount));
		vsdo.setItemName("判断题");
		startIndex = userDetailScores.size();
		userDetailScores.add(vsdo);
		mapDetail.clear();
		mapDetailCount.clear();
		for (int i=0; i < database.getCategories().size(); ++i) {
			ViewScoreDetailObject vsdo2 = new ViewScoreDetailObject();
			vsdo2.setItemClass("indent-grid");
			vsdo2.setItemMaxScore(String.format("%.2f", mas.jdScore));
			vsdo2.setItemName("判断题 - " + database.getCategories().get(i));
			userDetailScores.add(vsdo2);
			mapDetail.put(database.getCategories().get(i), 0.0);
			mapDetailCount.put(database.getCategories().get(i), 0);
		}
		totalScore = 0.0;
		for (int i=0; i < mas.judgmentsScores.length; ++i) {
			String cate = mas.judgments.get(i).getCategoryName();
			Double sc = mas.judgmentsScores[i] + mapDetail.get(cate);
			totalScore += mas.judgmentsScores[i];
			int count = mapDetailCount.get(cate);
			mapDetail.put(cate, sc);
			mapDetailCount.put(cate, count + 1);
		}
		userDetailScores.get(startIndex).setItemScore(String.format("%.2f", totalScore));
		for (int i=0; i < database.getCategories().size(); ++i) {
			String cate = database.getCategories().get(i);
			userDetailScores.get(startIndex + 1 + i).setItemScore(String.format("%.2f", mapDetail.get(cate)));
			userDetailScores.get(startIndex + 1 + i).setItemMaxScore(String.format("%.2f", mapDetailCount.get(cate) * mas.jdScore));
		}
		
		request.setAttribute("userDetailScores", userDetailScores);
		
		// single choice list
		List<ViewChoiceObject> singles = new ArrayList<ViewChoiceObject>();
		for (int i=0 ; i < mas.singleChoices.size(); ++i) {
			ViewChoiceObject o = new ViewChoiceObject();
			MdChoiceQuestion q = mas.singleChoices.get(i);
			String[] answerChecked = new String[q.getChoices().size()];
			String[] answerClass = new String[q.getChoices().size()];
			
			o.setMaxScore(String.format("%.2f", mas.scScore));
			o.setQuestion(q);
			o.setScore(String.format("%.2f", mas.singleChoicesScores[i]));
			for (int j=0; j < q.getChoices().size(); ++j) {
				answerChecked[j] = mas.singleChoicesAnswers[i].indexOf('0' + j) != -1 ? "checked" : "";
				if (answerChecked[j].equals("checked") && q.getChoices().get(j).isCorrect()) {
					answerClass[j] = "correct-answer";
				} else if (answerChecked[j].equals("checked") && !q.getChoices().get(j).isCorrect()) {
					answerClass[j] = "error-answer";
				} else if (answerChecked[j].isEmpty() && q.getChoices().get(j).isCorrect()) {
					answerClass[j] = "missed-answer";
				} else {
					answerClass[j] = "";
				}
			}
			o.setAnswerChecked(answerChecked);
			o.setAnswerClass(answerClass);
			singles.add(o);
		}
		request.setAttribute("singles", singles);
		
		// multi choices list
		List<ViewChoiceObject> multis = new ArrayList<ViewChoiceObject>();
		for (int i=0 ; i < mas.multiChoices.size(); ++i) {
			ViewChoiceObject o = new ViewChoiceObject();
			MdChoiceQuestion q = mas.multiChoices.get(i);
			String[] answerChecked = new String[q.getChoices().size()];
			String[] answerClass = new String[q.getChoices().size()];
			
			o.setMaxScore(String.format("%.2f", mas.mcScore));
			o.setQuestion(q);
			o.setScore(String.format("%.2f", mas.multiChoicesScores[i]));
			for (int j=0; j < q.getChoices().size(); ++j) {
				answerChecked[j] = mas.multiChoicesAnswers[i].indexOf('0' + j) != -1 ? "checked" : "";
				if (answerChecked[j].equals("checked") && q.getChoices().get(j).isCorrect()) {
					answerClass[j] = "correct-answer";
				} else if (answerChecked[j].equals("checked") && !q.getChoices().get(j).isCorrect()) {
					answerClass[j] = "error-answer";
				} else if (answerChecked[j].isEmpty() && q.getChoices().get(j).isCorrect()) {
					answerClass[j] = "missed-answer";
				} else {
					answerClass[j] = "";
				}
			}
			o.setAnswerChecked(answerChecked);
			o.setAnswerClass(answerClass);
			multis.add(o);
		}
		request.setAttribute("multis", multis);
		
		// judgments list
		List<ViewJudgmentObject> judgments = new ArrayList<ViewJudgmentObject>();
		for (int i=0 ; i < mas.judgments.size(); ++i) {
			ViewJudgmentObject o = new ViewJudgmentObject();
			MdJudgementQuestion q = mas.judgments.get(i);
			
			o.setMaxScore(String.format("%.2f", mas.jdScore));
			o.setQuestion(q);
			o.setScore(String.format("%.2f", mas.judgmentsScores[i]));
			if (mas.judgmentsAnswers[i].equals("T")) {
				o.setAnswerChecked("checked");
				if (q.isCorrect())
					o.setAnswerClass("correct-answer");
				else
					o.setAnswerClass("error-answer");
			} else {
				o.setAnswerChecked("");
				if (!q.isCorrect())
					o.setAnswerClass("correct-answer");
				else
					o.setAnswerClass("error-answer");
			}
			judgments.add(o);
		}
		request.setAttribute("judgments", judgments);
		
		request.getRequestDispatcher("/yuduki/view.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {
		
	}

}
