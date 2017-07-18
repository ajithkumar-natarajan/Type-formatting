package com.zoho.typeformatting;

public class ScientificFormatChoiceValidator extends FormatChoiceValidator{
	
	public boolean validateFormat(String dataInput) throws Exception {
		if(dataInput.matches("[0-9]+"))
			return true;
		else if(dataInput.contains(".") && dataInput.contains("E") && dataInput.replace(".", "").replace("E", "").matches("[0-9]+"))
			return false;
		else
			throw new Exception("Type scientific cannot contain letters!");
	}
	
	enum ScientificFormatChoice implements FormatChoices{
		TWO_DECIMALS(1), FOUR_DECIMALS(2);
		
		private int choiceNumber;

	    private ScientificFormatChoice(int userOption) {
	        this.choiceNumber = userOption;
	    }

	    public static ScientificFormatChoice getFormatChoice(int userChoice) throws Exception {
	        for (ScientificFormatChoice formatChoices : ScientificFormatChoice.values()) {
	            if (formatChoices.choiceNumber == userChoice) 
	            	return formatChoices;
	        }
	        throw new Exception("Invalid data type!");
	    }
	}
}