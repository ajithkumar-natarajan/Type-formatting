package com.zoho.typeformatting;

import java.util.Scanner;
//public class NumberFormat implements Formats{
public class NumberFormat extends Formats{
//	private Scanner input;
//	private FormatData data;
//	private int formatChoice;
	
	public NumberFormat() {
		input = new Scanner(System.in);
		output = new NumberFormatOutput();
	}
	
	public int getFormat() {
		System.out.println("Choose the desired format:");
		System.out.println("1. Indian numeral system");
		System.out.println("2. International numeral system");
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
			throw new Exception("Type number cannot contain letters!");
	}
	
	public void formatData(String str, int formatType) {
		output.dispOutput(str, formatType);
	}
}