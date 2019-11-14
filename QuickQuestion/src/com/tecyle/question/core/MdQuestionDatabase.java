package com.tecyle.question.core;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class FileLinesEntry {
    List<String> lines;
    int cursor;

    boolean canContinueRead() {
        return cursor < lines.size();
    }

    void nextLine() {
        if (canContinueRead())
            cursor++;
    }

    String getCurrentLine() {
        if (!canContinueRead())
            return null;

        return lines.get(cursor);
    }
}

public class MdQuestionDatabase {
	public List<String> getCategories() {
		return categories;
	}

	List<String> categories;
	List<List<MdChoiceQuestion>> singleChoiceQuestions;
	List<List<MdChoiceQuestion>> multipleChoicesQuestions;
	List<List<MdJudgementQuestion>> judgementQuestions;
	
    public void loadQuestionsFromFile(String fileName, String contentPath) {
        List<String> lines = loadTextFromFile(fileName);
        if (lines == null)
            return;

        FileLinesEntry entry = new FileLinesEntry();
        entry.lines = lines;
        entry.cursor = 0;
        
        categories = new ArrayList<String>();
        singleChoiceQuestions = new ArrayList<List<MdChoiceQuestion>>();
        multipleChoicesQuestions = new ArrayList<List<MdChoiceQuestion>>();
        judgementQuestions = new ArrayList<List<MdJudgementQuestion>>();
        
        while (entry.canContinueRead()) {
        	skipEmptyLines(entry);
        	String line = entry.getCurrentLine();
        	if (line == null)
        		break;
        	
        	assert line.startsWith("# ");
        	String categoryName = line.substring(2).trim();
        	categories.add(categoryName);
        	singleChoiceQuestions.add(new ArrayList<MdChoiceQuestion>());
        	multipleChoicesQuestions.add(new ArrayList<MdChoiceQuestion>());
        	judgementQuestions.add(new ArrayList<MdJudgementQuestion>());
        	entry.nextLine();
        	loadOneCategory(entry, categoryName, contentPath);
        }
    }
    
    private void loadOneCategory(FileLinesEntry e, String cn, String contentPath) {
    	while (true) {
    		skipEmptyLines(e);
    		String line = e.getCurrentLine();
    		if (line == null || line.startsWith("# "))
    			return;
    		
    		assert line.startsWith("## ");
    		e.nextLine();
    		String questionType = line.substring(3).trim();
    		if (questionType.equals("单选题")) {
    			loadChoices(e, cn, true, contentPath);
    		} else if (questionType.equals("多选题")) {
    			loadChoices(e, cn, false, contentPath);
    		} else if (questionType.equals("判断题")) {
    			loadJudgements(e, cn, contentPath);
    		} else {
    			throw new RuntimeException("Unsupported question type!");
    		}
    	}
    }
    
    private void loadJudgements(FileLinesEntry e, String cn, String contentPath) {
    	while (true) {
    		skipEmptyLines(e);
    		String line = e.getCurrentLine();
    		if (line == null || line.charAt(0) == '#')
    			return;
    		
    		assert line.startsWith("* [ ] ") || line.startsWith("* [x] ")
    			|| line.startsWith("* ( ) ") || line.startsWith("* (x) ");
    		MdJudgementQuestion q = new MdJudgementQuestion();
    		q.setCorrect(line.charAt(3) == 'x');
    		q.setTitle(MdInlineMarkupTransformer.transform(line.substring(5).trim(), contentPath));
    		q.setCategoryName(cn);
    		judgementQuestions.get(judgementQuestions.size() - 1).add(q);
    		e.nextLine();
    	}
    }
    
    private void loadChoices(FileLinesEntry e, String cn, boolean isSingle, String contentPath) {
    	StringBuilder sb = new StringBuilder();
    	while (true) {
    		skipEmptyLines(e);
    		String line = e.getCurrentLine();
    		if (line == null || line.charAt(0) == '#')
    			return;
    		
    		// all paragraphs before * is question title.
    		if (line.startsWith("```")) {
    			appendCodeBlock(sb, e);
    		} else if (!line.startsWith("* [ ] ") && !line.startsWith("* [x] ")
    				&& !line.startsWith("* ( ) ") && !line.startsWith("* (x) ")) {
    			appendParagraph(sb, e, contentPath);
    		} else {
    			MdChoiceQuestion q = new MdChoiceQuestion();
    			q.setTitle(sb.toString());
    			sb = new StringBuilder();
    			
    			List<MdQuestionChoice> cs = new ArrayList<MdQuestionChoice>();
    			q.setChoices(cs);
    			loadChoices(q, e, contentPath);
    			
    			q.setCategoryName(cn);
    			if (isSingle)
    				singleChoiceQuestions.get(singleChoiceQuestions.size() - 1).add(q);
    			else
    				multipleChoicesQuestions.get(multipleChoicesQuestions.size() - 1).add(q);
    		}
    	}
    }
    
    private void loadChoices(MdChoiceQuestion q, FileLinesEntry e, String contentPath) {
    	while (true) {
    		skipEmptyLines(e);
    		String line = e.getCurrentLine();
    		if (line == null || line.charAt(0) != '*')
    			return;
    		
    		boolean isAnswer = line.charAt(3) == 'x';
    		String choiceText = line.substring(5).trim();
    		MdQuestionChoice c = new MdQuestionChoice();
    		c.setDescription(MdInlineMarkupTransformer.transform(choiceText, contentPath));
    		c.setCorrect(isAnswer);
    		q.getChoices().add(c);
    		
    		e.nextLine();
    	}
    }
    
    private void appendParagraph(StringBuilder sb, FileLinesEntry e, String contentPath) {
    	String line = e.getCurrentLine();
    	sb.append("<p>");
    	while (line != null && !line.isEmpty()) {
    		sb.append(MdInlineMarkupTransformer.transform(line, contentPath));
    		e.nextLine();
    		line = e.getCurrentLine();
    	}
    	sb.append("</p>");
    }
    
    private void appendCodeBlock(StringBuilder sb, FileLinesEntry e) {
    	String line = e.getCurrentLine();
    	String language = line.substring(3).trim();
    	if (language.isEmpty())
    		language = "cpp";
    	
    	sb.append("<p><pre class=\"line-numbers\"><code class=\"language-" + language + "\">");
    	e.nextLine();
    	line = e.getCurrentLine();
    	boolean isFirstLine = true;
    	while (!line.startsWith("```")) {
    		if (isFirstLine)
    			isFirstLine = false;
    		else
    			sb.append("\r\n");
    		
    		sb.append(MdInlineMarkupTransformer.transformReserved(line));
    		e.nextLine();
    		line = e.getCurrentLine();
    	}
    	
    	e.nextLine();
    	sb.append("</code></pre></p>");
    }

    private List<String> loadTextFromFile(String file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(isr);
            String line;
            List<String> lines = new ArrayList<String>();
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            return lines;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void skipEmptyLines(FileLinesEntry e) {
        String line = e.getCurrentLine();
        while (line != null && line.isEmpty()) {
            e.nextLine();
            line = e.getCurrentLine();
        }
    }
    
    public List<MdChoiceQuestion> pickUpSingleChoicesFromPaper(MdTestPaper paper) {
    	return pickUpQuestions(paper.getSingleChoices(), singleChoiceQuestions);
    }
    
    public List<MdChoiceQuestion> pickUpMultiChoicesFromPaper(MdTestPaper paper) {
    	return pickUpQuestions(paper.getMultiChoices(), multipleChoicesQuestions);
    }
    
    public List<MdJudgementQuestion> pickUpJudgementsFromPaper(MdTestPaper paper) {
    	return pickUpQuestions(paper.getJudgements(), judgementQuestions);
    }
    
    private <T> List<T> pickUpQuestions(List<List<Integer>> srcIds, List<List<T>> src) {
    	List<T> questions = new ArrayList<T>();
    	
    	List<List<Integer>> scCates = srcIds;
    	for (int i=0; i < scCates.size(); ++i) {
    		List<T> srcQuestions = src.get(i);
    		for (int id : scCates.get(i)) {
    			questions.add(srcQuestions.get(id));
    		}
    	}
    	
    	return questions;
    }
}
