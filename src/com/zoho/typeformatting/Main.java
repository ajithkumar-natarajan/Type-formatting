package com.zoho.typeformatting;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		while(true) {
			System.out.println("Please enter the data:");
			Scanner scanner = new Scanner(System.in);
			String str = scanner.nextLine();
	//		scanner.close();
			
			System.out.println("Choose the data type");
			System.out.println("1. Number");
			System.out.println("2. Date");
			System.out.println("3. Scientific");
			System.out.println("4. Text");
			
			int choice = scanner.nextInt();
			
			Formats dataFormat;
			switch (choice) {
			case 1:
				dataFormat = new NumberFormat();
	//			FormatData input = new FormatData();
	//			input dataFormat.getFormat();
	//			FormatData.dispOutput(dataFormat.getFormat());
				try {
					if(dataFormat.checkFormatValidity(str)) {
	//					System.out.println(dataFormat.getFormatChoice()); 
						dataFormat.formatData(str, dataFormat.getFormat());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 2:
				dataFormat = new DateFormat();
				try {
					if(dataFormat.checkFormatValidity(str)) {
	//					System.out.println(dataFormat.getFormatChoice());
						dataFormat.formatData(str, dataFormat.getFormat());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 3:
				dataFormat = new ScientificFormat();
				try {
					if(dataFormat.checkFormatValidity(str)) {
	//					System.out.println(dataFormat.getFormatChoice());
						dataFormat.formatData(str, dataFormat.getFormat());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 4:
				dataFormat = new TextFormat();
				try {
					if(dataFormat.checkFormatValidity(str)) {
	//					System.out.println(dataFormat.getFormatChoice());
						dataFormat.formatData(str, dataFormat.getFormat());
					}
				} catch (Exception e) {
	//				System.out.println("Exception occurred");
					e.printStackTrace();
				}
				break;
	
			default:
				break;
			}
		}
	}
	
}
