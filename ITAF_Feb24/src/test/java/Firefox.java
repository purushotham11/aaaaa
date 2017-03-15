import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\PrimeO_Project\\ITAF_Feb24\\src\\test\\resources\\Drivers\\Gecko\\geckodriver.exe");
		File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		//FirefoxProfile firefoxProfile = new FirefoxProfile();       
		// driver = new FirefoxDriver(ffBinary,firefoxProfile);
		// driver = new FirefoxDriver(cap1);
		 driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		driver.quit();

	}

}
