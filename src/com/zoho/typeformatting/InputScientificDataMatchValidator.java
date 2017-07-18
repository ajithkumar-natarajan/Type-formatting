package com.zoho.typeformattingv2;

public class InputScientificDataMatchValidator extends InputDatatypeMatchValidator {
	public boolean validate(String dataInput) {
		if(dataInput.contains(".")) {
			if(dataInput.substring(0, 1).matches("[0-9]+") && dataInput.substring(1, 2).matches(".") && dataInput.substring(2, 4).matches("[0-9]+"))
				if(dataInput.substring(4, 5).matches("E") && dataInput.substring(5, 7).matches("[0-9]+"))
					return true;
				else if(dataInput.substring(4, 6).matches("[0-9]+") && dataInput.substring(6, 7).matches("E") && dataInput.substring(7, 8).matches("[0-9]+"))
					return true;
				else
					return false;
			else
				return false;
		}
		if(dataInput.replaceFirst("\\.", "").replaceFirst("E", "").matches("[0-9]+")) {	
			return true;
		}
		else
			return false;
	}
}