package com.zoho.typeformatting;

import java.util.Scanner;
import com.zoho.typeformatting.NumberFormatChoiceValidator.NumberFormatChoice;
import com.zoho.typeformatting.DateFormatChoiceValidator.DateFormatChoice;
import com.zoho.typeformatting.ScientificFormatChoiceValidator.ScientificFormatChoice;
import com.zoho.typeformatting.TextFormatChoiceValidator.TextFormatChoice;
import com.zoho.typeformatting.ParseContent.ParseDataType;

enum DataTypeChoice {
	NUMBER(1), DATE(2), SCIENTIFIC(3), TEXT(4);
	
	private int choiceNumber;

    private DataTypeChoice(int choiceNumber) {
        this.choiceNumber = choiceNumber;
    }
    
    public static DataTypeChoice getDataType(int userChoice) throws Exception {
        for (DataTypeChoice dataType : DataTypeChoice.values()) {
            if (dataType.choiceNumber == userChoice) 
            	return dataType;
        }
        throw new Exception("Invalid data type!");
    }
}

public class Main {
	@SuppressWarnings("static-access")
	public static void main(String[] args) throws Exception {
		while(true) {
			System.out.println("Please enter the data:");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			String dataInput = scanner.nextLine();
			
			System.out.println("Choose the data type");
			System.out.println("1. Number");
			System.out.println("2. Date");
			System.out.println("3. Scientific");
			System.out.println("4. Text");
			

			DataTypeChoice inputType = DataTypeChoice.getDataType(scanner.nextInt());
			FormatChoiceValidator typeFormatValidation;
			PrintFormattedData formattingResult;
			switch (inputType) {
			case NUMBER:
				typeFormatValidation = new NumberFormatChoiceValidator();
				try {
					if(typeFormatValidation.validateFormat(dataInput)) {
						System.out.println("Choose the desired format:");
						System.out.println("1. Indian numeral system");
						System.out.println("2. International numeral system");
						NumberFormatChoice userChoice = null;
						userChoice = userChoice.getDataType(scanner.nextInt());
						formattingResult = new PrintNumberFormattedData();
						formattingResult.dispFormattingResult(dataInput, userChoice);
					} else {
						System.out.println("Choose the desired format:");
						System.out.println("1. Indian numeral system");
						System.out.println("2. International numeral system");
						NumberFormatChoice userChoice = null;
						userChoice = userChoice.getDataType(scanner.nextInt());
						formattingResult = new PrintNumberFormattedData();
						formattingResult.dispFormattingResult(ParseContent.parse(ParseDataType.Number, dataInput), userChoice);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case DATE:
				typeFormatValidation = new DateFormatChoiceValidator();
				try {
					if(typeFormatValidation.validateFormat(dataInput)) {
						System.out.println("Choose the desired format:");
						System.out.println("1. DD-MM-YYYY");
						System.out.println("2. DD MMM, YYYY");
						DateFormatChoice userChoice = null;
						userChoice = userChoice.getDataType(scanner.nextInt());
						formattingResult = new PrintDateFormattedData();
						formattingResult.dispFormattingResult(dataInput, userChoice);
					} else {
						System.out.println("Choose the desired format:");
						System.out.println("1. DD-MM-YYYY");
						System.out.println("2. DD MMM, YYYY");
						DateFormatChoice userChoice = null;
						userChoice = userChoice.getDataType(scanner.nextInt());
						formattingResult = new PrintDateFormattedData();
						formattingResult.dispFormattingResult(ParseContent.parse(ParseDataType.Date, dataInput), userChoice);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case SCIENTIFIC:
				typeFormatValidation = new ScientificFormatChoiceValidator();
				try {
					if(typeFormatValidation.validateFormat(dataInput)) {
						System.out.println("Choose the desired format:");
						System.out.println("1. #.##E##");
						System.out.println("1. #.###E#");
						ScientificFormatChoice userChoice = null;
						userChoice = userChoice.getDataType(scanner.nextInt());
						formattingResult = new PrintScientificFormattedData();
						formattingResult.dispFormattingResult(dataInput, userChoice);
					} else// if(typeFormatValidation.validateFormat(dataInput).compareTo("toParse")==0) {
						System.out.println(dataInput);
//					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case TEXT:
				typeFormatValidation = new TextFormatChoiceValidator();
				try {
					if(typeFormatValidation.validateFormat(dataInput)) {
						System.out.println("Choose the desired format:");
						System.out.println("1. Uppercase");
						System.out.println("2. Lowercase");
						TextFormatChoice userChoice = null;
						userChoice = userChoice.getDataType(scanner.nextInt());
						formattingResult = new PrintTextFormattedData();
						formattingResult.dispFormattingResult(dataInput, userChoice);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
	
			default:
				break;
			}
		}
	}
}