package com.zoho.typeformatting;

public class DateFormatOutput extends Output {
	public void dispOutput(String str, int formatType) {
		if(formatType==1)
			System.out.println(printDateFormatOne(str));
		else
			System.out.println(printDateFormatTwo(str));
	}
	
	public String printDateFormatOne(String date) {
		return date.substring(0, 2)+"-"+date.substring(2, 4)+"-"+date.substring(date.length() - 4);
	}
	
	public String printDateFormatTwo(String date) {
		return date.substring(0, 2)+"-"+getMonth(date.substring(2,4))+"-"+date.substring(date.length() - 4);
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