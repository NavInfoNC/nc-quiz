package com.tecyle.question.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MdQuestionsGenerator {
    private MdQuestionDatabase questions;
    private List<Integer> questionWeights;
    public static final int singleChoiceCount = 30;
    public static final int multiChoiceCount = 10;
    public static final int judgementCount = 10;

    public MdQuestionsGenerator(MdQuestionDatabase questions) {
        this.questions = questions;
        questionWeights = new ArrayList<Integer>();
        for (int i=0; i < questions.categories.size(); ++i) {
            questionWeights.add(1);
        }
    }
    
    public MdTestPaper generateTestPaper() {
    	MdTestPaper paper = new MdTestPaper();
    	// generate single choices
    	paper.setSingleChoices(generateQuestionIndices(questions.singleChoiceQuestions, singleChoiceCount));
    	
    	// generate multiple choices
    	paper.setMultiChoices(generateQuestionIndices(questions.multipleChoicesQuestions, multiChoiceCount));
    	
    	// generate judgments
    	paper.setJudgements(generateQuestionIndices(questions.judgementQuestions, judgementCount));
    	
    	return paper;
    }
    
    private <T> List<List<Integer>> generateQuestionIndices(List<List<T>> questionList, int needCount) {
    	List<Integer> scQuestionCounts = generateEachCategoryQuestionCount(needCount);
    	List<List<Integer>> scs = new ArrayList<List<Integer>>();
    	for (int i=0; i < questions.categories.size(); ++i) {
    		int scCount = scQuestionCounts.get(i);
    		scs.add(giveQuestionIds(questionList.get(i).size(), scCount));
    	}
    	
    	return scs;
    }
    
    private List<Integer> giveQuestionIds(int questionCount, int needCount) {
    	assert questionCount >= needCount;
    	
    	int[] indices = new int[questionCount];
    	for (int i=0; i < indices.length; ++i) {
    		indices[i] = i;
    	}
    	
    	shuffle(indices);
    	List<Integer> res = new ArrayList<Integer>();
    	for (int i=0; i < needCount; ++i) {
    		res.add(indices[i]);
    	}
    	
    	return res;
    }
    
    private List<Integer> generateEachCategoryQuestionCount(int totalCount) {
    	int sum = 0;
    	int maxIndex = 0;
    	int maxWeight = questionWeights.get(0);
    	for (int i=0; i < questionWeights.size(); ++i) {
    		int w = questionWeights.get(i);
    		sum += w;
    		if (w > maxWeight) {
    			maxWeight = w;
    			maxIndex = i;
    		}
    	}
    	
    	List<Integer> res = new ArrayList<Integer>();
    	for (int w : questionWeights) {
    		int count = totalCount * w / sum;
    		// 如果计算的结果是 0，并且权重不是 0，则至少保留一题
    		if (count == 0 && w != 0)
    			count = 1;
    		res.add(count);
    	}
    	
    	// 检查题目总数是否正好相等
        sum = 0;
        for (Integer s : res) {
            sum += s;
        }
        // 多余或者缺少的题目从权重最高的题目里补充
        res.set(maxIndex, res.get(maxIndex) - (sum - totalCount));
        
        return res;
    }

    public void setQuestionWeights(List<Integer> weights) {
        questionWeights = weights;
    }

    private void shuffle(int[] a) {
        Random rdm = new Random();

        for (int i=0; i < a.length; ++i) {
            int index = rdm.nextInt(a.length - i) + i;
            int tp = a[index];
            a[index] = a[i];
            a[i] = tp;
        }
    }
}
