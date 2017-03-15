package com.FrameworkRU;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

/**
 * The Class CustomReport.
 */
public class CustomReport extends TestListenerAdapter {

	/** The driver. */
	WebDriver driver;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.TestListenerAdapter#onTestSkipped(org.testng.ITestResult)
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		onTestFailure(result);
	}

	/**
	 * Gets the driver instance.
	 * 
	 * @return the driver instance
	 */
	public WebDriver getDriverInstance() {
		return driver;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.TestListenerAdapter#onTestFailure(org.testng.ITestResult)
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		Object currentClass = result.getInstance();
		driver = ((CustomReport) currentClass).getDriverInstance();

		if (driver != null) {
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			try {
				String fileNameToCopy = "target/custom-test-reports/"
						+ result.getTestClass().getName() + "_screenshot.png";
				FileUtils.copyFile(scrFile, new File(fileNameToCopy));
				Reporter.log("[Console Log] Screenshot saved in "
						+ result.getTestClass().getName() + "_screenshot.png");
			} catch (IOException ex) {
				// Log error message
			}
		}
	}
}