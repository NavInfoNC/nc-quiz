package com.tecyle.question.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class MdTestPaper {
	private List<List<Integer>> singleChoices;
	private List<List<Integer>> multiChoices;
	private List<List<Integer>> judgements;
	public List<List<Integer>> getSingleChoices() {
		return singleChoices;
	}
	public void setSingleChoices(List<List<Integer>> singleChoices) {
		this.singleChoices = singleChoices;
	}
	public List<List<Integer>> getMultiChoices() {
		return multiChoices;
	}
	public void setMultiChoices(List<List<Integer>> multiChoices) {
		this.multiChoices = multiChoices;
	}
	public List<List<Integer>> getJudgements() {
		return judgements;
	}
	public void setJudgements(List<List<Integer>> judgements) {
		this.judgements = judgements;
	}
	
	private void saveIds(BufferedWriter writer, List<List<Integer>> ids) throws IOException {
		writer.write(ids.size() + "");
		writer.newLine();
		for (int i=0; i < ids.size(); ++i) {
			List<Integer> innerIds = ids.get(i);
			for (int id : innerIds) {
				writer.write(id + " ");
			}
			writer.newLine();
		}
	}
	
	public void save(String filePath, String userName, String token) {
		try {
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filePath + "/" + token + ".q"), "utf-8"));
			writer.write(userName);
			writer.newLine();
			writer.write(token);
			writer.newLine();
			
			saveIds(writer, singleChoices);
			saveIds(writer, multiChoices);
			saveIds(writer, judgements);
			
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void loadIds(BufferedReader reader, List<List<Integer>> ids) throws NumberFormatException, IOException {
		int count = Integer.parseInt(reader.readLine());
		for (int i=0; i < count; ++i) {
			String line = reader.readLine().trim();
			String[] idStr = line.split(" ");
			List<Integer> innerIds = new ArrayList<Integer>();
			for (String s : idStr) {
				innerIds.add(Integer.parseInt(s));
			}
			ids.add(innerIds);
		}
	}
	
	public String load(String filePath, String token) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(filePath + "/" + token + ".q"), "utf-8"));
			String userName = reader.readLine();
			reader.readLine();
			
			singleChoices = new ArrayList<List<Integer>>();
			loadIds(reader, singleChoices);
			multiChoices = new ArrayList<List<Integer>>();
			loadIds(reader, multiChoices);
			judgements = new ArrayList<List<Integer>>();
			loadIds(reader, judgements);
			
			reader.close();
			return userName;
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
