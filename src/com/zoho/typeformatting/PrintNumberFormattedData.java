package com.zoho.typeformatting;

import com.zoho.typeformatting.NumberFormatChoiceValidator.NumberFormatChoice;

public class PrintNumberFormattedData extends PrintFormattedData {
	public void dispFormattingResult(String dataInput, Enum<? extends FormatChoices> UserFormatChoice) {
		
		if(UserFormatChoice == NumberFormatChoice.INDIAN_SYSTEM) {
			int flag = 1;
			System.out.println(getIndianNumeralFormat(dataInput, flag));
		}
		else
			System.out.println(getInternationalNumeralFormat(dataInput));
	}
	
	public String getIndianNumeralFormat(String inputNumber, int flag) {
		String formatResult;
		if(flag!=1) {
			if (inputNumber.length() == 2) {
				return inputNumber;
			} else if (inputNumber.length() > 2) {
				formatResult = getIndianNumeralFormat(inputNumber.substring(0, inputNumber.length()-2), flag)+","+inputNumber.substring(inputNumber.length() - 2);
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
				formatResult = getIndianNumeralFormat(inputNumber.substring(0, inputNumber.length()-3), flag)+","+inputNumber.substring(inputNumber.length() - 3);
				return formatResult;
			}
				else {
					flag = 2;
					return inputNumber;
				}
		}
			
	}
	
	public String getInternationalNumeralFormat(String number) {
		String formatResult;
		if (number.length() == 3) {
			return number;
		} else if (number.length() > 3) {
			formatResult = getInternationalNumeralFormat(number.substring(0, number.length()-3))+","+number.substring(number.length() - 3);
			return formatResult;
		}
			else
			return number;
	}
}