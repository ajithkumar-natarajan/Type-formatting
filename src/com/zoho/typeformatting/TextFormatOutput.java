package com.zoho.typeformatting;

public class TextFormatOutput extends Output {
	public void dispOutput(String str, int formatType) {
		if(formatType==1)
			System.out.println(str.toUpperCase());
		else
			System.out.println(str.toLowerCase());
	}
}