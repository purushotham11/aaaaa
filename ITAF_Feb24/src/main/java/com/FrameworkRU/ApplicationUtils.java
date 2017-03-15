package com.FrameworkRU;

import java.io.File;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

/**
 * 
 * @author Kiran Kumar Cherukuri
 */

public class ApplicationUtils {
	public WebDriver driver;
	public static String attachingFile = "asset.jpg";
	public static File file = new File("");
	public static String directoryPath = file.getAbsolutePath();
	public static String folderPath = Constants.ATTACHMENTS_FILE_PATH;
	public static String filePath = folderPath + attachingFile;

	/**
	 * Gets the template name.
	 * 
	 * @param modelnumber
	 *            the modelnumber
	 * @param manufacturer
	 *            the manufacturer
	 * @param materialnumber
	 *            the materialnumber
	 * @return the template name
	 */
	public static String getTemplateName(String modelnumber,
			String manufacturer, String materialnumber) {
		String TemplateName = modelnumber + "-" + manufacturer + "("
				+ materialnumber + ")";
		return TemplateName;
	}

	/**
	 * Gets the unique string.
	 * 
	 * @param len
	 *            the len
	 * @return the unique string
	 */
	public static String getUniqueString(int len) {
		return RandomStringUtils.randomAlphabetic(len);
	}
	
	/**
	 * Gets the domain name.
	 *
	 * @param emailid the emailid
	 * @return the domain name
	 */
	public static String getDomainName(String emailid) {
		String forDomain[] = emailid.split("@");
		return forDomain[1];
	}
	
	/**
	 * Gets the domainwith at the rate.
	 *
	 * @param emailid the emailid
	 * @return the domainwith at the rate
	 */
	public static String getDomainwithAtTheRate(String emailid) {
		return emailid.substring(emailid.indexOf("@"));
	}
}
