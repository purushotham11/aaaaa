package com.FrameworkRU;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.Loggers.Logs;

/**
 * The Class DateUtil.
 *
 * @author Kiran Kumar Cherukuri
 */

public class DateUtil 
{
	
	/** The logs obj. */
	public static Logs logsObj;
	
	/**
	 * Gets the current date in required date format.
	 *
	 * @param dateFormat the date format
	 * @return the current date in required date format
	 */
	public static String getCurrentDateInRequiredDateFormat(String dateFormat) {
		String timeStamp = null;
		try {
			timeStamp = new SimpleDateFormat(dateFormat).format(Calendar.getInstance().getTime());
		} catch (Throwable t) {
			logsObj.logError(
					"unable to format the given date format:" + dateFormat + " of the current date due to error", t);
		}

		return timeStamp;
	}
}
