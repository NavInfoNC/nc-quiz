package com.tecyle.question.core;

import java.util.ArrayList;
import java.util.List;

public class MdQuestionCategory {
    private String categoryName;
    private List<MdQuestion> questions = new ArrayList<MdQuestion>();

    public MdQuestionCategory(String name) {
        categoryName = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addQuestion(MdQuestion question) {
        questions.add(question);
    }

    public MdQuestion getQuestion(int index) {
        return questions.get(index);
    }

    public int getQuestionCount() {
        return questions.size();
    }
}
