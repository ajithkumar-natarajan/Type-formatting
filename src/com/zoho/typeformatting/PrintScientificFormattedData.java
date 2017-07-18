package com.zoho.typeformatting;

import java.text.DecimalFormat;
import com.zoho.typeformatting.ScientificFormatChoiceValidator.ScientificFormatChoice;

public class PrintScientificFormattedData extends PrintFormattedData {
	public void dispFormattingResult(String dataInput, Enum<? extends FormatChoices> UserFormatChoice) {
		int userInput = Integer.parseInt(dataInput);
		if(UserFormatChoice == ScientificFormatChoice.TWO_DECIMALS) {
			DecimalFormat df = new DecimalFormat("0.00E00");
			System.out.println(df.format(userInput));
		}
		else {
			DecimalFormat df = new DecimalFormat("0.0000E0");
			System.out.println(df.format(userInput));
		}
	}
}