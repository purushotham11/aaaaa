package com.Listeners;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.Driver.DriverManager;
import com.FrameworkRU.ConfigTestFixtures;
import com.FrameworkRU.SendEmail;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.web.modules.LOGIN.LoginPage;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving extentReporter events. The class that is
 * interested in processing a extentReporter event implements this interface,
 * and the object created with that class is registered with a component using
 * the component's <code>addExtentReporterListener<code> method. When the
 * extentReporter event occurs, that object's appropriate method is invoked.
 *
 * @author Kiran Kumar Cherukuri
 */

public class ExtentReporterListener implements IReporter {

	/** The extent. */
	private ExtentReports extent;
	Date datefrmt;
	String str_Date;
	String strNew;
	String timeStamp;
	ExtentTest test;

	/** The driver manager. */
	public DriverManager driverManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.testng.IReporter#generateReport(java.util.List, java.util.List,
	 * java.lang.String)
	 */
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		String ReportName="PrimeO_Web_Automation_Reports"+timeStamp;
		String filePath = System.getProperty("user.dir") + "\\Reports";
		extent = new ExtentReports(filePath + File.separator + ReportName+".html", true);
		if (ConfigTestFixtures.getPlatformName() != null) {
			extent.addSystemInfo("Mobile Device Platform", ConfigTestFixtures.getPlatformName());
		}
		if (ConfigTestFixtures.getDeviceManufacturer() != null) {
			extent.addSystemInfo("Mobile Device Name", ConfigTestFixtures.getDeviceManufacturer());
		}
		if (ConfigTestFixtures.getDeviceModel() != null) {
			extent.addSystemInfo("Mobile Device Model", ConfigTestFixtures.getDeviceModel());
		}
		if (ConfigTestFixtures.Environment != null) {
			extent.addSystemInfo("Web Environment", ConfigTestFixtures.Environment);
		} else {
			extent.addSystemInfo("Web Environment", "");
		}

		if (DriverManager.browsername != null) {
			extent.addSystemInfo("Browser", DriverManager.browsername);
		}
		if (!LoginPage.userApplicationVersion.equalsIgnoreCase("")) {
			extent.addSystemInfo("Application Portal Build Version", LoginPage.userApplicationVersion);
		} else {
			extent.addSystemInfo("Application Portal Build Version", "");
		}
		if (!LoginPage.adminApplicationVersion.equalsIgnoreCase("")) {
			extent.addSystemInfo("Admin Portal Build Version", LoginPage.adminApplicationVersion);
		} else {
			extent.addSystemInfo("Admin Portal Build Version", "");
		}
		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}

		try {
			extent.flush();
			extent.close();
		} catch (Exception e) {

		}

		SendEmail sendEmail = new SendEmail();
		try {
			sendEmail.sendEmailReport(ReportName);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Builds the test nodes.
	 *
	 * @param tests
	 *            the tests
	 * @param status
	 *            the status
	 */
	private void buildTestNodes(IResultMap tests, LogStatus status) {
		

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
				test = extent.startTest(result.getMethod().getMethodName());

				test.setStartedTime(getTime(result.getStartMillis()));
				test.setEndedTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase() + "ed");
				}

				extent.endTest(test);
			}
		}
	}

	/**
	 * Gets the time.
	 *
	 * @param millis
	 *            the millis
	 * @return the time
	 */
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
	public  ExtentReporterListener(){
		datefrmt = new Date();
		 str_Date = datefrmt.toLocaleString();
		 strNew = str_Date.replaceAll(":", " ");
	 timeStamp = strNew.replaceAll(",", "");
	}
	
	}

