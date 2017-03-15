package com.FrameworkRU;

import org.openqa.selenium.WebDriver;

import com.Loggers.Logs;

/**
 * The Class CommonMethods.
 * 
 * @author Kiran Kumar Cherukuri
 */

public class CommonMethods {
	static WebDriver bak_firefox;
	static WebDriver bak_chrome;
	static WebDriver bak_ie;
	static CommonMethods cmd;
	public static boolean isDBcon = false;
	public static WebDriver popupdriver = null;
	public static WebDriver popupdriver_bef = null;
	public static Logs logsObj;

	/**
	 * Splits the string.
	 * 
	 * @param stringToSplit
	 *            the string to split
	 * @param delimiter
	 *            the delimiter
	 * @return the string[]
	 */
	public static String[] splitString(String stringToSplit, String delimiter) {
		String[] flag = null;

		try {
			String[] result = stringToSplit.split(delimiter);
			if (result.length < 2) {
				throw new IllegalArgumentException(
						"String not in correct format");
			} else {
				flag = result;
			}
		} catch (Throwable t) {
			logsObj.logError("Unable to split the string-" + stringToSplit
					+ " due to erro-", t);
		}
		return flag;
	}
}
