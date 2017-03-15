package com.Driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.FrameworkRU.Constants;
import com.FrameworkRU.PropertyReader;

/**
 * The Class Driver Manager.
 * 
 * @author Praveen Gaddam and Kiran Kumar Cherukuri
 */
public class DriverManager {

	protected static String browser;
	protected static String os;
	public static WebDriver driver;
	private static Logger log;
	public static String browsername;

	/**
	 * Instantiates a new selenium browser.
	 * 
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public DriverManager() throws FileNotFoundException, IOException {

		File file = new File(Constants.REPORT_DOWNLOAD_LOCATION);
		if (file.exists()) {
			file.delete();
			file.mkdir();
		} else {
			file.mkdir();
		}
	}

	/**
	 * Gets the driver.
	 * 
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Gets the OS version.
	 * 
	 * @return the OS version
	 */
	private static String getOSVersion() {
		System.out.println("Operating System=" + System.getProperty("os.name"));
		return System.getProperty("os.name");
	}

	/**
	 * Sets the up selenium environment.
	 * 
	 * @param browser
	 *            the new up selenium environment
	 */
	public void setupSeleniumEnvironment(String browser) {
		DriverManager.os = getOSVersion();
		System.out.println("OS Version = " + DriverManager.os + ", os.arch = "
				+ System.getProperty("os.arch"));
		String passedBrowser = browser;
		// String passedBrowser = Property.getProperty("browser");
		System.out.println("browser to run = " + passedBrowser);
		if (passedBrowser != null) {
			DriverManager.browser = passedBrowser;
		} else {
			DriverManager.browser = "chrome";
		}
		printEnvInfo();
	}

	/**
	 * Launch browser.
	 * 
	 * @param browser
	 *            the browser
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	// checks the browser input, and defaults to IE if there are any issues.
	public void launchBrowser(String browser) throws FileNotFoundException,
			IOException {
		browsername = browser;
		setupSeleniumEnvironment(browser);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		if (browser.toLowerCase().equals("iexplore")
				|| browser.toLowerCase().equals("ie")
				|| browser.toLowerCase().equals("internet explorer")) {
			browser = "iexplore";

			if (os.contains("Windows")) {
				if (System.getProperty("os.arch").contains("86")) {
					System.setProperty("webdriver.ie.driver",
							"src\\test\\resources\\Drivers\\iexplore\\IEDriverServer_win_32_X86.exe");
				} else if (System.getProperty("os.arch").contains("64")) {
					System.setProperty("webdriver.ie.driver",
							"src\\test\\resources\\Drivers\\iexplore\\IEDriverServer_win_X64.exe");
				}
			} else {
				System.out.println("Unexpected Operating System");

			}

			driver = new InternetExplorerDriver();
		} else if (browser.toLowerCase().equals("firefox")
				|| browser.toLowerCase().equals("ff")) {
			browser = "firefox";
			System.setProperty("webdriver.gecko.driver", "C:\\PrimeO_Project\\ITAF_Feb24\\src\\test\\resources\\Drivers\\Gecko\\geckodriver.exe");
			File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			//FirefoxProfile firefoxProfile = new FirefoxProfile();       
			// driver = new FirefoxDriver(ffBinary,firefoxProfile);
			// driver = new FirefoxDriver(cap1);
			driver = new FirefoxDriver();
		} else if (browser.toLowerCase().equals("chrome")
				|| browser.toLowerCase().equals("google")
				|| browser.toLowerCase().equals("google chrome")
				|| browser.toLowerCase().equals("googlechrome")) {

			browser = "googlechrome";
			if (os.contains("Windows")) {

				System.setProperty("webdriver.chrome.driver",
						"src\\test\\resources\\Drivers\\chrome\\chromedriver_win32\\chromedriver.exe");

				System.out.println(System
						.getProperty("webdriver.chrome.driver"));
				HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
				chromePrefs.put("profile.default_content_settings.popups", 0);
				chromePrefs.put("download.default_directory",
						Constants.REPORT_DOWNLOAD_LOCATION);
				ChromeOptions options = new ChromeOptions();
				HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
				options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("chrome.switches", "--disable-extensions");
				cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
				// cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, options);

			} else if (os.equals("Linux")
					&& System.getProperty("os.arch").contains("64")) {
				System.setProperty("webdriver.chrome.driver",
						"src\\test\\resources\\Drivers\\chrome\\chromedriver_linux64\\chromedriver");
			} else if (os.equals("Linux")
					&& !System.getProperty("os.arch").contains("86")) {
				System.setProperty("webdriver.chrome.driver",
						"src\\test\\resources\\Drivers\\chrome\\chromedriver_linux32\\chromedriver");
			} else if (os.contains("Mac")) {
				System.setProperty("webdriver.chrome.driver",
						"src\\test\\resources\\Drivers\\chrome\\chromedriver_mac\\chromedriver");
			} else {
				System.out.println("Unexpected Operating System");

			}

			driver = new ChromeDriver(cap);
		}

		else {
			System.out.println(browser.toLowerCase());
			browser = "iexplore";
			driver = new InternetExplorerDriver();
		}

	}

	/**
	 * Gets the current browser type.
	 * 
	 * @return the current browser type
	 */
	public static String getCurrentBrowserType() {
		return DriverManager.browser;
	}

	/**
	 * Prints the env info.
	 */
	public static void printEnvInfo() {
		System.out.println("You have selected " + browser
				+ " as your browser. " + browser + " is being used.");
	}

	/**
	 * Launch browsern load url.
	 * 
	 * @param browser
	 *            the browser
	 * @param url
	 *            the url
	 * @throws Exception
	 *             the exception
	 */
	public void launchBrowsernLoadURL(String browser, String url)
			throws Exception {
		launchBrowser(browser);
		loadURL(url);
	}

	/**
	 * Load url.
	 * 
	 * @param url
	 *            the url
	 * @throws Exception
	 *             the exception
	 */
	public void loadURL(String url) throws Exception {
		driver.get(url);
		driver.manage().window().maximize();
	}

	/**
	 * Quit browser.
	 * 
	 * @return the string
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public String quitBrowser() throws FileNotFoundException, IOException {
		log.debug("Closing the browser");
		try {
			driver.quit();
			driver.close();
		} catch (Exception e) {
			return PropertyReader.getProperty("KEYWORD_FAIL")
					+ "Unable to close browser. Check if its open"
					+ e.getMessage();
		}
		return PropertyReader.getProperty("KEYWORD_PASS");

	}

	/**
	 * Close browser.
	 */
	public void closeBrowser() {
		System.out.println("Closing the browser");
		driver.close();
	}

}