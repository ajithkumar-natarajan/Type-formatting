package com.zoho.typeformattingv2;

import java.util.Scanner;
import com.zoho.typeformattingv2.FormatStyles.NumberFormatChoice;
import com.zoho.typeformattingv2.FormatStyles.DateFormatChoice;
import com.zoho.typeformattingv2.FormatStyles.ScientificDataFormatChoice;
import com.zoho.typeformattingv2.FormatStyles.LettersFormatChoice;
import com.zoho.typeformattingv2.ParseContent.DataType;

enum DataTypeChoice {
	NUMBER(1, new FormatNumber(), new InputNumberMatchValidator()),
	DATE(2, new FormatDate(), new InputDateMatchValidator()), 
	SCIENTIFIC(3, new FormatScientificData(), new InputScientificDataMatchValidator()), 
	LETTERS(4, new FormatLetters(), new InputLettersMatchValidator());
	
	private int choiceNumber;
	private FormatData formatDataType;
	private InputDatatypeMatchValidator validatorType;

    private DataTypeChoice(int choiceNumber, FormatData formatData, InputDatatypeMatchValidator validator) {
        this.choiceNumber = choiceNumber;
        this.formatDataType = formatData;
        this.validatorType =  validator;
    }
    
    public int getChoiceNumber() {
    	return this.choiceNumber;
    }
    
    public FormatData getFormatDataType() {
    	return this.formatDataType;
    }
    
    public InputDatatypeMatchValidator getValidatorType() {
    	return this.validatorType;
    }
    
    public static DataTypeChoice getDataType(int choice) {
        for (DataTypeChoice dataType : DataTypeChoice.values()) {
            if (dataType.choiceNumber == choice) 
            	return dataType;
        }
        return null;
    }
}

public class TypeFormatting {
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
			System.out.println("4. Letters");
			
			int dataType = scanner.nextInt();
			
			DataTypeChoice inputType = DataTypeChoice.getDataType(dataType);
			try{
				if(inputType == null)
					throw new Exception("Invalid data type");
			} catch(Exception e){
				e.printStackTrace();
			}

			InputDatatypeMatchValidator typeFormatValidation = inputType.getValidatorType();
			FormatData formattingResult = inputType.getFormatDataType();
			
			switch (inputType) {
			case NUMBER:
				try {
					if(typeFormatValidation.validate(dataInput)) {
						
						System.out.println("Choose the desired format:");
						System.out.println("1. Indian numeral system");
						System.out.println("2. International numeral system");
						NumberFormatChoice userChoice = NumberFormatChoice.getFormatChoice(scanner.nextInt());
						if(userChoice == null)
							throw new Exception("Invalid format style");
						if(dataInput.contains(","))
							if(userChoice ==  InputNumberMatchValidator.FormatType) {
									System.out.println(">>>>>");
									System.out.println(dataInput);
									break;
							}
							else if(userChoice == InputNumberMatchValidator.FormatType) {
									System.out.println("<<<<<");
									System.out.println(dataInput);
									break;
								}
							else
							dataInput = ParseContent.parse(DataType.Number, dataInput);
						System.out.println(formattingResult.computeResult(dataInput, userChoice));
					} else {
						if(dataInput.contains(","))
							throw new Exception("Number-Format mismatch");
						else
							throw new Exception("Type number cannot contain letters");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case DATE:
				try {
					if(typeFormatValidation.validate(dataInput)) {
						System.out.println("Choose the desired format:");
						System.out.println("1. DD-MM-YYYY");
						System.out.println("2. DD MMM, YYYY");
						DateFormatChoice userChoice = DateFormatChoice.getFormatChoice(scanner.nextInt());
						if(userChoice == null)
							throw new Exception("Invalid format style");
						else if(userChoice == DateFormatChoice.DD_MM_YYYY) {
							if(dataInput.contains("-")) {
//								System.out.println(">>>>>");
								System.out.println(dataInput);
								break;
							}
						}
						else {
							if(dataInput.contains(",")) {
//								System.out.println("<<<<<");
								System.out.println(dataInput);
								break;
							}
						}
						if(dataInput.contains("-") || dataInput.contains(","))
							dataInput = ParseContent.parse(DataType.Date, dataInput);
						System.out.println(formattingResult.computeResult(dataInput, userChoice));
					} else {
						if(dataInput.length()==8) {
							if(!(Integer.parseInt(dataInput.substring(0, 2))<32))
								throw new Exception("Date must be smaller than or equal to 31");
							if(!(Integer.parseInt(dataInput.substring(2, 4))<13))
								throw new Exception("Month must be smaller than or equal to 12");
						}
						else if (dataInput.length()<8)
								throw new Exception("Please prefix single digit month/date of month with 0");
						else
							if(dataInput.substring(3, 6).matches("[a-zA-Z]+"))
								throw new Exception("Invalid month");
							else if(dataInput.substring(3, 5).matches("[0-9]+") && Integer.parseInt(dataInput.substring(3, 5))>12)
								throw new Exception("Invalid month");
							else
								throw new Exception("Date cannot be longer than 8 characters"); 
						if (!dataInput.matches("[0-9]+") && !(dataInput.contains("-") || dataInput.contains(",")))
							throw new Exception("Type date cannot contain letters!");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case SCIENTIFIC:
				try {
					if(typeFormatValidation.validate(dataInput)) {
						if(dataInput.contains("E"))
							System.out.println(dataInput);
						else {
							System.out.println("Choose the desired format:");
							System.out.println("1. #.##E##");
							System.out.println("1. #.###E#");
							ScientificDataFormatChoice userChoice = ScientificDataFormatChoice.getFormatChoice(scanner.nextInt());
							if(userChoice == null)
								throw new Exception("Invalid format style");
							System.out.println(formattingResult.computeResult(dataInput, userChoice));
						}
					} else {
						throw new Exception("Invalid input for type scientific");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case LETTERS:
				try {
					if(typeFormatValidation.validate(dataInput)) {
						System.out.println("Choose the desired format:");
						System.out.println("1. Uppercase");
						System.out.println("2. Lowercase");
						LettersFormatChoice userChoice = LettersFormatChoice.getFormatChoice(scanner.nextInt());
						if(userChoice == null)
							throw new Exception("Invalid format style");
						System.out.println(formattingResult.computeResult(dataInput, userChoice));
					} else {
						throw new Exception("Type letters cannot contain numbers!");
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