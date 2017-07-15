package com.zoho.typeformatting;

import java.util.Scanner;
//public class ScientificFormat implements Formats{
public class ScientificFormat extends Formats{
//	private Scanner input;
//	private FormatData data;
//	private int formatChoice;
	
	public ScientificFormat() {
		input = new Scanner(System.in);
		output = new ScientificFormatOutput();
	}
	
	public int getFormat() {
		System.out.println("Choose the desired format:");
		System.out.println("1. #.##E##");
		System.out.println("1. #.###E#");
		formatChoice = input.nextInt();
		
		return formatChoice;
	}
	
	public int getFormatChoice() {
		return formatChoice;
	}
	
	public boolean checkFormatValidity(String str) throws Exception {
		if(str.matches("[0-9]+"))
			return true;
		else
			throw new Exception("Type scientific cannot contain letters!");
	}
	
	public void formatData(String str, int formatType) {
		output.dispOutput(str, formatType);
	}
}