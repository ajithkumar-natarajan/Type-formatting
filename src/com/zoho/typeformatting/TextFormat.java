package com.zoho.typeformatting;

import java.util.Scanner;
//public class TextFormat implements Formats{
public class TextFormat extends Formats{
//	private Scanner input;
//	private FormatData data;
//	private int formatChoice;
	
	public TextFormat() {
		input = new Scanner(System.in);
		output = new TextFormatOutput();
	}
	
	public int getFormat() {
		System.out.println("Choose the desired format:");
		System.out.println("1. Uppercase");
		System.out.println("2. Lowercase");
		formatChoice = input.nextInt();
		
		return formatChoice;
	}
	
	public int getFormatChoice() {
		return formatChoice;
	}
	
	public boolean checkFormatValidity(String str) throws Exception {
		if((str.matches("[a-zA-Z]+")))
			return true;
		else
//			System.out.println("Type text cannot contain numbers!");
			throw new Exception("Type text cannot contain numbers!");
	}
	
	public void formatData(String str, int formatType) {
		output.dispOutput(str, formatType);
	}
}