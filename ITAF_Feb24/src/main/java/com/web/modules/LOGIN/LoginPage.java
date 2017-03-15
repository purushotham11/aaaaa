package com.web.modules.LOGIN;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.FrameworkRU.PageAction;
import com.FrameworkRU.ReadObjectRepo;
import com.FrameworkRU.WaitForPage;

/**
 * 
 * @author Kiran Kumar Cherukuri
 * 
 */

public class LoginPage 
{
	Actions action;
	WebDriver driver;
	PageAction pageAction;
	WaitForPage waitForPage;
	Map<String, Map<String, String>> loginOR_Map;
	private static String portalUserName = "Username";
	private static String portalPassword = "Password";
	private static String portalDealerId = "DealerID";
	private static String banner = "BannerBelow";
	private static String portalLoginBtn = "LoginButton";
	public static String adminApplicationVersion="";
	public static String userApplicationVersion="";
	private static String applicationVersion = "ApplicationVersion";
	private static String forgotUserName = "ForgotUserName";
	private static String forgotPassword = "ForgotPassword";
	private static String confirmPassword = "ConfirmPassword";
	private static String setPasswordBtn = "SetPasswordBtn";
	private String forgotSubmitBtn= "ForgotSubmitBtn";
	private String findHome="FindHome";
	private String portalLoginLinkOnDashboard = "PortalLoginLink";
	private String portalLogoutLinkOnDashboard = "PortalLogout";
	private String forgotPasswordLink="ForgotPasswordLink";

	/**
	 * Instantiates a new login page.
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public LoginPage(WebDriver driver) throws IOException 
	{
		this.driver = driver;
		ReadObjectRepo loginORS = new ReadObjectRepo("PrimeO_OR");
		loginOR_Map = loginORS.generateOR("Login_OR");
		pageAction = new PageAction(driver);
		new WaitForPage(driver);
	}
	
	
	/**
	 * Portal sign in.
	 *
	 * @param uName the u name
	 * @param pWord the word
	 * @throws Exception the exception
	 */
	public void portalSignIn(String uName, String pWord, String dealerId)
			throws Exception 
	{
		enterUserName(uName);
		enterPassword(pWord);
		enterDealerid(dealerId);
		clickLoginBtn();		
	}
	
	/**
	 * Enter user name.
	 *
	 * @param uName the u name
	 * @throws Exception the exception
	 */
	private void enterUserName(String uName) throws Exception
	{
		WebElement we = pageAction.getWebElement(loginOR_Map, portalUserName);
		WaitForPage.WaitForWebElement(we);
		we.clear();
		we.sendKeys(uName);
		
		
	}
	
	/**
	 * Click login btn.
	 *
	 * @throws Exception the exception
	 */
	private void clickLoginBtn() throws Exception {
		WebElement we = pageAction.getWebElement(loginOR_Map, portalLoginBtn);
		we.click();
		WaitForPage.waitForPagetoLoad();
		List<WebElement> btnSize=driver.findElements(By.id("login_submit"));
		WaitForPage.waitForPagetoLoad();
		if(btnSize.size()==0)
		{
			System.out.println("User successfully logged in to application");
			/*if(!(driver.getCurrentUrl().contains("Adminportal")))
			{
				findBannerBelow();
			}*/
		}
		else
		{	
			Assert.fail("Application Login Failed, Test Failed");
		}
	}
	
	/**
	 * Enter password.
	 *
	 * @param pWord the word
	 * @throws Exception the exception
	 */
	private void enterPassword(String pWord) throws Exception {
		WebElement we = pageAction.getWebElement(loginOR_Map, portalPassword);
		WaitForPage.WaitForWebElement(we);
		we.clear();
		we.sendKeys(pWord);

	}
	
	private void enterDealerid(String dealerId) throws Exception {
		WebElement we = pageAction.getWebElement(loginOR_Map, portalDealerId);
		WaitForPage.WaitForWebElement(we);
		we.clear();
		we.sendKeys(dealerId);

	}
	
	/**
	 * Find banner below.
	 *
	 * @throws Exception the exception
	 */
	public void findBannerBelow() throws Exception {
		WebElement we = pageAction.getWebElement(loginOR_Map, banner);
		if (we.isDisplayed()) {
			we.click();
		}
	}
	
	/**
	 * Click on submit forgot password.
	 */
	public void clickOnSubmitForgotPassword()
	{
		WebElement we = pageAction.getWebElement(loginOR_Map,forgotSubmitBtn);
		we.click();
		WaitForPage.waitForPagetoLoad();
	}
	
	/**
	 * Find home.
	 *
	 * @return true, if successful
	 */
	public boolean findHome()
	{
		WebElement findHomeElement = pageAction.getWebElement(loginOR_Map, findHome);
		boolean a=findHomeElement.isDisplayed();
		return a;
	}
	/**
	 * Gets the application versions.
	 *
	 * @param AppURL the app URL
	 * @param AdminURL the admin URL
	 * @return the application versions
	 * @throws Exception the exception
	 */
	public void getApplicationVersions(String AppURL,String AdminURL) throws Exception
	{
		
		driver.get(AppURL);
		Thread.sleep(1000);
		WebElement applicationversion_element = pageAction.getWebElement(loginOR_Map, applicationVersion);
		if(driver.getCurrentUrl().contains("ontrack"))
		{
			userApplicationVersion=applicationversion_element.getText();
		}	
		driver.get(AdminURL);
		Thread.sleep(1500);
		applicationversion_element = pageAction.getWebElement(loginOR_Map, applicationVersion);
		if(driver.getCurrentUrl().contains("Adminportal"))
		{
			adminApplicationVersion=applicationversion_element.getText();
		}
	}
	
	/**
	 * Portal log out.
	 */
	public void portalLogOut() {
		WebElement we = pageAction.getWebElement(loginOR_Map,
				portalLoginLinkOnDashboard);
		we.click();
		WaitForPage.waitForPagetoLoad();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
		WebElement we1 = pageAction.getWebElement(loginOR_Map,
				portalLogoutLinkOnDashboard);
		we1.click();
		WaitForPage.waitForPagetoLoad();
	}
	
	/**
	 * Click on forgot password link.
	 */
	public void clickOnForgotPasswordLink()
	{
		WebElement we = pageAction.getWebElement(loginOR_Map,
				forgotPasswordLink);
		we.click();
		WaitForPage.waitForPagetoLoad();
	}
	/**
	 * Change password.
	 *
	 * @param url the url
	 * @param forgotUName the forgot U name
	 * @param forgotPassword the forgot password
	 * @param confirmPassword the confirm password
	 * @throws InterruptedException the interrupted exception
	 */
	public void changePassword(String url, String forgotUName,
			String forgotPassword, String confirmPassword)
			throws InterruptedException {
		WaitForPage.waitForPagetoLoad();
		driver.get(url);
		enterForgotUsername(forgotUName);
		enterForgotPassword(forgotPassword);
		enterConfirmPassword(confirmPassword);
		clickOnSetPasswordBtn();
	}
	
	/**
	 * Enter forgot username.
	 *
	 * @param forgotUName the forgot U name
	 */
	public void enterForgotUsername(String forgotUName) {
		WebElement we = pageAction.getWebElement(loginOR_Map, forgotUserName);
		WaitForPage.WaitForWebElement(we);
		we.clear();
		we.sendKeys(forgotUName);
	}
	
	/**
	 * Enter forgot password.
	 *
	 * @param forgotPwd the forgot pwd
	 */
	public void enterForgotPassword(String forgotPwd) {
		WebElement we = pageAction.getWebElement(loginOR_Map, forgotPassword);
		WaitForPage.WaitForWebElement(we);
		we.clear();
		we.sendKeys(forgotPwd);
	}
	
	/**
	 * Enter confirm password.
	 *
	 * @param forgotConfirmPwd the forgot confirm pwd
	 */
	public void enterConfirmPassword(String forgotConfirmPwd) {
		WebElement we = pageAction.getWebElement(loginOR_Map, confirmPassword);
		WaitForPage.WaitForWebElement(we);
		we.clear();
		we.sendKeys(forgotConfirmPwd);
	}
	
	/**
	 * Click on set password btn.
	 */
	public void clickOnSetPasswordBtn() {
		WebElement we = pageAction.getWebElement(loginOR_Map, setPasswordBtn);
		WaitForPage.WaitForWebElement(we);
		we.click();
		WaitForPage.waitForPagetoLoad();
	}
	
	/**
	 * Sign in after user activation.
	 *
	 * @param url the url
	 * @param userName the user name
	 * @param password the password
	 * @param dealerId 
	 * @throws Exception the exception
	 */
	public void signInAfterUserActivation(String url, String userName,
			String password, String dealerId) throws Exception {
		WaitForPage.waitForPagetoLoad();
		driver.get(url);
		portalSignIn(userName, password, dealerId);
	}
	
	

}
