package util;

import java.text.NumberFormat;

public class CurrencyFormatter {

	public static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

	public static String formatDouble(double value) {
		return currencyFormatter.format(value).toString();
	}
}
