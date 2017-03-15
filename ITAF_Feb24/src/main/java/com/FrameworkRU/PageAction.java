/**
 * 
 */
package com.FrameworkRU;

import io.appium.java_client.AppiumDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Driver.DriverManager;

/**
 * The Class PageAction.
 * 
 * @author Praveen Gaddam and Kiran Kumar Cherukuri
 */
public class PageAction extends DriverManager {

	JavascriptExecutor jsExe;
	public WebDriverWait wait;
	String hostname;
	String uri;
	WebDriver driver;
	WebDriverWait driverWait;
	public static final int TIMEOUT = 60;
	
	@SuppressWarnings("rawtypes")
	AppiumDriver appiumDriver;
	//WebDriver webDriver;

	public String webEnv = "Primeoqa";
//	public String mobileEnv = "android";
	

	/**
	 * Instantiates a new page action.
	 *
	 * @param driver
	 *            the driver
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("rawtypes")
	public PageAction(AppiumDriver appiumDriver) throws FileNotFoundException, IOException {
		this.appiumDriver = appiumDriver;
		//appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		/*jsExe = (JavascriptExecutor) DriverManager.webDriver;
		wait = new WebDriverWait(driver, TIMEOUT);*/
	}


	/**
	 * Instantiates a new PageAction page.
	 * 
	 * @param driver
	 *            the driver
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */

	public PageAction(WebDriver driver) throws FileNotFoundException,
			IOException {
		this.driver = driver;
	}

	/**
	 * Gets the web element.
	 * 
	 * @param filename
	 *            the filename
	 * @param columnname
	 *            the columnname
	 * @return the web element
	 */

	public By getLocatorForUploadHistoryColumns(String filename,
			String columnname) {
		By locator = null;
		if (columnname.equalsIgnoreCase("Status")) {
			locator = By.cssSelector("[aria-label='Column File Name, Value "
					+ filename + "']+td");
		} else if (columnname.equalsIgnoreCase("Remarks")) {
			locator = By.cssSelector("[aria-label='Column File Name, Value "
					+ filename + "']+td+td");
		} else if (columnname.equalsIgnoreCase("Report")) {
			locator = By.cssSelector("[aria-label='Column File Name, Value "
					+ filename + "']+td+td+td>div");
		} else if (columnname.equalsIgnoreCase("fullName")) {
			locator = By.cssSelector("td[aria-label='Column Name, Value "
					+ filename + "']");
		} else if (columnname.equalsIgnoreCase("badgeId")) {
			locator = By.cssSelector("td[aria-label='Column ID, Value "
					+ filename + "']");
		}
		return locator;
	}

	/**
	 * Gets the web element by.
	 * 
	 * @param a
	 *            the a
	 * @return the web element by
	 */
	public By getWebElementBy(Map<String, String> a) {
		By locator = null;
		try {
			if (!a.get("PropertyType").isEmpty()) {
				if (a.get("PropertyType").toLowerCase().equals("id")) {
					locator = By.id(a.get("PropertyValue"));
				} else if (a.get("PropertyType").toLowerCase().equals("name")) {
					locator = By.name(a.get("PropertyValue"));
				} else if (a.get("PropertyType").toLowerCase().equals("xpath")) {
					locator = By.xpath(a.get("PropertyValue"));
				} else if (a.get("PropertyType").toLowerCase()
						.equals("linktext")) {
					locator = By.linkText(a.get("PropertyValue"));
				} else if (a.get("PropertyType").toLowerCase().equals("css")) {
					locator = By.cssSelector(a.get("PropertyValue"));
				}

			} else {
				System.out.println("Property type is empty");
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Property type is empty or some other error");
		}
		return locator;

	}

	/**
	 * Gets the web element.
	 * 
	 * @param map2
	 *            the map2
	 * @param keyWord
	 *            the key word
	 * @return the web element
	 */
	public By getElementLocator(Map<String, Map<String, String>> map2,
			String keyWord) {
		Map<String, String> map3 = map2.get(keyWord);
		By locator = getWebElementBy(map3);
		return locator;
	}

	/**
	 * Gets the web element.
	 * 
	 * @param a
	 *            the a
	 * @return the web element
	 */
	public WebElement getWebElement(Map<String, String> a) {
		WebElement we = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
			if (!a.get("PropertyType").isEmpty()) {
				if (a.get("PropertyType").toLowerCase().equals("id")) {
					wait.until(ExpectedConditions.presenceOfElementLocated(By
							.id(a.get("PropertyValue"))));
					we = driver.findElement(By.id(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("name")) {
					wait.until(ExpectedConditions.presenceOfElementLocated(By
							.name(a.get("PropertyValue"))));
					we = driver.findElement(By.name(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("xpath")) {
					wait.until(ExpectedConditions.presenceOfElementLocated(By
							.xpath(a.get("PropertyValue"))));
					we = driver.findElement(By.xpath(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase()
						.equals("linktext")) {
					wait.until(ExpectedConditions.presenceOfElementLocated(By
							.linkText(a.get("PropertyValue"))));
					we = driver
							.findElement(By.linkText(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("css")) {
					we = driver.findElement(By.cssSelector(a
							.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("class")) {
					we = driver
							.findElement(By.className(a.get("PropertyValue")));
				}
			} else {
				System.out.println("Property type is empty");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Property type is empty or some other error");
		}
		return we;
	}

	/**
	 * Gets the web element.
	 * 
	 * @param map2
	 *            the map2
	 * @param keyWord
	 *            the key word
	 * @return the web element
	 */
	public WebElement getWebElement(Map<String, Map<String, String>> map2,
			String keyWord) {
		Map<String, String> map3 = map2.get(keyWord);
		WebElement we = getWebElement(map3);
		return we;
	}
	
	/**
	 * Gets the web elements.
	 *
	 * @param map2
	 *            the map 2
	 * @param keyWord
	 *            the key word
	 * @return the web elements
	 */
	public List<WebElement> getWebElements(Map<String, Map<String, String>> map2, String keyWord) {
		Map<String, String> map3 = map2.get(keyWord);
		List<WebElement> list = getWebElements(map3);
		return list;
	}

	/**
	 * Gets the web elements.
	 *
	 * @param a
	 *            the a
	 * @return the web elements
	 */
	@SuppressWarnings("unchecked")
	public List<WebElement> getWebElements(Map<String, String> a) {
		List<WebElement> list = null;
		try {
			if (!a.get("PropertyType").isEmpty()) {
				if (a.get("PropertyType").toLowerCase().equals("id")) {
					Thread.sleep(500);
					list = driver.findElements(By.id(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("name")) {
					Thread.sleep(500);
					list = driver.findElements(By.name(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("xpath")) {
					Thread.sleep(500);
					list = driver.findElements(By.xpath(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("linktext")) {
					Thread.sleep(500);
					list = driver.findElements(By.linkText(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("css")) {
					Thread.sleep(500);
					list = driver.findElements(By.cssSelector(a.get("PropertyValue")));
				}else if (a.get("PropertyType").toLowerCase().equals("class")) {
					Thread.sleep(500);
					list = driver.findElements(By.className(a.get("PropertyValue")));
				}
			} else {
				System.out.println("Property type is empty");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Property type is empty or some other error");
		}
		return list;
	}
	
	public WebElement webGetWebElement(Map<String, Map<String, String>> map2, String keyWord) {
		Map<String, String> map3 = map2.get(keyWord);
		WebElement we = webGetWebElement(map3);
		return we;
	}

	public WebElement webGetWebElement(Map<String, String> a) {
		WebElement we = null;
		if (webEnv.equalsIgnoreCase("Primeoqa")) {
			try {
				if (!a.get("PropertyType").isEmpty()) {
					if (a.get("PropertyType").toLowerCase().equals("id")) {
						Thread.sleep(500);
						we = driver.findElement(By.id(a.get("PropertyValue")));
					} else if (a.get("PropertyType").toLowerCase().equals("name")) {
						Thread.sleep(500);
						we = driver.findElement(By.name(a.get("PropertyValue")));

					} else if (a.get("PropertyType").toLowerCase().equals("xpath")) {
						Thread.sleep(500);
						we = driver.findElement(By.xpath(a.get("PropertyValue")));

					} else if (a.get("PropertyType").toLowerCase().equals("linktext")) {
						Thread.sleep(500);
						we = driver.findElement(By.linkText(a.get("PropertyValue")));

					} else if (a.get("PropertyType").toLowerCase().equals("css")) {
						Thread.sleep(500);
						we = driver.findElement(By.cssSelector(a.get("PropertyValue")));
					}

				} else {
					System.out.println("Property type is empty");
				}

			} catch (Exception e) {
				System.out.println(e);
				System.out.println("Property type is empty or some other error");
			}
		}
		return we;
	}

	/**
	 * Switch to popup window.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public void switchToPopupWindow() throws FileNotFoundException,
			IOException, InterruptedException {
		try {
			Set<String> allWindows = driver.getWindowHandles();
			for (String currentWindow : allWindows) {
				// System.out.println("current window = "+currentWindow);
				System.out
						.println("************Pop up window Found************");
				driver.switchTo().window(currentWindow);
			}
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out
					.println("************Pop up window NOT Found************");
			ex.printStackTrace();
		}
	}

	/**
	 * Browser window max.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public void browserWindowMax() throws Exception {
		driver.manage().window().maximize();
	}

	/**
	 * Gets the dynamic xpath by locator.
	 * 
	 * @param value
	 *            the value
	 * @param columnname
	 *            the columnname
	 * @return the dynamic xpath by locator
	 */

	public By getDynamicXpathByLocator(String value, String columnname) {
		By locator = null;
		if (columnname.equalsIgnoreCase("Status")) {
			locator = By.cssSelector("[aria-label='Column File Name, Value "
					+ value + "']+td");
		} else if (columnname.equalsIgnoreCase("Remarks")) {
			locator = By.cssSelector("[aria-label='Column File Name, Value "
					+ value + "']+td+td");
		} else if (columnname.equalsIgnoreCase("Report")) {
			locator = By.cssSelector("[aria-label='Column File Name, Value "
					+ value + "']+td+td+td>div");
		} else if (columnname.equalsIgnoreCase("Name")) {
			locator = By.cssSelector("td[aria-label='Column " + columnname
					+ ", Value " + value + "']");
		} else if (columnname.equalsIgnoreCase("ID")) {
			locator = By.cssSelector("td[aria-label='Column " + columnname
					+ ", Value " + value + "']");
		} else if (columnname.equalsIgnoreCase(Constants.ASSET_COLUMN_SCANCODE)) {
			locator = By.cssSelector("[aria-label='Column Scan Code, Value "
					+ value + "']");
		} else if (columnname
				.equalsIgnoreCase(Constants.ASSET_COLUMN_ALTERNATECODE)) {
			locator = By
					.cssSelector("[aria-label='Column Alternate Code, Value "
							+ value + "']");
		} else if (columnname
				.equalsIgnoreCase(Constants.EMPLOYEE_DASHBOARD_COLUMN_USERNAME)) {
			locator = By.cssSelector("[aria-label='Column "
					+ Constants.EMPLOYEE_DASHBOARD_COLUMN_USERNAME + ", Value "
					+ value + "']");
		} else if (columnname
				.equalsIgnoreCase(Constants.EMPLOYEE_DASHBOARD_COLUMN_NAME)) {
			locator = By.cssSelector("[aria-label='Column "
					+ Constants.EMPLOYEE_DASHBOARD_COLUMN_NAME + ", Value "
					+ value + "']");
		} else if (columnname
				.equalsIgnoreCase(Constants.EMPLOYEE_DASHBOARD_COLUMN_EMAIL)) {
			locator = By.cssSelector("[aria-label='Column "
					+ Constants.EMPLOYEE_DASHBOARD_COLUMN_EMAIL + ", Value "
					+ value + "']");
		}
		return locator;
	}

	/**
	 * Gets the web element.
	 *
	 * @param a
	 *            the a
	 * @return the web element
	 */
	public WebElement getMobileWebElement(Map<String, String> a) {
		WebElement we = null;
		try {
			if (!a.get("PropertyType").isEmpty()) {
				if (a.get("PropertyType").toLowerCase().equals("id")) {
					Thread.sleep(500);
					we = appiumDriver.findElement(By.id(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("name")) {
					Thread.sleep(500);
					we = appiumDriver.findElement(By.name(a.get("PropertyValue")));

				} else if (a.get("PropertyType").toLowerCase().equals("xpath")) {
					Thread.sleep(500);
					we = appiumDriver.findElement(By.xpath(a.get("PropertyValue")));

				} else if (a.get("PropertyType").toLowerCase().equals("linktext")) {
					Thread.sleep(500);
					we = appiumDriver.findElement(By.linkText(a.get("PropertyValue")));

				} else if (a.get("PropertyType").toLowerCase().equals("css")) {
					Thread.sleep(500);
					we = appiumDriver.findElement(By.cssSelector(a.get("PropertyValue")));
				}
				
			} else {
				System.out.println("Property type is empty");
			}

		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Property type is empty or some other error");
		}
		return we;
	}

	/**
	 * Gets the web element.
	 *
	 * @param map2
	 *            the map 2
	 * @param keyWord
	 *            the key word
	 * @return the web element
	 */
	public WebElement getMobileWebElement(Map<String, Map<String, String>> map2, String keyWord) {
		Map<String, String> map3 = map2.get(keyWord);
		WebElement we = getMobileWebElement(map3);
		return we;
	}
	
	/**
	 * Gets the web elements.
	 *
	 * @param map2
	 *            the map 2
	 * @param keyWord
	 *            the key word
	 * @return the web elements
	 */
	public List<WebElement> getMobileElements(Map<String, Map<String, String>> map2, String keyWord) {
		Map<String, String> map3 = map2.get(keyWord);
		List<WebElement> list = getMobileElements(map3);
		return list;
	}

	/**
	 * Gets the web elements.
	 *
	 * @param a
	 *            the a
	 * @return the web elements
	 */
	@SuppressWarnings("unchecked")
	public List<WebElement> getMobileElements(Map<String, String> a) {
		List<WebElement> list = null;
		try {
			if (!a.get("PropertyType").isEmpty()) {
				if (a.get("PropertyType").toLowerCase().equals("id")) {
					Thread.sleep(500);
					list = appiumDriver.findElements(By.id(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("name")) {
					Thread.sleep(500);
					list = appiumDriver.findElements(By.name(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("xpath")) {
					Thread.sleep(500);
					list = appiumDriver.findElements(By.xpath(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("linktext")) {
					Thread.sleep(500);
					list = appiumDriver.findElements(By.linkText(a.get("PropertyValue")));
				} else if (a.get("PropertyType").toLowerCase().equals("css")) {
					Thread.sleep(500);
					list = appiumDriver.findElements(By.cssSelector(a.get("PropertyValue")));
				}else if (a.get("PropertyType").toLowerCase().equals("class")) {
					Thread.sleep(500);
					list = appiumDriver.findElements(By.className(a.get("PropertyValue")));
				}
			} else {
				System.out.println("Property type is empty");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Property type is empty or some other error");
		}
		return list;
	}

}