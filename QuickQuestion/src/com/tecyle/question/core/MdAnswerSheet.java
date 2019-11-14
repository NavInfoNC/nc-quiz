package com.tecyle.question.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class MdAnswerSheet {
	public List<MdChoiceQuestion> singleChoices;
	public List<MdChoiceQuestion> multiChoices;
	public List<MdJudgementQuestion> judgments;
	public String[] singleChoicesAnswers;
	public String[] multiChoicesAnswers;
	public String[] judgmentsAnswers;
	public double[] singleChoicesScores;
	public double[] multiChoicesScores;
	public double[] judgmentsScores;
	public double scScore;
	public double mcScore;
	public double jdScore;
	
	static final int singleChoiceScore = 2;
	static final int multiChoiceScore = 4;
	static final int judgmentScore = 1;
	
	public MdAnswerSheet(MdQuestionDatabase database, MdTestPaper paper) {
		singleChoices = database.pickUpSingleChoicesFromPaper(paper);
		multiChoices = database.pickUpMultiChoicesFromPaper(paper);
		judgments = database.pickUpJudgementsFromPaper(paper);
		singleChoicesAnswers = new String[singleChoices.size()];
		multiChoicesAnswers = new String[multiChoices.size()];
		judgmentsAnswers = new String[judgments.size()];
		singleChoicesScores = new double[singleChoices.size()];
		multiChoicesScores = new double[multiChoices.size()];
		judgmentsScores = new double[judgments.size()];
		
		double totalScore = singleChoiceScore * singleChoices.size()
				+ multiChoiceScore * multiChoices.size()
				+ judgmentScore * judgments.size();
		scScore = 100.0 / totalScore * singleChoiceScore;
		mcScore = 100.0 / totalScore * multiChoiceScore;
		jdScore = 100.0 / totalScore * judgmentScore;
	}
	
	public void markSingleChoiceScore(int id, String choice) {
		singleChoicesAnswers[id] = choice;
		
		// check if answer is correct
		MdChoiceQuestion q = singleChoices.get(id);
		double score = 0.0;
		if (!choice.isEmpty())
			score = q.getChoices().get(choice.charAt(0) - '0').isCorrect() ? scScore : 0.0;
		singleChoicesScores[id] = score;
	}
	
	public void markMultiChoicesScore(int id, String choices) {
		multiChoicesAnswers[id] = choices;
		
		// counting the score
		MdChoiceQuestion q = multiChoices.get(id);
		int answerCount = 0;
		for (MdQuestionChoice c : q.getChoices()) {
			if (c.isCorrect())
				answerCount++;
		}
		int eachAnswerScore = 60 / answerCount;
		int originalScore = 0;
		for (int i=0; i < choices.length(); ++i) {
			if (q.getChoices().get(choices.charAt(i) - '0').isCorrect()) {
				originalScore += eachAnswerScore;
			} else {
				originalScore -= eachAnswerScore;
			}
		}
		// unchecked answer are not given score
		if (originalScore < 0)
			originalScore = 0;
		double score = mcScore * originalScore / 60.0;
		multiChoicesScores[id] = score;
	}
	
	public void markJudgmentScore(int id, String tf) {
		judgmentsAnswers[id] = tf;
		
		MdJudgementQuestion q = judgments.get(id);
		double score = 0.0;
		if (q.isCorrect() && tf.equals("T") || !q.isCorrect() && tf.equals("F")) {
			score = jdScore;
		}
		judgmentsScores[id] = score;
	}
	
	public void save(String tokensDir, String userName, String token) {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(tokensDir + "/" + token + ".a"), "utf-8"));
			if (userName == null) {
				// session is timeout, and so the userName is null, reload it from {token}.a file
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(tokensDir + "/" + token + ".q"), "utf-8"));
				userName = reader.readLine().trim();
				reader.close();
			}
			if (userName != null)
				writer.write(userName);
			writer.newLine();
			writer.write(token);
			writer.newLine();
			writer.write(calcTotalScore() + "");
			writer.newLine();
			
			// writing user answers
			for (int i=0; i < singleChoicesAnswers.length; ++i) {
				String ans = singleChoicesAnswers[i];
				if (ans.isEmpty())
					ans = "N";
				writer.write(ans + " ");
			}
			writer.newLine();
			for (int i=0; i < multiChoicesAnswers.length; ++i) {
				String ans = multiChoicesAnswers[i];
				if (ans.isEmpty())
					ans = "N";
				writer.write(ans + " ");
			}
			writer.newLine();
			for (int i=0; i < judgmentsAnswers.length; ++i) {
				writer.write(judgmentsAnswers[i] + " ");
			}
			writer.newLine();
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public double calcTotalScore() {
		double score = 0.0;
		for (double s : singleChoicesScores) {
			score += s;
		}
		for (double s : multiChoicesScores) {
			score += s;
		}
		for (double s : judgmentsScores) {
			score += s;
		}
		
		return score;
	}
	
	public String load(String tokensDir, String token) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(tokensDir + "/" + token + ".a"), "utf-8"));
			String userName = reader.readLine();
			reader.readLine();
			reader.readLine();
			
			String line = reader.readLine().trim();
			String[] ans = line.split(" ");
			for (int i=0; i < ans.length; ++i) {
				if (ans[i].equals("N"))
					ans[i] = "";
				markSingleChoiceScore(i, ans[i]);
			}
			
			line = reader.readLine().trim();
			ans = line.split(" ");
			for (int i=0; i < ans.length; ++i) {
				if (ans[i].equals("N"))
					ans[i] = "";
				markMultiChoicesScore(i, ans[i]);
			}
			
			line = reader.readLine().trim();
			ans = line.split(" ");
			for (int i=0; i < ans.length; ++i) {
				markJudgmentScore(i, ans[i]);
			}
			
			reader.close();
			return userName;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
