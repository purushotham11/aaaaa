package com.FrameworkRU;

import org.openqa.selenium.WebDriver;

import com.Driver.DriverManager;
import com.ExcelUtilities.ExcelUtils;
/*import com.web.modules.ASSETS.AssetsPage;
import com.web.modules.ASSETS.AssetsPageRU;
import com.web.modules.EMPLOYEES.EmployeesPage;
import com.web.modules.LOCATIONS.LocationsPage;
import com.web.modules.LOCATIONS.LocationsPageRU;*/
import com.web.modules.LOGIN.LoginPage;
import com.web.modules.LOGOUT.LogoutPage;

/**
 * The Class CleanupTestData.
 * 
 * @author Kiran Kumar Cherukuri
 */
public class CleanupTestData {

	private static ExcelUtils excelUploadObject;
	WebDriver driver;
	ConfigTestFixtures configTestFixtures;
	private DriverManager driverManager;
	private LoginPage loginPage;
	/*private EmployeesPage employeesPage;
	LocationsPageRU locationsPageRU;*/
	PageAction pageAction;
	SendEmail sendEmail;
	/*AssetsPage assetsPage;
	AssetsPageRU assetsPageRU;
*/
	/**
	 * Clean up test data for import and export settings.
	 * 
	 * @param browser
	 *            the browser
	 * @param env
	 *            the env
	 * @throws Exception
	 *             the exception
	 */
	public void cleanUpTestDataForImportAndExportSettings(String browser,
			String env) throws Exception {
		driverManager = new DriverManager();
		driverManager.launchBrowser(browser);
		driver = driverManager.getDriver();
		configTestFixtures = new ConfigTestFixtures();
		loginPage = new LoginPage(driver);
		new LogoutPage(driver);
		new CaptureScreenshot(driver);
		
		pageAction = new PageAction(driver);
		configTestFixtures.generateConfigTestData(env);
		System.out.println();
		System.out.println("............Cleaning up of earlier Test Run Data Started........");
		System.out.println();
		FileUtils.deleteFile(Constants.SCREENSHOT_FOLDER_PATH);
		FileUtils.deleteFile(Constants.REPORT_FOLDER_PATH);
		driverManager.loadURL(ConfigTestFixtures.getWebAppUrl());
		loginPage
				.portalSignIn(
						PropertyReader
								.getRuntimeTestData("Excel_Common_EmployeeUsername"),
						PropertyReader
								.getRuntimeTestData("Excel_Common_EmployeeUserPassword"),PropertyReader
								.getRuntimeTestData("Excel_Common_EmployeeDealerId"));
		
		excelUploadObject = new ExcelUtils(Constants.DATAFILE_EMPLOYEES_PATH
				+ Constants.EMPLOYEES_INVALID_FILE);
		

		excelUploadObject = new ExcelUtils(Constants.DATAFILE_EMPLOYEES_PATH
				+ Constants.EMPLOYEES_VALID_FILE);
		/*employeesPage.deleteEmployeeWithBadgeID(excelUploadObject,
				Constants.EMPLOYEE_SHEET);*/

		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_FLEET_COMMODITY_PATH
						+ Constants.FLEET_COMMODITY_VALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.FLEET_COMMODITY_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);
*/
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_FLEET_COMMODITY_PATH
						+ Constants.FLEET_COMMODITY_INVALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.FLEET_COMMODITY_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/

		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_OWNED_COMMODITY_PATH
						+ Constants.OWNED_COMMODITY_VALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.OWNED_COMMODITY_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_OWNED_COMMODITY_PATH
						+ Constants.OWNED_COMMODITY_INVALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.OWNED_COMMODITY_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/

		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_RENTED_COMMODITY_PATH
						+ Constants.RENTED_COMMODITY_VALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.RENTED_COMMODITY_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/
		
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_RENTED_COMMODITY_PATH
						+ Constants.RENTED_COMMODITY_INVALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.RENTED_COMMODITY_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);
		*/
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_LOANED_COMMODITY_PATH
						+ Constants.LOANED_COMMODITY_VALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.LOANED_COMMODITY_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/
		
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_LOANED_COMMODITY_PATH
						+ Constants.LOANED_COMMODITY_INVALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.LOANED_COMMODITY_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);
		*/
		excelUploadObject = new ExcelUtils(Constants.DATAFILE_LOCATIONS_PATH
				+ Constants.LOCATIONS_VALID_FILE);
		/*locationsPageRU.deleteLocationsWithLocationName(excelUploadObject,
				Constants.LOCATION_SHEET);
*/
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_RENTED_ASSET_PATH
						+ Constants.RENTED_ASSET_VALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.RENTED_ASSET_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);
		*/
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_FLEET_ASSET_PATH
						+ Constants.FLEET_ASSET_VALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.FLEET_ASSET_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/
		
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_LOANED_ASSET_PATH
						+ Constants.LOANED_ASSET_VALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.LOANED_ASSET_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/
		
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_OWNED_ASSET_PATH
						+ Constants.OWNED_ASSET_VALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.OWNED_ASSET_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);
		*/
		excelUploadObject = new ExcelUtils(
				Constants.HILTITOOLS_DATA_FILES_PATH
						+ Constants.HILTITOOLS_ASSETDATA_VALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.HILTITOOLS_ASSETDATA_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/
		
		excelUploadObject = new ExcelUtils(
				Constants.HILTITOOLS_DATA_FILES_PATH
						+ Constants.HILTITOOLS_ASSETDATA_INVALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.HILTITOOLS_ASSETDATA_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);		*/
		
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_FLEET_ASSET_PATH
						+ Constants.FLEET_ASSET_INVALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.FLEET_ASSET_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/
		
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_RENTED_ASSET_PATH
						+ Constants.RENTED_ASSET_INVALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.RENTED_ASSET_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/
		
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_LOANED_ASSET_PATH
						+ Constants.LOANED_ASSET_INVALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.LOANED_ASSET_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/
		
		excelUploadObject = new ExcelUtils(
				Constants.DATAFILE_OWNED_ASSET_PATH
						+ Constants.OWNED_ASSET_INVALID_FILE);
		/*assetsPageRU.deleteAssetBy(excelUploadObject,
				Constants.OWNED_ASSET_SHEET,
				Constants.ASSET_COLUMN_SCANCODE);*/
		System.out.println();
		System.out.println(".........Cleaning up of earlier Test Run Data Completed......!!!");
		System.out.println();
		driverManager.closeBrowser();
	}
}
