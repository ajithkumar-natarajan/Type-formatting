package com.zoho.typeformattingv2;

import com.zoho.typeformattingv2.FormatStyles.NumberFormatChoice;

public class FormatNumber extends FormatData {
public String computeResult(String dataInput, Enum<? extends FormatChoices> UserFormatChoice) {
		
		if(UserFormatChoice == NumberFormatChoice.INDIAN_SYSTEM) {
			int flag = 1;
			return indianRepresentation(dataInput, flag);
		}
		else
			return internationalRepresentation(dataInput);
	}
	
	public String indianRepresentation(String inputNumber, int flag) {
		String formatResult;
		if(flag!=1) {
			if (inputNumber.length() == 2) {
				return inputNumber;
			} else if (inputNumber.length() > 2) {
				formatResult = indianRepresentation(inputNumber.substring(0, inputNumber.length()-2), flag)+","+inputNumber.substring(inputNumber.length() - 2);
				return formatResult;
			}
				else
				return inputNumber;
		}
		else {
			if (inputNumber.length() == 3) {
				flag = 2;
				return inputNumber;
			} else if (inputNumber.length() > 3) {
				flag = 2;
				formatResult = indianRepresentation(inputNumber.substring(0, inputNumber.length()-3), flag)+","+inputNumber.substring(inputNumber.length() - 3);
				return formatResult;
			}
				else {
					flag = 2;
					return inputNumber;
				}
		}
			
	}
	
	public String internationalRepresentation(String number) {
		String formatResult;
		if (number.length() == 3) {
			return number;
		} else if (number.length() > 3) {
			formatResult = internationalRepresentation(number.substring(0, number.length()-3))+","+number.substring(number.length() - 3);
			return formatResult;
		}
			else
			return number;
	}
}