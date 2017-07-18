package com.zoho.typeformattingv2;

public class InputDateMatchValidator extends InputDatatypeMatchValidator {
	public boolean validate(String dataInput) {
		if(dataInput.matches("[0-9]+")) {
			if(dataInput.length()==8) {
				if(!(Integer.parseInt(dataInput.substring(0, 2))<32))
					return false;
				else if(!(Integer.parseInt(dataInput.substring(2, 4))<13))
					return false;
			} else
				return false;
			return true;
		} else if(dataInput.contains("-") || dataInput.contains(",")) {
			if(dataInput.contains("-") && !dataInput.contains(",")) {
				if(!(Integer.parseInt(dataInput.substring(0, 2))<32))
					return false;
				else if(!(Integer.parseInt(dataInput.substring(3, 5))<13))
					return false;
				else if(!(dataInput.substring(6, 10).matches("[0-9]+")))
					return false;
				else
					return true;
			} else if(dataInput.contains(",")) {
				if(!(Integer.parseInt(dataInput.substring(0, 2))<32))
					return false;
				if(!(dataInput.substring(8, 12).matches("[0-9]+")))
					return false;
				if(dataInput.substring(3, 6).compareTo("Jan")==0)
					return true;
				else if(dataInput.substring(3, 6).compareTo("Feb")==0)
					return true;
				else if(dataInput.substring(3, 6).compareTo("Mar")==0)
					return true;
				else if(dataInput.substring(3, 6).compareTo("Apr")==0)
					return true;
				else if(dataInput.substring(3, 6).compareTo("May")==0)
					return true;
				else if(dataInput.substring(3, 6).compareTo("Jun")==0)
					return true;
				else if(dataInput.substring(3, 6).compareTo("Jul")==0)
					return true;
				else if(dataInput.substring(3, 6).compareTo("Aug")==0)
					return true;
				else if(dataInput.substring(3, 6).compareTo("Sep")==0)
					return true;
				else if(dataInput.substring(3, 6).compareTo("Oct")==0)
					return true;
				else if(dataInput.substring(3, 6).compareTo("Nov")==0)
					return true;
				else if(dataInput.substring(3, 6).compareTo("Dec")==0)
					return true;
			}
			return false;
		}
		else
			return false;	
	}
}