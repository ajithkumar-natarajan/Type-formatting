package com.zoho.typeformatting;

public class TextFormatChoiceValidator extends FormatChoiceValidator{
	
	public boolean validateFormat(String dataInput) throws Exception {
		if((dataInput.matches("[a-zA-Z]+")))
			return true;
		else
			throw new Exception("Type text cannot contain numbers!");
	}
	
	enum TextFormatChoice implements FormatChoices{
		CAPITAL_LETTERS(1), SMALL_LETTERS(2);
		
		private int choiceNumber;

	    private TextFormatChoice(int userOption) {
	        this.choiceNumber = userOption;
	    }
	    
	    public static TextFormatChoice getFormatChoice(int userChoice) throws Exception {
	        for (TextFormatChoice formatChoices : TextFormatChoice.values()) {
	            if (formatChoices.choiceNumber == userChoice) 
	            	return formatChoices;
	        }
	        throw new Exception("Invalid data type!");
	    }
	}
}