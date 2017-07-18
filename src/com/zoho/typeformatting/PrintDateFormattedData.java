package com.zoho.typeformatting;

import com.zoho.typeformatting.DateFormatChoiceValidator.DateFormatChoice;

public class PrintDateFormattedData extends PrintFormattedData {
	public void dispFormattingResult(String dataInput, Enum<? extends FormatChoices> UserFormatChoice) {
		if(UserFormatChoice == DateFormatChoice.DD_MM_YYYY)
			System.out.println(formatDateToMethodOne(dataInput));
		else
			System.out.println(formatDateToMethodTwo(dataInput));
	}
	
	public String formatDateToMethodOne(String date) {
		return date.substring(0, 2)+"-"+date.substring(2, 4)+"-"+date.substring(date.length() - 4);
	}
	
	public String formatDateToMethodTwo(String date) {
		return date.substring(0, 2)+" "+getMonth(date.substring(2,4))+", "+date.substring(date.length() - 4);
	}
	
	public String getMonth(String month) {
		switch(month) {
			case "01":
				return "Jan";
			case "02":
				return "Feb";
			case "03":
				return "Mar";
			case "04":
				return "Apr";
			case "05":
				return "May";
			case "06":
				return "Jun";
			case "07":
				return "Jul";
			case "08":
				return "Aug";
			case "09":
				return "Sep";
			case "10":
				return "Oct";
			case "11":
				return "Nov";
			case "12":
				return "Dec";
			default:
				return("Invalid month");
		}
		
	}
}