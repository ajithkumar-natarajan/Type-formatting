package com.zoho.typeformattingv2;

public class ParseContent {
	enum DataType{
		Number, Date;
	}
	
	public static String parse(DataType parseDataType, String dataInput) {
		switch (parseDataType) {
		case Number:
			return (dataInput.replaceAll(",", ""));

		case Date:
		{
				if(dataInput.substring(3, 6).compareTo("Jan")==0)
					return dataInput.substring(0, 2)+"01"+dataInput.substring(dataInput.length()-4);
				else if(dataInput.substring(3, 6).compareTo("Feb")==0)
					return dataInput.substring(0, 2)+"02"+dataInput.substring(dataInput.length()-4);
				else if(dataInput.substring(3, 6).compareTo("Mar")==0)
					return dataInput.substring(0, 2)+"03"+dataInput.substring(dataInput.length()-4);
				else if(dataInput.substring(3, 6).compareTo("Apr")==0)
					return dataInput.substring(0, 2)+"04"+dataInput.substring(dataInput.length()-4);
				else if(dataInput.substring(3, 6).compareTo("May")==0)
					return dataInput.substring(0, 2)+"05"+dataInput.substring(dataInput.length()-4);
				else if(dataInput.substring(3, 6).compareTo("Jun")==0)
					return dataInput.substring(0, 2)+"06"+dataInput.substring(dataInput.length()-4);
				else if(dataInput.substring(3, 6).compareTo("Jul")==0)
					return dataInput.substring(0, 2)+"07"+dataInput.substring(dataInput.length()-4);
				else if(dataInput.substring(3, 6).compareTo("Aug")==0)
					return dataInput.substring(0, 2)+"08"+dataInput.substring(dataInput.length()-4);
				else if(dataInput.substring(3, 6).compareTo("Sep")==0)
					return dataInput.substring(0, 2)+"09"+dataInput.substring(dataInput.length()-4);
				else if(dataInput.substring(3, 6).compareTo("Oct")==0)
					return dataInput.substring(0, 2)+"10"+dataInput.substring(dataInput.length()-4);
				else if(dataInput.substring(3, 6).compareTo("Nov")==0)
					return dataInput.substring(0, 2)+"11"+dataInput.substring(dataInput.length()-4);
				else if(dataInput.substring(3, 6).compareTo("Dec")==0)
					return dataInput.substring(0, 2)+"12"+dataInput.substring(dataInput.length()-4);
				else 
					return dataInput.replaceAll("-", "");
		}
		}
		return null;
	}
}