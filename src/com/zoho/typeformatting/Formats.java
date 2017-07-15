package com.zoho.typeformatting;

import java.util.Scanner;

//public interface Formats {
//	public int getFormat();
//	public void formatData(String str, int formatType);
//}
abstract class Formats {
	protected Scanner input;
	protected Output output;
	protected int formatChoice;
//	protected enum formatChoice {
//		   FORMAT1, FORMAT2
//		}
	abstract int getFormat();
	abstract boolean checkFormatValidity(String str) throws Exception;
	abstract int getFormatChoice();
	abstract void formatData(String str, int formatType);
}