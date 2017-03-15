package com.web.tests.TIDTESTCASES;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Driver.DriverManager;
import com.FrameworkRU.ApplicationUtils;
import com.FrameworkRU.CaptureScreenshot;
import com.FrameworkRU.CleanupTestData;
import com.FrameworkRU.ConfigTestFixtures;
import com.FrameworkRU.Constants;
import com.FrameworkRU.PageAction;
import com.FrameworkRU.PropertyReader;
import com.FrameworkRU.SendEmail;
import com.FrameworkRU.VerifyEmail;
/*import com.web.modules.ADMINPORTAL.CustomersInAdminPortalPage;
import com.web.modules.ASSETS.AssetsPage;
import com.web.modules.ASSETS.AssetsPageRU;
import com.web.modules.COMPANYSETTINGS.CompanySettingsPage;
import com.web.modules.COMPANYSETTINGS.CompanySettingsPageRU;
import com.web.modules.EMPLOYEES.EmployeesPage;
import com.web.modules.LOCATIONS.LocationsPageRU;*/
import com.web.modules.LOGIN.LoginPage;
import com.web.modules.LOGOUT.LogoutPage;

/**
 * The Class TIDTestCasesTest.
 */
public class TIDTestCasesTest {
	WebDriver driver;
	ConfigTestFixtures configTestFixtures;
	private DriverManager driverManager;
	private LoginPage loginPage;
	private LogoutPage logoutPage;
	/*private EmployeesPage employeesPage;
	LocationsPageRU locationsPageRU;*/
	PageAction pageAction;
	SendEmail sendEmail;
	/*AssetsPage assetsPage;
	AssetsPageRU assetsPageRU;*/
	CleanupTestData cleanupTestData;
	public static boolean assetsXMLUploadStatus;
	//CustomersInAdminPortalPage customersInAdminPortalPage;

	/*
	 * String env = System.getProperty("webEnv"); String browser =
	 * System.getProperty("browser");
	 */

	String env = "Primeoqa";
	String browser = "chrome";

	String badgeId = "badgeId";
	String fullName = "fullName";


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
		logoutPage = new LogoutPage(driver);
		new LogoutPage(driver);
		new CaptureScreenshot(driver);
		/*new CompanySettingsPage(driver);
		new CompanySettingsPageRU(driver);
		locationsPageRU = new LocationsPageRU(driver);
		employeesPage = new EmployeesPage(driver);*/
		pageAction = new PageAction(driver);
		sendEmail = new SendEmail();
		/*assetsPage = new AssetsPage(driver);
		assetsPageRU = new AssetsPageRU(driver);
		customersInAdminPortalPage = new CustomersInAdminPortalPage(driver);*/
	}

	/**
	 * Assign admin role to new employee.
	 */
	/*@Test(priority = 1, enabled = true, groups = { "Sanity" })
	public void ValidWebAutomationTest() {
		try {
			System.out.println(
					"************Adding of New Employee with ADMIN Role Test Verification Started**************");
			configTestFixtures.generateConfigTestData(env);
			driverManager.loadURL(ConfigTestFixtures.getWebAppUrl());
			loginPage.portalSignIn(PropertyReader.getRuntimeTestData("Excel_Common_EmployeeUsername"),
					PropertyReader.getRuntimeTestData("Excel_Common_EmployeeUserPassword"));
			String fn = "FN" + ApplicationUtils.getUniqueString(5);
			String ln = "LN" + ApplicationUtils.getUniqueString(5);
			String fullname = fn + " " + ln;
			String domainName = ApplicationUtils
					.getDomainwithAtTheRate(PropertyReader.getRuntimeTestData("Excel_Common_EmployeeUsername"));
			employeesPage.createEmployee(fn, ln, true, ConfigTestFixtures.getEmailId4(), Constants.EMPLOYEE_ROLE_ADMIN,
					domainName);
			logoutPage.portalLogOut();
			VerifyEmail.getConfirmationEmail(fn, ln, ConfigTestFixtures.getEmailId4(),
					ConfigTestFixtures.getEmailpwd4());
			String username = VerifyEmail.emailIdFromConfirmationEmail;
			String password = PropertyReader.getTestData("ResetPassword");
			loginPage.changePassword(VerifyEmail.confirmationEmailUrl, username, password, password);
			String portalUrl = ConfigTestFixtures.getWebAppUrl();
			loginPage.signInAfterUserActivation(portalUrl, username, password);
			String actualusername = fn + ln + domainName;
			employeesPage.validateNewEmployeeOnUI(actualusername, fullname, ConfigTestFixtures.getEmailId4(), true,
					Constants.EMPLOYEE_ROLE_ADMIN);
			logoutPage.portalLogOut();
			System.out.println(
					"************Addition of New Employee with ADMIN Role Test Verification Passed**************");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("************Addition of New Employee with ADMIN Role Test Verification Failed**************"
					+ e.getCause().getStackTrace());
		}
	}

	*//**
	 * Update email Id for existing employee.
	 *//*
	@Test(priority = 2, enabled = true, groups = { "Sanity" })
	public void InvalidWebAutomationTest() {
		try {
			System.out.println(
					"************Updation of Email ID for Existing Employee Test Verification Started**************");
			configTestFixtures.generateConfigTestData(env);
			driverManager.loadURL(ConfigTestFixtures.getWebAppUrl());
			loginPage.portalSignIn(PropertyReader.getRuntimeTestData("Excel_Common_EmployeeUsername") + "test",
					PropertyReader.getRuntimeTestData("Excel_Common_EmployeeUserPassword") + "test");
			String fn = "FN" + ApplicationUtils.getUniqueString(5);
			String ln = "LN" + ApplicationUtils.getUniqueString(5);
			String fullname = fn + " " + ln;
			String domainName = ApplicationUtils
					.getDomainwithAtTheRate(PropertyReader.getRuntimeTestData("Excel_Common_EmployeeUsername"));
			employeesPage.createEmployee(fn, ln, true, ConfigTestFixtures.getEmailId4(), Constants.EMPLOYEE_ROLE_ADMIN,
					domainName);
			logoutPage.portalLogOut();
			VerifyEmail.getConfirmationEmail(fn, ln, ConfigTestFixtures.getEmailId4(),
					ConfigTestFixtures.getEmailpwd4());
			String username = VerifyEmail.emailIdFromConfirmationEmail;
			String password = PropertyReader.getTestData("ResetPassword");
			loginPage.changePassword(VerifyEmail.confirmationEmailUrl, username, password, password);
			String portalUrl = ConfigTestFixtures.getWebAppUrl();
			loginPage.signInAfterUserActivation(portalUrl, username, password);
			String actualusername = fn + ln + domainName;
			employeesPage.updateEmailIDForEmployee(actualusername, ConfigTestFixtures.getEmailId4(),
					ConfigTestFixtures.getExceluploadEmailId());
			logoutPage.portalLogOut();
			VerifyEmail.getEmailChangeConfirmationEmail(fn, ln, ConfigTestFixtures.getExceluploadEmailId(),
					ConfigTestFixtures.getEmailId4(), ConfigTestFixtures.getEmailpwd4());
			VerifyEmail.getConfirmationEmail(fn, ln, ConfigTestFixtures.getExceluploadEmailId(),
					ConfigTestFixtures.getExceluploadEmailPwd());
			username = VerifyEmail.emailIdFromConfirmationEmail;
			password = PropertyReader.getTestData("ResetPassword");
			loginPage.changePassword(VerifyEmail.confirmationEmailUrl, username, password, password);
			portalUrl = ConfigTestFixtures.getWebAppUrl();
			loginPage.signInAfterUserActivation(portalUrl, username, password);
			actualusername = fn + ln + domainName;
			employeesPage.validateNewEmployeeOnUI(actualusername, fullname, ConfigTestFixtures.getExceluploadEmailId(),
					true, Constants.EMPLOYEE_ROLE_ADMIN);
			logoutPage.portalLogOut();
			System.out.println(
					"************Updation of Email ID for Existing Employee Test Verification Passed**************");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("************Updation of Email ID for Existing Employee Test Verification Failed**************"
					+ e.getCause().getStackTrace());
		}
	}

	*//**
	 * Reset password through email.
	 *//*
	@Test(priority = 3, enabled = false, groups = { "Sanity" })
	public void resetPasswordThroughEmail() {
		try {
			System.out.println(
					"************Resetting password after reset password through email  Test  Started**************");
			configTestFixtures.generateConfigTestData(env);
			driverManager.loadURL(ConfigTestFixtures.getAdminAppUrl());
			loginPage.portalSignIn(ConfigTestFixtures.getAdminAppUsername(), ConfigTestFixtures.getAdminAppPassword());
			String firstName = "fn" + ApplicationUtils.getUniqueString(6);
			String customerName = "cn" + ApplicationUtils.getUniqueString(6);
			String lastName = "ln" + ApplicationUtils.getUniqueString(6);
			String userName = "un" + ApplicationUtils.getUniqueString(6);
			String domainName = "dn" + ApplicationUtils.getUniqueString(6) + "im.com";
			String email = ConfigTestFixtures.getEmailId4();
			String password = ConfigTestFixtures.getEmailpwd4();
			String userId = userName + "@" + domainName;
			String passwordUpdated = PropertyReader.getTestData("PasswordUpdated");
			customersInAdminPortalPage.addCustomer(customerName, domainName, firstName, lastName, userName, email);
			VerifyEmail.getConfirmationEmail(firstName, lastName, email, password);
			loginPage.changePassword(VerifyEmail.confirmationEmailUrl, userId, passwordUpdated, passwordUpdated);
			String portalUrl = ConfigTestFixtures.getWebAppUrl();
			loginPage.signInAfterUserActivation(portalUrl, userId, passwordUpdated);
			boolean a, b;
			a = loginPage.findHome();
			loginPage.portalLogOut();
			loginPage.clickOnForgotPasswordLink();
			loginPage.enterForgotUsername(userId);
			loginPage.clickOnSubmitForgotPassword();
			VerifyEmail.getConfirmationEmailChangePassword(firstName, lastName, email, password);
			String passwordReset = PropertyReader.getTestData("PasswordReset");
			loginPage.changePassword(VerifyEmail.confirmationEmailUrlChangePassword, userId, passwordReset,
					passwordReset);
			loginPage.signInAfterUserActivation(portalUrl, userId, passwordReset);
			b = loginPage.findHome();
			if (a && b) {
				System.out.println(
						"************Resetting password after reset password through email  Test   Passed**************");
			} else {
				Assert.fail(
						"************Resetting password after reset password through email  Test  Failed**************");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			Assert.fail("************Resetting password after reset password through email  Test  Failed**************"
					+ e.getCause().getStackTrace());
		}
	}

	*//**
	 * Privileges of admin everyone.
	 *//*
	@Test(priority = 4, enabled = false, groups = { "Sanity" })
	public void privilegesOfAdminEveryone() {
		try {
			System.out.println("************Privileges of Amin and Everyone Test Verification Started**************");
			configTestFixtures.generateConfigTestData(env);
			driverManager.loadURL(ConfigTestFixtures.getWebAppUrl());
			loginPage.portalSignIn(PropertyReader.getRuntimeTestData("Excel_Common_EmployeeUsername"),
					PropertyReader.getRuntimeTestData("Excel_Common_EmployeeUserPassword"));
			employeesPage.clickOnEmployee();
			employeesPage.clickOnRolesTab();
			employeesPage.verifyAdminPrivileges();
			employeesPage.verifyAdminAdditionalPrivileges();
			employeesPage.clickOnEveryOne();
			employeesPage.verifyEveryOnePrivileges();
			employeesPage.verifyEveryOneAdditionalPrivileges();
			System.out.println("************Privileges of Amin and Everyone Test passed**************");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("************Privileges of Amin and Everyone  Test  Failed**************"
					+ e.getCause().getStackTrace());
		}
	}

	@Test(priority = 5, enabled = false, groups = { "Sanity" })
	public void createNewTenant() {
		try {
			System.out.println("************Crerating a new tenant  Test  Started**************");
			configTestFixtures.generateConfigTestData(env);
			driverManager.loadURL(ConfigTestFixtures.getAdminAppUrl());
			loginPage.portalSignIn(ConfigTestFixtures.getAdminAppUsername(), ConfigTestFixtures.getAdminAppPassword());
			String firstName = "fn" + ApplicationUtils.getUniqueString(6);
			String customerName = "cn" + ApplicationUtils.getUniqueString(6);
			String lastName = "ln" + ApplicationUtils.getUniqueString(6);
			String userName = "un" + ApplicationUtils.getUniqueString(6);
			String domainName = "dn" + ApplicationUtils.getUniqueString(6) + "im.com";
			String email = ConfigTestFixtures.getEmailId4();
			String password = ConfigTestFixtures.getEmailpwd4();
			String userId = userName + "@" + domainName;
			String passwordUpdated = PropertyReader.getTestData("PasswordUpdated");
			customersInAdminPortalPage.addCustomer(customerName, domainName, firstName, lastName, userName, email);
			VerifyEmail.getConfirmationEmail(firstName, lastName, email, password);
			loginPage.changePassword(VerifyEmail.confirmationEmailUrl, userId, passwordUpdated, passwordUpdated);
			String portalUrl = ConfigTestFixtures.getWebAppUrl();
			loginPage.signInAfterUserActivation(portalUrl, userId, passwordUpdated);
			boolean a, b;
			a = loginPage.findHome();
			if (a) {
				System.out.println("************Creating a new tenant Test passed**************");
			} else {
				Assert.fail("************Creating a new tenant Test  Failed**************");
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("************Creating a new tenant Test  Failed**************" + e.getCause().getStackTrace());
		}
	}

	@Test(priority = 6, enabled = false, groups = { "Sanity" })
	public void addingSupportAccessCustomerAdminEmployee() {
		try {
			System.out.println(
					"************Adding a Support Access and Customer Admin Employee Test  Started**************");
			configTestFixtures.generateConfigTestData(env);
			driverManager.loadURL(ConfigTestFixtures.getAdminAppUrl());
			loginPage.portalSignIn(ConfigTestFixtures.getAdminAppUsername(), ConfigTestFixtures.getAdminAppPassword());
			String customerNameConsole = "autoone";
			customersInAdminPortalPage.enterTexInSearchBoxOnCustomers(customerNameConsole);
			customersInAdminPortalPage.clickCustomerNameLink();
			customersInAdminPortalPage.clickOnManageAdminAccessTab();
			customersInAdminPortalPage.clickOnAddBtnOnManageAdminAccessPage();
			String firstName = "fn" + ApplicationUtils.getUniqueString(6);
			String customerName = "cn" + ApplicationUtils.getUniqueString(6);
			String lastName = "ln" + ApplicationUtils.getUniqueString(6);
			String userName = "un" + ApplicationUtils.getUniqueString(6);
			String email = ConfigTestFixtures.getEmailId4();
			String password = ConfigTestFixtures.getEmailpwd4();
			String accessTypeSA = "Support Access";
			String accessTypeCA = "Customer Admin";
			customersInAdminPortalPage.addCustomerEmployee(customerName, firstName, lastName, userName, email,
					accessTypeSA);
			VerifyEmail.getConfirmationEmail(firstName, lastName, email, password);
			boolean c = !VerifyEmail.errorFoundNew;
			customersInAdminPortalPage.clickOnAddBtnOnManageAdminAccessPage();
			String firstNamee = "fn" + ApplicationUtils.getUniqueString(6);
			String customerNamee = "cn" + ApplicationUtils.getUniqueString(6);
			String lastNamee = "ln" + ApplicationUtils.getUniqueString(6);
			String userNamee = "un" + ApplicationUtils.getUniqueString(6);
			customersInAdminPortalPage.addCustomerEmployee(customerNamee, firstNamee, lastNamee, userNamee, email,
					accessTypeCA);
			VerifyEmail.getConfirmationEmail(firstName, lastName, email, password);
			boolean d = !VerifyEmail.errorFoundNew;
			if (c && d) {
				System.out.println(
						"************Adding a Support Access and Customer Admin Employee Test  Passed**************");

			} else {
				Assert.fail("************On Track activation mail not received and test case got failed**************");
			}

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("************Adding a Support Access and Customer Admin Employee Test  Failed**************"
					+ e.getCause().getStackTrace());
		}
	}
*/
	/**
	 * Destroy.
	 * 
	 * @param result
	 *            the result
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@AfterMethod(alwaysRun = true)
	public void destroy(ITestResult result) throws FileNotFoundException, IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Test " + result.getName() + " Failed, Snapshot is being taken");
			CaptureScreenshot.captureScreenshot(result.getName());
		}
		driverManager.closeBrowser();
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
	@AfterClass(alwaysRun = true)
	public void getBuildVersions() throws FileNotFoundException, IOException, InterruptedException {
		try {
			driverManager.launchBrowser(browser);
			driver = driverManager.getDriver();
			driver.manage().window().maximize();
			loginPage = new LoginPage(driver);
			loginPage.getApplicationVersions(ConfigTestFixtures.getWebAppUrl(), ConfigTestFixtures.getAdminAppUrl());
			driverManager.closeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
