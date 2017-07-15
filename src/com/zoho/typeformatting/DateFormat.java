package com.zoho.typeformatting;

import java.util.Scanner;
//public class DateFormat implements Formats{
public class DateFormat extends Formats{
//	private Scanner input;
//	private FormatData data;
//	private int formatChoice;
	
	public DateFormat() {
		input = new Scanner(System.in);
		output = new DateFormatOutput();
	}
	
	public int getFormat() {
		System.out.println("Choose the desired format:");
		System.out.println("1. DD-MM-YYYY");
		System.out.println("2. DD-MMM-YYYY");
		formatChoice = input.nextInt();
		
		return formatChoice;
	}
	
	public int getFormatChoice() {
		return formatChoice;
	}
	
	public boolean checkFormatValidity(String str) throws Exception {
		if(str.matches("[0-9]+")) {
			if(str.length()==8) {
				if(!(Integer.parseInt(str.substring(0, 2))<32)) //&& (Integer.parseInt(str.substring(0, 2))>0))) {
					throw new Exception("Date must be smaller than or equal to 31");
				if(!(Integer.parseInt(str.substring(2, 4))<13)) //&& (Integer.parseInt(str.substring(0, 2))>0))) {
					throw new Exception("Month must be smaller than or equal to 12");
				//return true;
			} else if (str.length()<8)
				throw new Exception("Please prefix single digit month/date of month with 0");
			else
				throw new Exception("Date cannot be longer than 8 characters");
			return true;
			}
		else
			throw new Exception("Type date cannot contain letters!");
	}
	
	public void formatData(String str, int formatType) {
		output.dispOutput(str, formatType);
	}
}