package com.web.tests.Views;


import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
		MethodListener.class })
public class ReportsTest {

	{
		System.setProperty("atu.reporter.config", "C:/Demo_Framework1/ITAF_Feb24/Jars/Version 5.1.1/ATUReporter_Selenium_testNG_5.1.1 jar+javadoc+prop file+demo proj+atu recorder/atu.properties");
	}

	private WebDriver driver;
	private String baseUrl;

	@BeforeTest
	public void setUp() throws Exception {
		File chromeDriver = new File("C:/Demo_Framework1/ITAF_Feb24/src/test/resources/Drivers/chrome/chromedriver_win32/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath() ); 
		
		/*ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addExtensions(new File("C:\\Users\\bp1002\\AppData\\Local\\Google\\Chrome\\Application\\50.0.2661.87\\default_apps\\drive.crx"));
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	    driver = new ChromeDriver(capabilities);*/
	   
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("disable-extensions");
	    options.addArguments("--start-maximized");
	    driver = new ChromeDriver(options);
		baseUrl = "https://www.google.co.in";
		driver.get(baseUrl + "/");

		// ATU Reports
		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Test Project";
	}

	@Test
	public void GoogleTooltip() throws Exception, SQLException {
		Actions ToolTip1 = new Actions(driver);
		WebElement googleLogo = driver.findElement(By
				.xpath("//div[@id='hplogo']"));
		ToolTip1.clickAndHold(googleLogo).perform();
		String ToolTipText = googleLogo.getAttribute("title");
		Assert.assertEquals(ToolTipText, "Google");
		System.out.println("Tooltip value is: " + ToolTipText);
	}

	// ATU Reports Method
	@Test
	public void testNewLogs() throws AWTException, IOException {

		ATUReports.add("INfo Step", LogAs.INFO, new CaptureScreen(
				ScreenshotOf.BROWSER_PAGE));
		ATUReports.add("Pass Step", LogAs.PASSED, new CaptureScreen(
				ScreenshotOf.DESKTOP));
		WebElement element = driver
				.findElement(By.xpath("html/body/div/div[3]/div[1]/div/div/div/div[2]/div[3]/div/a"));
		ATUReports.add("Warning Step", LogAs.WARNING,
				new CaptureScreen(element));
		/*ATUReports.add("Fail step", LogAs.FAILED, new CaptureScreen(
				ScreenshotOf.DESKTOP));*/
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}

}