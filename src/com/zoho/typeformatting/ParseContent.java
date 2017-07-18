package com.zoho.typeformatting;

public class ParseContent {
	
	enum ParseDataType{
		Number, Date;
	}
	public static String parse(Enum<ParseDataType> parseDataType, String dataInput) throws Exception {
		ParseDataType dataType = (ParseDataType) parseDataType;
		switch (dataType) {
		case Number:
		{
			int flag = 0;
			for(int iterator = 0; iterator<dataInput.split(",").length;iterator++) {
				if(iterator == 0)
					if(Integer.parseInt(dataInput.split(",")[iterator])<100) {
						continue;
					}
					else if(Integer.parseInt(dataInput.split(",")[iterator])<1000) {
						flag = 2;
						continue;
					}
					else {
						try {
							throw new Exception("Number-format mismatch");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				else if(iterator != (dataInput.split(",").length-1))
					if((Integer.parseInt(dataInput.split(",")[iterator])<100 && dataInput.split(",")[iterator].length()>1) && (flag==0 || flag==1)) {
						flag = 1;
						continue;
					}
					else if((Integer.parseInt(dataInput.split(",")[iterator])<1000 && dataInput.split(",")[iterator].length()>2) && (flag==0 || flag==2)) {
						flag = 2;
						continue;
					}
					else {
						try {
							throw new Exception("Number-format mismatch");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				else
					if(Integer.parseInt(dataInput.split(",")[iterator])<1000 && dataInput.split(",")[iterator].length()>2)
						return (dataInput.replaceAll(",", ""));
					else {
						try {
							throw new Exception("Number-format mismatch");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
			}
		}
			break;
			
		case Date:
		{
			if(dataInput.replaceAll("[0-9]+", "").replaceAll(" ", "").replace(",", "").matches("[a-zA-Z]+")) {
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
					throw new Exception("Invalid month entry");
			} else
				return dataInput.replaceAll("-", "");
		}
		}
		return dataInput;
	}
}