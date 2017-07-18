package com.zoho.typeformattingv2;

public class InputLettersMatchValidator extends InputDatatypeMatchValidator {
	public boolean validate(String dataInput) {
		if((dataInput.matches("[a-zA-Z]+")))
			return true;
		else
			return false;
	}
}