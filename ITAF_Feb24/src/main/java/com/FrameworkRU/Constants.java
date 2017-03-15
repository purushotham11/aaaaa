package com.FrameworkRU;

import java.io.File;

/**
 * The Class Constants.
 *
 * @author Kiran Kumar Cherukuri
 */

public class Constants 
{		
	//=====================For Mobile==========================
	public static final String APK_INSTALL_FILE = "apkInstall.bat";
	public static final String APK_UNINSTALL_FILE = "apkUninstall.bat";
	public static final String IPAs_INSTALL_FILE="ontrack-2.3.6.1.ipa";
	public static final String APK_FILE="OnTrack-2.3.5.2.apk";
	public static final String APK_PACKAGE = "com.hilti.mobile.ontrack";
	
	public static final String APKs_DRIVER_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"APKs"+File.separator;
	public static final String IPAs_DRIVER_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"IPAs"+File.separator;
	public static final String ENVIRONMENT_PROPERTIES_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Properties"+File.separator+"Environments"+File.separator;
	
	public static final String WIN_APPIUM_DIR = "C:/Program Files (x86)"; 
	public static final String WIN_DRIVER_EXECUTABLE = WIN_APPIUM_DIR + File.separator + "Appium"+ File.separator + "node.exe" ;
	public static final String WIN_APPIUM_JS_FILE= WIN_APPIUM_DIR + File.separator + "Appium" + File.separator + "node_modules" + File.separator + "appium" + File.separator + "bin" + File.separator + "appium.js";
 
	public static final String MAC_APPIUM_NODE = "/Applications/Appium.app/Contents/Resources/node/bin/node";
	public static final String MAC_APPIUM_JS = "/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js";

	public static final String WIN_OBJECT_REPO_FILE_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ObjectRepo"+File.separator+"AndroidAndATIDOR"+File.separator;	
	public static final String MAC_OBJECT_REPO_FILE_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ObjectRepo"+File.separator+"IOSOR"+File.separator;	
	public static final String WEB_OBJECT_REPO_FILE_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ObjectRepo"+File.separator+"WebOR"+File.separator;	

	public static final String EXCEL_REPORT_FILE_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestSuites";
	public static final String CHROME_DRIVER_EXE_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Drivers"+File.separator+"chrome"+File.separator+"chromedriver_win32"+File.separator+"chromedriver.exe";
	
	public static final String MOBILE_TESTSUITE_FILE_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestSuites"+File.separator+"MobileSuiteRunner.xls";
	
	//=====================For Web==========================
	//Test Suite File Path
	public static final String TESTSUITE_FILE_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestSuites"+File.separator+"WebSuiteRunner.xls";
	public static final String TESTSUITE_FILE_SHEETNAME = "TestSuites";
	public static final String SCREENSHOT_FOLDER_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestResults"+File.separator+"Screenshots";
	public static final String REPORT_FOLDER_PATH = System.getProperty("user.dir")+File.separator+"Reports";
	public static final String ENVIRONMENTS_CONFIG_FILE_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Properties"+File.separator+"Environments"+File.separator;
	public static final String TESTDATA_CONFIG_FILE_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"Properties"+File.separator+"TestData";
	
	public static final String REPORT_DOWNLOAD_LOCATION = "C:\\ReportDownloads";
	
	//Reports file path
	public static final String REPORTS_FILE_PATH = System.getProperty("user.dir")+File.separator+"Reports"+File.separator+"PrimeO_Web_Automation_Reports.html";
	//Attachments file path
	public static final String ATTACHMENTS_FILE_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"Attachments"+File.separator;
	
	
	//EMPLOYEE
	public static final String EMPLOYEES_VALID_FILE = "EMPLOYEE_TEMPLATE_Valid.xlsx";
	public static final String EMPLOYEES_INVALID_FILE = "EMPLOYEE_TEMPLATE_Invalid.xlsx";
	public static final String EMPLOYEES_ERROR_MESSAGES_FILE = "EMPLOYE_ErrorMessagesData.xlsx";
	public static final String EMPLOYEE_SHEET = "EMPLOYEE";
	public static final String EMPLOYEE_ERRORMESSAGES_SHEET = "English";
	public static final String DATAFILE_EMPLOYEES_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"EMPLOYEES"+File.separator;
	
	//EMPLOYEE EXCEL FILE COLUMNS
	public static final String EMPLOYEE_COLUMN_LOGINNAME = "LOGIN NAME";
	public static final String EMPLOYEE_COLUMN_FIRSTNAME = "FIRST NAME";
	public static final String EMPLOYEE_COLUMN_LASTNAME = "LAST NAME";
	public static final String EMPLOYEE_COLUMN_BADGEID = "BADGE ID";
	public static final String EMPLOYEE_COLUMN_EMAILID = "EMAIL ID";
	public static final String EMPLOYEE_COLUMN_EMPLOYEEASLOCATION = "EMPLOYEE AS LOCATION";
	public static final String EMPLOYEE_ERRORMESSAGES_FILE_COLUMN = "Error Message";	
	
	
	//FLEET COMMODITY
	public static final String FLEET_COMMODITY_VALID_FILE = "FLEETCOMMODITY_Valid.xlsx";
	public static final String FLEET_COMMODITY_INVALID_FILE = "FLEETCOMMODITY_InValid.xlsx";
	public static final String FLEET_COMMODITY_ERROR_MESSAGES_FILE = "FLEETCOMMODITY_ErrorMessagesData.xlsx";
	public static final String FLEET_COMMODITY_SHEET = "FLEET COMMODITY";
	public static final String FLEET_COMMODITY_ERRORMESSAGES_SHEET = "English";
	public static final String DATAFILE_FLEET_COMMODITY_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"COMMODITY"+File.separator;
	public static final String FLEET_COMMODITY_ERRORMESSAGES_FILE_COLUMN = "Error Message";	
	
	//LOANED COMMODITY
	public static final String LOANED_COMMODITY_VALID_FILE = "LOANEDCOMMODITY_Valid.xlsx";
	public static final String LOANED_COMMODITY_INVALID_FILE = "LOANEDCOMMODITY_InValid.xlsx";
	public static final String LOANED_COMMODITY_ERROR_MESSAGES_FILE = "LOANEDCOMMODITY_ErrorMessagesData.xlsx";
	public static final String LOANED_COMMODITY_SHEET = "LOANED COMMODITY";
	public static final String LOANED_COMMODITY_ERRORMESSAGES_SHEET = "English";
	public static final String DATAFILE_LOANED_COMMODITY_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"COMMODITY"+File.separator;
	public static final String LOANED_COMMODITY_ERRORMESSAGES_FILE_COLUMN = "Error Message";	
	
	//ASSET & COMMODITY EXCEL FILE COLUMNS
	public static final String ASSET_COLUMN_SCANCODE = "SCAN CODE";
	public static final String ASSET_COLUMN_ALTERNATECODE = "ALTERNATE CODE";
	public static final String ASSET_COLUMN_QUANTITY = "QUANTITY";
	public static final String ASSET_COLUMN_DEFAULTLOCATION = "DEFAULT LOCATION";
	public static final String ASSET_COLUMN_CURRENTLOCATION = "CURRENT LOCATION";
	public static final String ASSET_COLUMN_DEFAULTGROUP = "DEFAULT GROUP";
	public static final String ASSET_COLUMN_SERIALNUMBER = "SERIAL NO";
	public static final String ASSET_COLUMN_MODEL = "MODEL";
	public static final String ASSET_COLUMN_MANUFACTURER = "MANUFACTURER";
	public static final String ASSET_COLUMN_OWNER = "OWNER";
	public static final String ASSET_HILTITOOL_COLUMN_ASSETGROUP = "ASSET GROUP";
	
	
	//OWNED COMMODITY
	public static final String DATAFILE_OWNED_COMMODITY_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"COMMODITY"+File.separator;
	public static final String OWNED_COMMODITY_VALID_FILE = "OWNEDCOMMODITY_Valid.xlsx";
	public static final String OWNED_COMMODITY_SHEET = "OWNED COMMODITY";
	public static final String OWNED_COMMODITY_INVALID_FILE="OWNEDCOMMODITY_Invalid.xlsx";
	public static final String OWNED_COMMODITY_ERROR_MESSAGES_FILE="OWNEDCOMMODITY_ErrorMessagesData.xlsx";
	public static final String OWNED_COMMODITY_ERRORMESSAGES_SHEET="English";
	public static final String OWNED_COMMODITY_ERRORMESSAGES_FILE_COLUMN="Error Message";
	
	//RENTED COMMODITY
	public static final String DATAFILE_RENTED_COMMODITY_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"COMMODITY"+File.separator;
	public static final String RENTED_COMMODITY_VALID_FILE = "RENTEDCOMMODITY_Valid.xlsx";
	public static final String RENTED_COMMODITY_SHEET = "RENTED COMMODITY";
	public static final String RENTED_COMMODITY_INVALID_FILE="RENTEDCOMMODITY_Invalid.xlsx";
	public static final String RENTED_COMMODITY_ERROR_MESSAGES_FILE="RENTEDCOMMODITY_ErrorMessagesData.xlsx";
	public static final String RENTED_COMMODITY_ERRORMESSAGES_SHEET="English";
	public static final String RENTED_COMMODITY_ERRORMESSAGES_FILE_COLUMN="Error Message";
	
	//LOCATIONS
	public static final String LOCATIONS_VALID_FILE="LOCATION_Valid.xlsx";
	public static final String LOCATIONS_INVALID_FILE="LOCATION_InValid.xlsx";
	public static final String LOCATIONS_ERROR_MESSAGES_PATH="LOCATION_ErrorMessagesData.xlsx";
	public static final String LOCATION_SHEET="LOCATION";
	public static final String LOCATION_ERRORMESSAGES_SHEET="English";
	public static final String DATAFILE_LOCATIONS_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"LOCATIONS"+File.separator;
	public static final String LOCATIONS_ERRORMESSAGES_FILE_COLUMN="Error Message";
	
	//HILTI TOOLS ASSET DATA
	public static final String HILTITOOLS_PRODUCT_MASTER_XML_FILE="productmaster.xml";
	public static final String HILTITOOLS_ASSETS_XML_FILE="assets.xml";
	public static final String HILTITOOLS_ASSETDATA_VALID_FILE="HILTITOOLS_ASSETS_Valid.xlsx";
	public static final String HILTITOOLS_ASSETDATA_INVALID_FILE="HILTITOOLS_ASSETS_InValid.xlsx";
	public static final String HILTITOOLS_ERROR_MESSAGES_FILE="HILTITOOLS_ErrorMessagesData.xlsx";
	public static final String HILTITOOLS_ASSETDATA_SHEET="UNREGISTER ASSET";
	public static final String HILTITOOLS_XML_FILES_PATH="SAPXMLS"+File.separator;
	public static final String HILTITOOLS_ERRORMESSAGES_SHEET="English";
	public static final String HILTITOOLS_DATA_FILES_PATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"HILTI_TOOLS"+File.separator+"EXCELFILES"+File.separator;
	public static final String HILTITOOLS_ASSETDATA_ERRORMESSAGES_FILE_COLUMN="Error Message";
	public static final String HILTITOOLS_ASSETDATA_SAPXMLS_FILEPATH=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"HILTI_TOOLS"+File.separator+"SAPXMLS"+File.separator;
	

	
	//RENTED ASSET
	public static final String DATAFILE_RENTED_ASSET_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"UNIQUEASSETS"+File.separator;
	public static final String RENTED_ASSET_VALID_FILE = "RENTEDASSET_Valid.xlsx";
	public static final String RENTED_ASSET_SHEET = "RENTED ASSET";
	public static final String RENTED_ASSET_INVALID_FILE="RENTEDASSET_Invalid.xlsx";
	public static final String RENTED_ASSET_ERROR_MESSAGES_FILE="RENTEDASSET_ErrorMessagesData.xlsx";
	public static final String RENTED_ASSET_ERRORMESSAGES_SHEET="English";
	public static final String RENTED_ASSET_ERRORMESSAGES_FILE_COLUMN="Error Message";
	
	//FLEET COMMODITY
	public static final String FLEET_ASSET_VALID_FILE = "FLEETASSET_Valid.xlsx";
	public static final String FLEET_ASSET_INVALID_FILE = "FLEETASSET_InValid.xlsx";
	public static final String FLEET_ASSET_ERROR_MESSAGES_FILE = "FLEETASSET_ErrorMessagesData.xlsx";
	public static final String FLEET_ASSET_SHEET = "FLEET ASSET";
	public static final String FLEET_ASSET_ERRORMESSAGES_SHEET = "English";
	public static final String DATAFILE_FLEET_ASSET_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"UNIQUEASSETS"+File.separator;
	public static final String FLEET_ASSET_ERRORMESSAGES_FILE_COLUMN = "Error Message";
	
	//FLEET COMMODITY
	public static final String LOANED_ASSET_VALID_FILE = "LOANEDASSET_Valid.xlsx";
	public static final String LOANED_ASSET_INVALID_FILE = "LOANEDASSET_InValid.xlsx";
	public static final String LOANED_ASSET_ERROR_MESSAGES_FILE = "LOANEDASSET_ErrorMessagesData.xlsx";
	public static final String LOANED_ASSET_SHEET = "LOANED ASSET";
	public static final String LOANED_ASSET_ERRORMESSAGES_SHEET = "English";
	public static final String DATAFILE_LOANED_ASSET_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"UNIQUEASSETS"+File.separator;
	public static final String LOANED_ASSET_ERRORMESSAGES_FILE_COLUMN = "Error Message";
	
	//FLEET COMMODITY
	public static final String OWNED_ASSET_VALID_FILE = "OWNEDASSET_Valid.xlsx";
	public static final String OWNED_ASSET_INVALID_FILE = "OWNEDASSET_InValid.xlsx";
	public static final String OWNED_ASSET_ERROR_MESSAGES_FILE = "OWNEDASSET_ErrorMessagesData.xlsx";
	public static final String OWNED_ASSET_SHEET = "OWNED ASSET";
	public static final String OWNED_ASSET_ERRORMESSAGES_SHEET = "English";
	public static final String DATAFILE_OWNED_ASSET_PATH = System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"+File.separator+"resources"+File.separator+"ExcelTestDataFiles"+File.separator+"UNIQUEASSETS"+File.separator;
	public static final String OWNED_ASSET_ERRORMESSAGES_FILE_COLUMN = "Error Message";
	
	//TPAAS DATA
	public static final String EMPLOYEE_ROLE_ADMIN = "admin";
	public static final String EMPLOYEE_ROLE_EVERYONE = "everyone";
	public static final String EMPLOYEE_DASHBOARD_COLUMN_USERNAME = "Username";
	public static final String EMPLOYEE_DASHBOARD_COLUMN_NAME = "Name";
	public static final String EMPLOYEE_DASHBOARD_COLUMN_EMAIL = "Email";
	public static final String EMPLOYEE_DASHBOARD_COLUMN_APP_ACCESS = "App Access";
	
	
}
