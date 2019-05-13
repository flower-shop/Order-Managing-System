package util;

import java.text.NumberFormat;

/*
 * File: CurrencyFormatter.java
 * Date: May 12, 2019
 * Authors: Olga Samborski, Jasmine Jones, Scott Hussey, and James DeBenedictis
 */

public class CurrencyFormatter {

	public static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

	public static String formatDouble(double value) {
		return currencyFormatter.format(value).toString();
	}
}
