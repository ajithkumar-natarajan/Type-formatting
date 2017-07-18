package com.zoho.typeformatting;

public class NumberFormatChoiceValidator extends FormatChoiceValidator{
	
	public boolean validateFormat(String dataInput) throws Exception {
		if(dataInput.matches("[0-9]+"))
			return true;
		else if(dataInput.contains(","))
			return false;
		else
			throw new Exception("Type number cannot contain letters!");
	}
	
	enum NumberFormatChoice implements FormatChoices{
		INDIAN_SYSTEM(1), INTERNATIONAL_SYSTEM(2);
		
		private int choiceNumber;

	    private NumberFormatChoice(int userOption) {
	        this.choiceNumber = userOption;
	    }

	    public static NumberFormatChoice getFormatChoice(int userChoice) throws Exception {
	        for (NumberFormatChoice formatChoices : NumberFormatChoice.values()) {
	            if (formatChoices.choiceNumber == userChoice) 
	            	return formatChoices;
	        }
	        throw new Exception("Invalid data type!");
	    }
	}
}