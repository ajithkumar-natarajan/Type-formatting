package com.zoho.typeformatting;

public abstract class PrintFormattedData {
	abstract void dispFormattingResult(String dataInput, Enum<? extends FormatChoices> userFormatChoice);
}