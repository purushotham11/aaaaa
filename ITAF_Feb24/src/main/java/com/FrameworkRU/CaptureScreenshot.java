package com.FrameworkRU;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * The Class CaptureScreenshot.
 * 
 * @author Kiran Kumar Cherukuri
 */
public class CaptureScreenshot {

	/** The driver. */
	public static WebDriver driver;
	static Date datefrmt;
	static String str_Date;
	static String strNew;
	static String timeStamp;

	/**
	 * Instantiates a new capture screenshot.
	 * 
	 * @param driverinstance
	 *            the driverinstance
	 */
	public CaptureScreenshot(WebDriver driverinstance) {
		driver = driverinstance;
	}
	public static String Date(){
		datefrmt = new Date();
		 str_Date = datefrmt.toLocaleString();
		 strNew = str_Date.replaceAll(":", " ");
	 timeStamp = strNew.replaceAll(",", "");
	 return timeStamp;
	}

	/**
	 * Capture screenshot.
	 * 
	 * @param filename
	 *            the filename
	 * @return the file
	 */
	public static File captureScreenshot(String filename) {
		String FileName=filename+Date();
		System.out.println(FileName);
		
		File file = null;
		try {
			String filePath = Constants.SCREENSHOT_FOLDER_PATH + File.separator
					+ filename;
			File folder = new File(filePath);
			if (!folder.exists()) {
				boolean result = false;
				try {
					folder.mkdir();
					result = true;
				} catch (Exception e) {
					// e.printStackTrace();
				}
				if (result) {
					System.out.println("Folder with name " + filename
							+ " created");
				}
			}
			file = new File(folder + "//" + FileName + ".jpg");
			if (file.exists()) {
				file.delete();
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(file.toString()));
				System.out
						.println("Snapahot has been taken for the Failed test case");
			} else {
				File scrFile = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(file.toString()));
				System.out
						.println("Snapahot has been taken for the Failed test case");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return file;

	}

}
