package com.web.tests.Views;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
import com.Loggers.Logs;
/*import com.web.modules.ASSETS.AssetsPage;
import com.web.modules.ASSETS.AssetsPageRU;
import com.web.modules.COMPANYSETTINGS.CompanySettingsPage;
import com.web.modules.COMPANYSETTINGS.CompanySettingsPageRU;
import com.web.modules.EMPLOYEES.EmployeesPage;
import com.web.modules.LOCATIONS.LocationsPageRU;*/
import com.web.modules.LOGIN.LoginPage;
import com.web.modules.LOGOUT.LogoutPage;
import com.web.modules.Views.ViewsPage;

import atu.testng.reports.ATUReports;

/**
 * The Class LoginTest.
 */
public class ViewsTest {
	{
		System.setProperty("atu.reporter.config", "C:/Demo_Framework1/ITAF_Feb24/Jars/Version 5.1.1/ATUReporter_Selenium_testNG_5.1.1 jar+javadoc+prop file+demo proj+atu recorder/atu.properties");
	}

	private static ExcelUtils excelUploadObject;
	WebDriver driver;
	ConfigTestFixtures configTestFixtures;
	private DriverManager driverManager;
	private LoginPage loginPage;
	private LogoutPage logoutPage;
	private ViewsPage viewsPage;
	//private static CompanySettingsPage companySettings;
	//private static CompanySettingsPageRU companySettingsRU;
	//private EmployeesPage employeesPage;
	/*LocationsPageRU locationsPageRU;*/
	PageAction pageAction;
	SendEmail sendEmail;
	/*AssetsPage assetsPage;
	AssetsPageRU assetsPageRU;*/
	CleanupTestData cleanupTestData;
	public static boolean assetsXMLUploadStatus;

/*	String env = System.getProperty("environment");
	String browser = System.getProperty("browser");*/
	
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
			AssertJUnit.fail("Data Clean Up Configuration Failed, Please check and delete data manually before starting the TESTS");
		}
	}

	/**
	 * Test method prerequisites.
	 * 
	 * @throws Exception
	 *             the exception
	 */

	@BeforeMethod(alwaysRun = true)
	public void testMethodPrerequisites() throws Exception {
		driverManager = new DriverManager();

		System.out.println("environment ======= " + env);
		System.out.println("browser ==========" + browser);
		driverManager.launchBrowser(browser);
		driver = driverManager.getDriver();
		configTestFixtures = new ConfigTestFixtures();
		loginPage = new LoginPage(driver);
		viewsPage = new ViewsPage(driver);
		new CaptureScreenshot(driver);
		pageAction = new PageAction(driver);
		sendEmail = new SendEmail();
		// assetsPage = new AssetsPage(driver);
		// assetsPageRU = new AssetsPageRU(driver);
	}
	@BeforeTest
	public void ATU(){
		ATUReports.setWebDriver(driver);
		ATUReports.indexPageDescription = "Test Project";
	}

	/**
	 * Invalid employee validation.
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	@Test(priority = 1, enabled = true, groups = { "Sanity" })
	public void creatingView() throws FileNotFoundException, Exception {
		
			
			configTestFixtures.generateConfigTestData(env);
			/*excelUploadObject = new ExcelUtils(
					Constants.DATAFILE_EMPLOYEES_PATH
							+ Constants.EMPLOYEES_ERROR_MESSAGES_FILE);*/
			driverManager.loadURL(ConfigTestFixtures.getWebAppUrl());
			loginPage.
		    portalSignIn(
				PropertyReader.getPropValuesFromConfig("web.app.username", "Primeoqa"), 
				PropertyReader.getPropValuesFromConfig("web.app.password", "Primeoqa"), 
				PropertyReader.getPropValuesFromConfig("web.app.dealerid", "Primeoqa"));
		WaitForPage.waitFor5Sec();
		System.out
		.println("************View Creation Started**************");
			
			viewsPage.
			   createView(
					   PropertyReader.getPropValuesFromConfig("web.app.viewname", "Primeoqa"),
					   PropertyReader.getPropValuesFromConfig("web.app.viewsourcetable", "Primeoqa"),
					   PropertyReader.getPropValuesFromConfig("web.app.viewcolumns", "Primeoqa"));
			
			
			System.out
					.println("************View Creation Passed**************");
	}
	//@AfterMethod(alwaysRun=true)
	public void CloseBrowser(){
		driver.close();
		driver.quit();
	}
}
