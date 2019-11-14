package com.tecyle.question.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MdInlineMarkupTransformer {
    static Pattern inlineMarkupPattern = Pattern.compile("\\*\\*(.+?)\\*\\*|\\*(.+?)\\*|`(.+?)`|!\\[(.+?)\\]\\((.+?)\\)");

    static String escape(char ch) {
    	switch (ch) {
    	case '<':
    		return "&lt;";
    	case '>':
    		return "&gt;";
    	default:
    		return ch + "";
    	}
    }
    
    static public String transformReserved(String s) {
    	s = s.replace("<", "&lt;");
    	return s.replace(">", "&gt;");
    }
    
    static public String transform(String inlineText, String contentPath) {
        StringBuilder result = new StringBuilder();
        Matcher m = inlineMarkupPattern.matcher(inlineText);
        
        int lastEnd = 0;
        while (m.find()) {
        	result.append(transformReserved(inlineText.substring(lastEnd, m.start())));
        	if (m.group(1) != null && !m.group(1).isEmpty()) {
        		result.append("<strong>" + transformReserved(m.group(1)) + "</strong>");
        	} else if (m.group(2) != null && !m.group(2).isEmpty()) {
        		result.append("<em>");
        		result.append(transformReserved(m.group(2)));
        		result.append("</em>");
        	} else if (m.group(3) != null && !m.group(3).isEmpty()) {
        		result.append("<code>");
        		result.append(transformReserved(m.group(3)));
        		result.append("</code>");
        	} else if (m.group(4) != null && !m.group(4).isEmpty()) {
        		result.append("<img alt=\"" + transformReserved(m.group(4)) + "\" src=\"" + contentPath + "/" + m.group(5) + "\">");
        	}
        	lastEnd = m.end();
        }

        result.append(inlineText.substring(lastEnd));
        
        return result.toString();
    }
}
