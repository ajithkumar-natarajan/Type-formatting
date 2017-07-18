package com.zoho.typeformattingv2;

import com.zoho.typeformattingv2.FormatStyles.DateFormatChoice;

public class FormatDate extends FormatData {
	public String computeResult(String dataInput, Enum<? extends FormatChoices> UserFormatChoice) {
		if(UserFormatChoice == DateFormatChoice.DD_MM_YYYY)
			return (dataInput.substring(0, 2)+"-"+dataInput.substring(2, 4)+"-"+dataInput.substring(dataInput.length() - 4));
		else
			return (dataInput.substring(0, 2)+" "+getMonth(dataInput.substring(2,4))+", "+dataInput.substring(dataInput.length() - 4));
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
				return null;
		}
		
	}
}