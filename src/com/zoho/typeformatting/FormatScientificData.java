package com.zoho.typeformattingv2;

import java.text.DecimalFormat;
import com.zoho.typeformattingv2.FormatStyles.ScientificDataFormatChoice;

public class FormatScientificData extends FormatData {
	public String computeResult(String dataInput, Enum<? extends FormatChoices> UserFormatChoice) {
		int userInput = Integer.parseInt(dataInput);
		if(UserFormatChoice == ScientificDataFormatChoice.TWO_DECIMALS) {
			DecimalFormat decimalFormat = new DecimalFormat("0.00E00");
			return decimalFormat.format(userInput);
		}
		else {
			DecimalFormat decimalFormat = new DecimalFormat("0.0000E0");
			return decimalFormat.format(userInput);
		}
	}
}