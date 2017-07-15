package com.zoho.typeformatting;

public class NumberFormatOutput extends Output {
	public void dispOutput(String str, int formatType) {
//		int input;
//		input = Integer.parseInt(str);
//		System.out.println(printNumber(input));
		if(formatType==1) {
			int flag = 1;
			System.out.println(printNumberFormatOne(str, flag));
		}
		else
			System.out.println(printNumberFormatTwo(str));
	}
	
	public String printNumberFormatOne(String number, int flag) {
		String result;
		if(flag!=1) {
			if (number.length() == 2) {
				return number;
			} else if (number.length() > 2) {
				result = printNumberFormatOne(number.substring(0, number.length()-2), flag)+","+number.substring(number.length() - 2);
				return result;
			}
				else
				return number;
		}
		else {
			if (number.length() == 3) {
				flag = 2;
				return number;
			} else if (number.length() > 3) {
				flag = 2;
				result = printNumberFormatOne(number.substring(0, number.length()-3), flag)+","+number.substring(number.length() - 3);
				return result;
			}
				else {
					flag = 2;
					return number;
				}
		}
			
	}
	
	public String printNumberFormatTwo(String number) {
		String result;
//		if(number>1000) {
//			int recursiveNumber = number/1000;
//			result = printNumber(recursiveNumber)+","+number/1000;
		if (number.length() == 3) {
			return number;
		} else if (number.length() > 3) {
			result = printNumberFormatTwo(number.substring(0, number.length()-3))+","+number.substring(number.length() - 3);
			return result;
		}
//			return number.substring(number.length() - 3);
//		} else if (number.length()<3){
			else
			  // whatever is appropriate in this case
			return number;
//		}
//			return result;
//		}
//		else
//			return Integer.toString(number);
	}
}