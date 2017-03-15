package com.web.tests.LoginTest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.Listeners.*;
import com.Driver.DriverManager;
import com.ExcelUtilities.ExcelUtils;
import com.FrameworkRU.ApplicationUtils;
import com.FrameworkRU.CaptureScreenshot;
import com.FrameworkRU.CleanupTestData;
import com.FrameworkRU.ConfigTestFixtures;
import com.FrameworkRU.Constants;
import com.FrameworkRU.PageAction;
import com.FrameworkRU.PropertyReader;
import com.FrameworkRU.ReadXMlData;
import com.FrameworkRU.RestCallMethods;
import com.FrameworkRU.SendEmail;
import com.FrameworkRU.VerifyEmail;
import com.FrameworkRU.WaitForPage;
/*import com.web.modules.ASSETS.AssetsPage;
import com.web.modules.ASSETS.AssetsPageRU;
import com.web.modules.COMPANYSETTINGS.CompanySettingsPage;
import com.web.modules.COMPANYSETTINGS.CompanySettingsPageRU;
import com.web.modules.EMPLOYEES.EmployeesPage;
import com.web.modules.LOCATIONS.LocationsPageRU;*/
import com.web.modules.LOGIN.LoginPage;
import com.web.modules.LOGOUT.LogoutPage;
import com.web.modules.Views.ViewsPage;
import com.Loggers.LoggingDemo;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;


import com.Loggers.*;
/**
 * The Class LoginTest.
 */

public class LoginTest {
	{
		System.setProperty("atu.reporter.config", "C:/Demo_Framework1/ITAF_Feb24/Jars/Version 5.1.1/ATUReporter_Selenium_testNG_5.1.1 jar+javadoc+prop file+demo proj+atu recorder/atu.properties");
	}
	
	public Logger logger = Logger.getLogger("devpinoyLogger");

	private static ExcelUtils excelUploadObject;
	WebDriver driver;
	ConfigTestFixtures configTestFixtures;
	private DriverManager driverManager;
	private LoginPage loginPage;
	//private LogoutPage logoutPage;
	private ViewsPage viewsPage;
	private LoggingDemo log;
	
	PageAction pageAction;
	SendEmail sendEmail;
	/*AssetsPage assetsPage;
	AssetsPageRU assetsPageRU;*/
	CleanupTestData cleanupTestData;
	public static boolean assetsXMLUploadStatus;

     String env = "Primeoqa";
	String browser = "chrome";
	
	String badgeId = "badgeId";
	String fullName = "fullName";

	/**
	 * Clean up environment.
	 */
	//@BeforeClass(alwaysRun = true)
	public void cleanUpEnvironment() {
		try {
			cleanupTestData = new CleanupTestData();
			cleanupTestData.cleanUpTestDataForImportAndExportSettings(browser,env);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Data Clean Up Configuration Failed, Please check and delete data manually before starting the TESTS");
		}
	}

	/**
	 * Test method prerequisites.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@BeforeTest
	public void ATU(){
		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Test Project";
	}
	@BeforeMethod(alwaysRun=true)
	public void testMethodPrerequisites() throws Exception {
		driverManager = new DriverManager();
		log=new LoggingDemo();
		System.out.println("environment ======= " + env);
		System.out.println("browser ==========" + browser);
		driverManager.launchBrowser(browser);
		log.loginfo("browser launched successfully");
		
		driver = driverManager.getDriver();
		configTestFixtures = new ConfigTestFixtures();
		loginPage = new LoginPage(driver);
		//logoutPage = new LogoutPage(driver);
		viewsPage = new ViewsPage(driver);
		//new LogoutPage(driver);
		new CaptureScreenshot(driver);
		
		pageAction = new PageAction(driver);
		sendEmail = new SendEmail();
		//assetsPage = new AssetsPage(driver);
		//assetsPageRU = new AssetsPageRU(driver);
	}

	/**
	 * Invalid employee validation.
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	@Test(priority = 1, enabled = true, groups = {"Sanity"})
	public void invalidLoginDataValidation() throws FileNotFoundException, Exception {
		
			System.out
					.println("************Login and Logout Test Verification Started**************");
			configTestFixtures.generateConfigTestData(env);
			/*excelUploadObject = new ExcelUtils(
					Constants.DATAFILE_EMPLOYEES_PATH
							+ Constants.EMPLOYEES_ERROR_MESSAGES_FILE);*/
			driverManager.loadURL(ConfigTestFixtures.getWebAppUrl());
			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "Test Project";
			
            
			try {
				loginPage.
				    portalSignIn(
						PropertyReader.getPropValuesFromConfig("web.app.username1", "Primeoqa", ""), 
						PropertyReader.getPropValuesFromConfig("web.app.password", "Primeoqa", ""), 
						PropertyReader.getPropValuesFromConfig("web.app.dealerid", "Primeoqa", ""));
				WaitForPage.waitFor5Sec();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.loginfo("wrong user credentials");
			}
			System.out
					.println("************In valid Login  Verification Passed**************");
	}
	

	/**
	 * Valid employee validation.
	 *
	 */
	@Test(priority = 2, enabled = false, groups = {"Sanity"})
	public void validLoginDataValidation() throws FileNotFoundException, Exception {
		
		System.out
				.println("************Login and Logout Test Verification Started**************");
		configTestFixtures.generateConfigTestData(env);
		/*excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_EMPLOYEES_PATH
						+ Constants.EMPLOYEES_ERROR_MESSAGES_FILE);*/
		driverManager.loadURL(ConfigTestFixtures.getWebAppUrl());
        loginPage.
		    portalSignIn(
				PropertyReader.getPropValuesFromConfig("web.app.username", "Primeoqa", ""), 
				PropertyReader.getPropValuesFromConfig("web.app.password", "Primeoqa", ""), 
				PropertyReader.getPropValuesFromConfig("web.app.dealerid", "Primeoqa", ""));
		WaitForPage.waitFor5Sec();
		
		System.out
				.println("************Valid Login  Verification Passed**************");
}
	
	
	
	
	
	
	
	@AfterMethod(alwaysRun = true)
	public void destroy(ITestResult result) throws FileNotFoundException,
			IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Test " + result.getName()
					+ " Failed, Snapshot is being taken");
			CaptureScreenshot.captureScreenshot(result.getName());
		}
		driverManager.closeBrowser();
	}
	//@AfterTest(alwaysRun=true)
	public void closeBrowser(){
		
		try {
			driverManager.closeBrowser();
			driverManager.quitBrowser();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets the builds the versions.
	 * 
	 * @return the builds the versions
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	/*@AfterClass(alwaysRun = true)
	public void getBuildVersions() throws FileNotFoundException, IOException,
			InterruptedException {
		try {
			driverManager.launchBrowser(browser);
			driver = driverManager.getDriver();
			driver.manage().window().maximize();
			loginPage = new LoginPage(driver);
			loginPage.getApplicationVersions(ConfigTestFixtures.getWebAppUrl(),
					ConfigTestFixtures.getAdminAppUrl());
			driverManager.closeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}