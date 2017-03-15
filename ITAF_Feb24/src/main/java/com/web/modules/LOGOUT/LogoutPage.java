package com.web.modules.LOGOUT;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.FrameworkRU.PageAction;
import com.FrameworkRU.ReadObjectRepo;
import com.FrameworkRU.WaitForPage;

/**
 * 
 * @author Kiran Kumar Cherukuri
 * 
 */

public class LogoutPage 
{
	Map<String, Map<String, String>> logoutOR_Map;
	private String portalLoggedinUserNameLinkOnDashboard = "LoggedinUserNameLink";
	private String portalLogoutLinkOnDashboard = "LogoutButton";
	public static String adminApplicationVersion="";
	public static String userApplicationVersion="";
	Actions action;
	WebDriver driver;
	PageAction pageAction;

	
	/**
	 * Instantiates a new logout page.
	 *
	 * @param driver the driver
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public LogoutPage(WebDriver driver) throws IOException 
	{
		this.driver = driver;
		ReadObjectRepo loginORS = new ReadObjectRepo("PrimeO_OR");
		logoutOR_Map = loginORS.generateOR("Login_OR");
		pageAction = new PageAction(driver);
	}

	/**
	 * Portal log out.
	 * @throws Exception 
	 */
	public void portalLogOut() throws Exception {
		
		WebElement we = pageAction.getWebElement(logoutOR_Map,
				portalLoggedinUserNameLinkOnDashboard);
		System.out.println("Logged in user name ---- " + we.getText());
		we.click();
		WebElement we1 = pageAction.getWebElement(logoutOR_Map,
				portalLogoutLinkOnDashboard);
		WaitForPage.waitForPagetoLoad();
		we1.click();
		
		
		/*WebElement we = pageAction.getWebElement(logoutOR_Map,
				portalLoginLinkOnDashboard);
		we.click();
		WebElement we1 = pageAction.getWebElement(logoutOR_Map,
				portalLogoutLinkOnDashboard);
		WaitForPage.waitForPagetoLoad();
		we1.click();*/
	}

}
