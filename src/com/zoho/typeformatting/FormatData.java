package com.zoho.typeformattingv2;

public abstract class FormatData {
	abstract String computeResult(String dataInput, Enum<? extends FormatChoices> userFormatChoice);
}