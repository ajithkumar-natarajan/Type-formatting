package com.zoho.typeformatting;

import com.zoho.typeformatting.TextFormatChoiceValidator.TextFormatChoice;

public class PrintTextFormattedData extends PrintFormattedData {
	public void dispFormattingResult(String dataInput, Enum<? extends FormatChoices> UserFormatChoice) {
		if(UserFormatChoice == TextFormatChoice.CAPITAL_LETTERS)
			System.out.println(dataInput.toUpperCase());
		else
			System.out.println(dataInput.toLowerCase());
	}
}