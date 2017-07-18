package com.zoho.typeformattingv2;

import com.zoho.typeformattingv2.FormatStyles.NumberFormatChoice;

public class InputNumberMatchValidator extends InputDatatypeMatchValidator {
	static NumberFormatChoice FormatType = null;
	public boolean validate(String dataInput) {
		if(dataInput.matches("[0-9]+") || dataInput.contains(",")) {
			if(dataInput.contains(",")) {
				int flag = 0;
				for(int iterator = 0; iterator<dataInput.split(",").length;iterator++) {
					if(iterator == 0)
						if(Integer.parseInt(dataInput.split(",")[iterator])<100)
							continue;
						else if(Integer.parseInt(dataInput.split(",")[iterator])<1000) {
							flag = 2;
							continue;
						}
						else
							return false;
					else if(iterator != (dataInput.split(",").length-1))
						if((Integer.parseInt(dataInput.split(",")[iterator])<100 && dataInput.split(",")[iterator].length()>1) && (flag==0 || flag==1)) {
							flag = 1;
							continue;
						}
						else if((Integer.parseInt(dataInput.split(",")[iterator])<1000 && dataInput.split(",")[iterator].length()>2) && (flag==0 || flag==2)) {
							flag = 2;
							continue;
						}
						else
							return false;
					else
						if(Integer.parseInt(dataInput.split(",")[iterator])<1000 && dataInput.split(",")[iterator].length()>2) {
							if(flag == 0 || flag == 1)
								FormatType = NumberFormatChoice.INDIAN_SYSTEM;
							else if(flag==0 || flag==2)
								FormatType = NumberFormatChoice.INTERNATIONAL_SYSTEM;
							return true;
						}
						else
							return false;
				}	
			}
			else
				return true;
		}
		else
			return false;
		return false;
	}
	
//	public NumberFormatChoice getDataFormatType() {
//		return FormatType;
//	}
}