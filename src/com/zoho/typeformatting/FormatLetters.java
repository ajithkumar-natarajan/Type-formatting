package com.zoho.typeformattingv2;

import com.zoho.typeformattingv2.FormatStyles.LettersFormatChoice;

public class FormatLetters extends FormatData {
	public String computeResult(String dataInput, Enum<? extends FormatChoices> UserFormatChoice) {
		if(UserFormatChoice == LettersFormatChoice.CAPITAL_LETTERS) {
			if(checkAllUpperCase(dataInput)) {
//				System.out.println(">>>>>");
				return dataInput;
			}
			return (dataInput.toUpperCase());
		}
		else {
			if(checkAllLowerCase(dataInput)) {
//				System.out.println("<<<<<");
				return dataInput;
			}
			return (dataInput.toLowerCase());
		}
	}
	
	public boolean checkAllUpperCase(String dataInput) {
		for(int index=0; index<=dataInput.length(); index++) {
			char character = dataInput.charAt(index);
			if(index == dataInput.length()-1) {
				return true;
			}
			if(character >= 65 && character <= 90) {
				continue;
			}
			else
			    return false;
		}
		return false;
	}
	
	public boolean checkAllLowerCase(String dataInput) {
		for(int index=0; index<=dataInput.length(); index++) {
			char character = dataInput.charAt(index);
			if(index == dataInput.length()-1) {
				return true;
			}
			if(character >= 97 && character <= 122) {
				continue;
			}
			else
			    return false;
		}
		return false;
	}
}