package com.zoho.typeformatting;

public class DateFormatChoiceValidator extends FormatChoiceValidator{
	
	public boolean validateFormat(String dataInput) throws Exception {
		if(dataInput.matches("[0-9]+")) {
			if(dataInput.length()==8) {
				if(!(Integer.parseInt(dataInput.substring(0, 2))<32))
					throw new Exception("Date must be smaller than or equal to 31");
				if(!(Integer.parseInt(dataInput.substring(2, 4))<13))
					throw new Exception("Month must be smaller than or equal to 12");
			} else if (dataInput.length()<8)
				throw new Exception("Please prefix single digit month/date of month with 0");
			else
				throw new Exception("Date cannot be longer than 8 characters");
			return true;
		} else if(dataInput.contains("-") || dataInput.contains(","))
			return false;
		else
			throw new Exception("Type date cannot contain letters!");
	}
	
	enum DateFormatChoice implements FormatChoices{
		DD_MM_YYYY(1), DD_MMM_YYYY(2);
		
		private int choiceNumber;

	    private DateFormatChoice(int userOption) {
	        this.choiceNumber = userOption;
	    }

	    public static DateFormatChoice getFormatChoice(int userChoice) throws Exception {
	        for (DateFormatChoice formatChoices : DateFormatChoice.values()) {
	            if (formatChoices.choiceNumber == userChoice) 
	            	return formatChoices;
	        }
	        throw new Exception("Invalid data type!");
	    }
	}
}