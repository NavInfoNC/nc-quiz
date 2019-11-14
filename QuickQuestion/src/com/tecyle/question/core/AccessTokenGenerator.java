package com.tecyle.question.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AccessTokenGenerator {
	static final String tokenChars = "abcdefghijklmnopqrstuvwxyz0123456789";
	
	public enum UserLoginState {
		FIRST_ACCESS, TESTING, ALREADY_SUBMITTED
	}
	
	public static Set<String> loadTokens(String tokensDir) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(tokensDir + "/available.tokens"));
			Set<String> res = new HashSet<String>();
			String line = reader.readLine();
			while (line != null) {
				res.add(line.trim());
				line = reader.readLine();
			}
			reader.close();
			return res;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static UserLoginState checkUserLoginState(String tokensDir, String token) {
		// if ${token}.q is not exist, user is first access
		File file = new File(tokensDir + "/" + token + ".q");
		if (!file.exists()) {
			return UserLoginState.FIRST_ACCESS;
		}
		// if ${token}.a is exist, user is already commited answser
		file = new File(tokensDir + "/" + token + ".a");
		if (file.exists()) {
			return UserLoginState.ALREADY_SUBMITTED;
		}
		
		return UserLoginState.TESTING;
	}
	
	public static List<String> generateTokens(int genCount, int tokenLength) {
		Set<String> tokenSet = new HashSet<String>();
		List<String> tokens = new ArrayList<String>();
		
		while (tokens.size() < genCount) {
			String token = generateOneToken(tokenLength);
			if (tokenSet.contains(token))
				continue;
			
			tokens.add(token);
			tokenSet.add(token);
		}
		
		return tokens;
	}
	
	public static void resetTokensWorkspace(String tokensDir, List<String> newTokens) {
		// Firstly, clear all files in tokensDir
		File file = new File(tokensDir);
		if (!file.exists()) {
			file.mkdirs();
		}
		
		// Zip this dir
		File[] subFiles = file.listFiles();
		for (int i=0; i < subFiles.length; ++i) {
			subFiles[i].delete();
		}
		
		// Secondly, generate available.tokens file
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(tokensDir + "/available.tokens"));
			for (String token : newTokens) {
				writer.write(token);
				writer.newLine();
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String generateOneToken(int tokenLength) {
		Random rdm = new Random();
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < tokenLength; ++i) {
			sb.append(tokenChars.charAt(rdm.nextInt(tokenChars.length())));
		}
		
		return sb.toString();
	}
}
