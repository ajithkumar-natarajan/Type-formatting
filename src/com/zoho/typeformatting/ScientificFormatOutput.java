package com.zoho.typeformatting;

import java.text.DecimalFormat;

public class ScientificFormatOutput extends Output {
	public void dispOutput(String str, int formatType) {
		int input;
		input = Integer.parseInt(str);
		if(formatType==1)
			System.out.println(printScientificFormatOne(input));
		else
			System.out.println(printScientificFormatTwo(input));
	}
	
	public String printScientificFormatOne(int number) {
//		String result;
		DecimalFormat df = new DecimalFormat("0.00E00");
		return df.format(number);
	}
	
	public String printScientificFormatTwo(int number) {
//		String result;
		DecimalFormat df = new DecimalFormat("0.000E0");
		return df.format(number);
	}
}