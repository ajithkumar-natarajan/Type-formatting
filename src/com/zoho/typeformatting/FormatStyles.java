package com.zoho.typeformattingv2;

public class FormatStyles {
	enum NumberFormatChoice implements FormatChoices {
		INDIAN_SYSTEM(1), INTERNATIONAL_SYSTEM(2);
		
		private int choiceNumber;

	    private NumberFormatChoice(int userOption) {
	        this.choiceNumber = userOption;
	    }

	    public static NumberFormatChoice getFormatChoice(int userChoice) {
	        for (NumberFormatChoice formatChoices : NumberFormatChoice.values()) {
	            if (formatChoices.choiceNumber == userChoice) 
	            	return formatChoices;
	        }
	        return null;
	    }
	}
	
	enum DateFormatChoice implements FormatChoices{
		DD_MM_YYYY(1), DD_MMM_YYYY(2);
		
		private int choiceNumber;

	    private DateFormatChoice(int userOption) {
	        this.choiceNumber = userOption;
	    }

	    public static DateFormatChoice getFormatChoice(int userChoice) {
	        for (DateFormatChoice formatChoices : DateFormatChoice.values()) {
	            if (formatChoices.choiceNumber == userChoice) 
	            	return formatChoices;
	        }
			return null;
	    }
	}
	
	enum ScientificDataFormatChoice implements FormatChoices{
		TWO_DECIMALS(1), FOUR_DECIMALS(2);
		
		private int choiceNumber;

	    private ScientificDataFormatChoice(int userOption) {
	        this.choiceNumber = userOption;
	    }

	    public static ScientificDataFormatChoice getFormatChoice(int userChoice) {
	        for (ScientificDataFormatChoice formatChoices : ScientificDataFormatChoice.values()) {
	            if (formatChoices.choiceNumber == userChoice) 
	            	return formatChoices;
	        }
	        return null;
	    }
	}
	
	enum LettersFormatChoice implements FormatChoices{
		CAPITAL_LETTERS(1), SMALL_LETTERS(2);
		
		private int choiceNumber;

	    private LettersFormatChoice(int userOption) {
	        this.choiceNumber = userOption;
	    }
	    
	    public static LettersFormatChoice getFormatChoice(int userChoice) {
	        for (LettersFormatChoice formatChoices : LettersFormatChoice.values()) {
	            if (formatChoices.choiceNumber == userChoice) 
	            	return formatChoices;
	        }
	        return null;
	    }
	}
}