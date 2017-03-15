package com.FrameworkRU;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.FrameworkRU.ConfigTestFixtures;
import com.FrameworkRU.PropertyReader;

/**
 * The Class ConfigTestFixtures.
 * 
 * @author Praveen Gaddam
 */
public class ConfigTestFixtures {
	
	//For Mobile
	public static String Environment;
	private static String adminAppUrl;
	private static String emailId3;
	private static String emailpwd3;
	private static String emailId2;
	private static String emailpwd2;
	private static String emailId1;
	private static String emailpwd1;
	private static String innomindsEmailHost;
	private static String innomindsEmailPort;
	private static String innomindsEmailId;
	private static String innomindsEmailPassword;
	private static String trimbleEmailHost;
	private static String trimbleEmailPort;
	private static String trimbleEmailId;
	private static String trimbleEmailPassword;
	private static String loginUsername;
	private static String loginPassword;
	private static String trimbleSendEmailHost;
	private static String innomindsSendEmailHost;
	private static String gmailSendEmailHost;
	private static String sendEmailFrom;
	private static String sendEmailPwd;
	private static String sendEmailTo;
	private static String sendEmailPort;
	private static String sapXmlPayloadUrl;
	private static String country;
	private static String language;
	private static String emailId4;
	private static String emailpwd4;
	private static String exceluploadEmailId;
	private static String exceluploadEmailPwd;
	private static String adminAppUsername;
	private static String adminAppPassword;
	
	private static String deviceName;
	private static String platformName;
	private static String platform;
	private static String platformVersion;
	private static String bundleId;
	private static String udid;
	private static String appiumServerUrl;
	private static String objectRepoFile;
	private static String appPackage;
	private static String appActivity;
	private static String userName;
	private static String passWord;
	private static String userFullName;
	private static String defaultLocation;
	private static String defaultLanguage;

	// For Web Application
	private static String webUsername;
	private static String webPassword;
	private static String webAppUrl;

	private static String gmailEmailHost;
	private static String uploadEmailId;
	private static String uploadEmailPwd;

	private static String deviceModel;
	
	public static String getDeviceModel() {
		return deviceModel;
	}

	public static void setDeviceModel(String deviceModel) {
		ConfigTestFixtures.deviceModel = deviceModel;
	}

	public static String getDeviceManufacturer() {
		return deviceManufacturer;
	}

	public static void setDeviceManufacturer(String deviceManufacturer) {
		ConfigTestFixtures.deviceManufacturer = deviceManufacturer;
	}

	private static String deviceManufacturer;

	public static String getWebUsername() {
		return webUsername;
	}

	public static void setWebUsername(String webUsername) {
		ConfigTestFixtures.webUsername = webUsername;
	}

	public static String getWebPassword() {
		return webPassword;
	}

	public static void setWebPassword(String webPassword) {
		ConfigTestFixtures.webPassword = webPassword;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		ConfigTestFixtures.userName = userName;
	}

	public static String getPassWord() {
		return passWord;
	}

	public static void setPassWord(String passWord) {
		ConfigTestFixtures.passWord = passWord;
	}

	public static String getUserFullName() {
		return userFullName;
	}

	public static void setUserFullName(String userFullName) {
		ConfigTestFixtures.userFullName = userFullName;
	}

	public static String getDefaultLocation() {
		return defaultLocation;
	}

	public static void setDefaultLocation(String defaultLocation) {
		ConfigTestFixtures.defaultLocation = defaultLocation;
	}

	public static String getDefaultLanguage() {
		return defaultLanguage;
	}

	public static void setDefaultLanguage(String defaultLanguage) {
		ConfigTestFixtures.defaultLanguage = defaultLanguage;
	}

	public static String getDeviceName() {
		return deviceName;
	}

	public static void setDeviceName(String deviceName) {
		ConfigTestFixtures.deviceName = deviceName;
	}

	public static String getPlatformName() {
		return platformName;
	}

	public static void setPlatformName(String platformName) {
		ConfigTestFixtures.platformName = platformName;
	}

	public static String getPlatform() {
		return platform;
	}

	public static void setPlatform(String platform) {
		ConfigTestFixtures.platform = platform;
	}

	public static String getPlatformVersion() {
		return platformVersion;
	}

	public static void setPlatformVersion(String platformVersion) {
		ConfigTestFixtures.platformVersion = platformVersion;
	}

	public static String getBundleId() {
		return bundleId;
	}

	public static void setBundleId(String bundleId) {
		ConfigTestFixtures.bundleId = bundleId;
	}

	public static String getUdid() {
		return udid;
	}

	public static void setUdid(String udid) {
		ConfigTestFixtures.udid = udid;
	}

	public static String getAppiumServerUrl() {
		return appiumServerUrl;
	}

	public static void setAppiumServerUrl(String appiumServerUrl) {
		ConfigTestFixtures.appiumServerUrl = appiumServerUrl;
	}

	public static String getObjectRepoFile() {
		return objectRepoFile;
	}

	public static void setObjectRepoFile(String objectRepoFile) {
		ConfigTestFixtures.objectRepoFile = objectRepoFile;
	}

	public static String getAppPackage() {
		return appPackage;
	}

	public static void setAppPackage(String appPackage) {
		ConfigTestFixtures.appPackage = appPackage;
	}

	public static String getAppActivity() {
		return appActivity;
	}

	public static void setAppActivity(String appActivity) {
		ConfigTestFixtures.appActivity = appActivity;
	}


	/**
	 * Gets the excelupload email id.
	 * 
	 * @return the excelupload email id
	 */
	public static String getExceluploadEmailId() {
		return exceluploadEmailId;
	}

	/**
	 * Sets the excelupload email id.
	 * 
	 * @param exceluploadEmailId
	 *            the new excelupload email id
	 */
	public static void setExceluploadEmailId(String exceluploadEmailId) {
		ConfigTestFixtures.exceluploadEmailId = exceluploadEmailId;
	}

	/**
	 * Gets the excelupload email pwd.
	 * 
	 * @return the excelupload email pwd
	 */
	public static String getExceluploadEmailPwd() {
		return exceluploadEmailPwd;
	}

	/**
	 * Sets the excelupload email pwd.
	 * 
	 * @param exceluploadEmailPwd
	 *            the new excelupload email pwd
	 */
	public static void setExceluploadEmailPwd(String exceluploadEmailPwd) {
		ConfigTestFixtures.exceluploadEmailPwd = exceluploadEmailPwd;
	}

	/**
	 * Gets the email id 4.
	 * 
	 * @return the email id 4
	 */
	public static String getEmailId4() {
		return emailId4;
	}

	/**
	 * Sets the email id 4.
	 * 
	 * @param emailId4
	 *            the new email id 4
	 */
	public static void setEmailId4(String emailId4) {
		ConfigTestFixtures.emailId4 = emailId4;
	}

	/**
	 * Gets the emailpwd 4.
	 * 
	 * @return the emailpwd 4
	 */
	public static String getEmailpwd4() {
		return emailpwd4;
	}

	/**
	 * Sets the emailpwd 4.
	 * 
	 * @param emailpwd4
	 *            the new emailpwd 4
	 */
	public static void setEmailpwd4(String emailpwd4) {
		ConfigTestFixtures.emailpwd4 = emailpwd4;
	}

	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public static String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 * 
	 * @param country
	 *            the new country
	 */
	public static void setCountry(String country) {
		ConfigTestFixtures.country = country;
	}

	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public static String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 * 
	 * @param language
	 *            the new language
	 */
	public static void setLanguage(String language) {
		ConfigTestFixtures.language = language;
	}

	/**
	 * Gets the sap xml payload url.
	 * 
	 * @return the sap xml payload url
	 */
	public static String getSapXmlPayloadUrl() {
		return sapXmlPayloadUrl;
	}

	/**
	 * Sets the sap xml payload url.
	 * 
	 * @param sapXmlPayloadUrl
	 *            the new sap xml payload url
	 */
	public static void setSapXmlPayloadUrl(String sapXmlPayloadUrl) {
		ConfigTestFixtures.sapXmlPayloadUrl = sapXmlPayloadUrl;
	}

	/**
	 * Gets the sap xml payload username.
	 * 
	 * @return the sap xml payload username
	 */
	public static String getSapXmlPayloadUsername() {
		return sapXmlPayloadUsername;
	}

	/**
	 * Sets the sap xml payload username.
	 * 
	 * @param sapXmlPayloadUsername
	 *            the new sap xml payload username
	 */
	public static void setSapXmlPayloadUsername(String sapXmlPayloadUsername) {
		ConfigTestFixtures.sapXmlPayloadUsername = sapXmlPayloadUsername;
	}

	/**
	 * Gets the sap xml payload password.
	 * 
	 * @return the sap xml payload password
	 */
	public static String getSapXmlPayloadPassword() {
		return sapXmlPayloadPassword;
	}

	/**
	 * Sets the sap xml payload password.
	 * 
	 * @param sapXmlPayloadPassword
	 *            the new sap xml payload password
	 */
	public static void setSapXmlPayloadPassword(String sapXmlPayloadPassword) {
		ConfigTestFixtures.sapXmlPayloadPassword = sapXmlPayloadPassword;
	}

	private static String sapXmlPayloadUsername;
	private static String sapXmlPayloadPassword;

	/**
	 * Gets the send email port.
	 * 
	 * @return the send email port
	 */
	public static String getSendEmailPort() {
		return sendEmailPort;
	}

	/**
	 * Sets the send email port.
	 * 
	 * @param sendEmailPort
	 *            the new send email port
	 */
	public static void setSendEmailPort(String sendEmailPort) {
		ConfigTestFixtures.sendEmailPort = sendEmailPort;
	}

	/**
	 * Gets the trimble send email host.
	 * 
	 * @return the trimble send email host
	 */
	public static String getTrimbleSendEmailHost() {
		return trimbleSendEmailHost;
	}

	/**
	 * Sets the trimble send email host.
	 * 
	 * @param trimbleSendEmailHost
	 *            the new trimble send email host
	 */
	public static void setTrimbleSendEmailHost(String trimbleSendEmailHost) {
		ConfigTestFixtures.trimbleSendEmailHost = trimbleSendEmailHost;
	}

	/**
	 * Gets the innominds send email host.
	 * 
	 * @return the innominds send email host
	 */
	public static String getInnomindsSendEmailHost() {
		return innomindsSendEmailHost;
	}

	/**
	 * Sets the innominds send email host.
	 * 
	 * @param innomindsSendEmailHost
	 *            the new innominds send email host
	 */
	public static void setInnomindsSendEmailHost(String innomindsSendEmailHost) {
		ConfigTestFixtures.innomindsSendEmailHost = innomindsSendEmailHost;
	}

	/**
	 * Gets the gmail send email host.
	 * 
	 * @return the gmail send email host
	 */
	public static String getGmailSendEmailHost() {
		return gmailSendEmailHost;
	}

	/**
	 * Sets the gmail send email host.
	 * 
	 * @param gmailSendEmailHost
	 *            the new gmail send email host
	 */
	public static void setGmailSendEmailHost(String gmailSendEmailHost) {
		ConfigTestFixtures.gmailSendEmailHost = gmailSendEmailHost;
	}

	/**
	 * Gets the send email from.
	 * 
	 * @return the send email from
	 */
	public static String getSendEmailFrom() {
		return sendEmailFrom;
	}

	/**
	 * Sets the send email from.
	 * 
	 * @param sendEmailFrom
	 *            the new send email from
	 */
	public static void setSendEmailFrom(String sendEmailFrom) {
		ConfigTestFixtures.sendEmailFrom = sendEmailFrom;
	}

	/**
	 * Gets the send email pwd.
	 * 
	 * @return the send email pwd
	 */
	public static String getSendEmailPwd() {
		return sendEmailPwd;
	}

	/**
	 * Sets the send email pwd.
	 * 
	 * @param sendEmailPwd
	 *            the new send email pwd
	 */
	public static void setSendEmailPwd(String sendEmailPwd) {
		ConfigTestFixtures.sendEmailPwd = sendEmailPwd;
	}

	/**
	 * Gets the send email to.
	 * 
	 * @return the send email to
	 */
	public static String getSendEmailTo() {
		return sendEmailTo;
	}

	/**
	 * Sets the send email to.
	 * 
	 * @param sendEmailTo
	 *            the new send email to
	 */
	public static void setSendEmailTo(String sendEmailTo) {
		ConfigTestFixtures.sendEmailTo = sendEmailTo;
	}

	/**
	 * Gets the upload email id.
	 * 
	 * @return the upload email id
	 */
	public static String getUploadEmailId() {
		return uploadEmailId;
	}

	/**
	 * Sets the upload email id.
	 * 
	 * @param uploadEmailId
	 *            the new upload email id
	 */
	public static void setUploadEmailId(String uploadEmailId) {
		ConfigTestFixtures.uploadEmailId = uploadEmailId;
	}

	/**
	 * Gets the upload email pwd.
	 * 
	 * @return the upload email pwd
	 */
	public static String getUploadEmailPwd() {
		return uploadEmailPwd;
	}

	/**
	 * Sets the upload email pwd.
	 * 
	 * @param uploadEmailPwd
	 *            the new upload email pwd
	 */
	public static void setUploadEmailPwd(String uploadEmailPwd) {
		ConfigTestFixtures.uploadEmailPwd = uploadEmailPwd;
	}

	/**
	 * Gets the environment.
	 * 
	 * @return the environment
	 */
	public static String getEnvironment() {
		return Environment;
	}

	/**
	 * Sets the environment.
	 * 
	 * @param environment
	 *            the new environment
	 */
	public static void setEnvironment(String environment) {
		Environment = environment;
	}

	/**
	 * Gets the admin app url.
	 * 
	 * @return the admin app url
	 */
	public static String getAdminAppUrl() {
		return adminAppUrl;
	}

	/**
	 * Sets the admin app url.
	 * 
	 * @param adminAppUrl
	 *            the new admin app url
	 */
	public static void setAdminAppUrl(String adminAppUrl) {
		ConfigTestFixtures.adminAppUrl = adminAppUrl;
	}

	/**
	 * Gets the login username.
	 * 
	 * @return the login username
	 */
	public static String getLoginUsername() {
		return loginUsername;
	}

	/**
	 * Sets the login username.
	 * 
	 * @param loginUsername
	 *            the new login username
	 */
	public static void setLoginUsername(String loginUsername) {
		ConfigTestFixtures.loginUsername = loginUsername;
	}

	/**
	 * Gets the web app url.
	 * 
	 * @return the web app url
	 */
	public static String getWebAppUrl() {
		return webAppUrl;
	}

	/**
	 * Sets the web app url.
	 * 
	 * @param webAppUrl
	 *            the new web app url
	 */
	public static void setWebAppUrl(String webAppUrl) {
		ConfigTestFixtures.webAppUrl = webAppUrl;
	}

	/**
	 * Gets the admin app username.
	 * 
	 * @return the admin app username
	 */
	public static String getAdminAppUsername() {
		return adminAppUsername;
	}

	/**
	 * Sets the admin app username.
	 * 
	 * @param adminAppUsername
	 *            the new admin app username
	 */
	public static void setAdminAppUsername(String adminAppUsername) {
		ConfigTestFixtures.adminAppUsername = adminAppUsername;
	}

	/**
	 * Gets the admin app password.
	 * 
	 * @return the admin app password
	 */
	public static String getAdminAppPassword() {
		return adminAppPassword;
	}

	/**
	 * Sets the admin app password.
	 * 
	 * @param adminAppPassword
	 *            the new admin app password
	 */
	public static void setAdminAppPassword(String adminAppPassword) {
		ConfigTestFixtures.adminAppPassword = adminAppPassword;
	}

	/**
	 * Gets the login password.
	 * 
	 * @return the login password
	 */
	public static String getLoginPassword() {
		return loginPassword;
	}

	/**
	 * Sets the login password.
	 * 
	 * @param loginPassword
	 *            the new login password
	 */
	public static void setLoginPassword(String loginPassword) {
		ConfigTestFixtures.loginPassword = loginPassword;
	}

	/**
	 * Gets the email id3.
	 * 
	 * @return the email id3
	 */
	public static String getEmailId3() {
		return emailId3;
	}

	/**
	 * Sets the email id3.
	 * 
	 * @param emailId3
	 *            the new email id3
	 */
	public static void setEmailId3(String emailId3) {
		ConfigTestFixtures.emailId3 = emailId3;
	}

	/**
	 * Gets the emailpwd3.
	 * 
	 * @return the emailpwd3
	 */
	public static String getEmailpwd3() {
		return emailpwd3;
	}

	/**
	 * Sets the emailpwd3.
	 * 
	 * @param emailpwd3
	 *            the new emailpwd3
	 */
	public static void setEmailpwd3(String emailpwd3) {
		ConfigTestFixtures.emailpwd3 = emailpwd3;
	}

	/**
	 * Sets the web app url.
	 * 
	 * @return the email id 2
	 */

	/**
	 * Gets the email id2.
	 * 
	 * @return the email id2
	 */
	public static String getEmailId2() {
		return emailId2;
	}

	/**
	 * Sets the email id2.
	 * 
	 * @param emailId2
	 *            the new email id2
	 */
	public static void setEmailId2(String emailId2) {
		ConfigTestFixtures.emailId2 = emailId2;
	}

	/**
	 * Gets the emailpwd2.
	 * 
	 * @return the emailpwd2
	 */
	public static String getEmailpwd2() {
		return emailpwd2;
	}

	/**
	 * Sets the emailpwd2.
	 * 
	 * @param emailpwd2
	 *            the new emailpwd2
	 */
	public static void setEmailpwd2(String emailpwd2) {
		ConfigTestFixtures.emailpwd2 = emailpwd2;
	}

	/**
	 * Gets the email id1.
	 * 
	 * @return the email id1
	 */
	public static String getEmailId1() {
		return emailId1;
	}

	/**
	 * Sets the email id1.
	 * 
	 * @param emailId1
	 *            the new email id1
	 */
	public static void setEmailId1(String emailId1) {
		ConfigTestFixtures.emailId1 = emailId1;
	}

	/**
	 * Gets the emailpwd1.
	 * 
	 * @return the emailpwd1
	 */
	public static String getEmailpwd1() {
		return emailpwd1;
	}

	/**
	 * Sets the emailpwd1.
	 * 
	 * @param emailpwd1
	 *            the new emailpwd1
	 */
	public static void setEmailpwd1(String emailpwd1) {
		ConfigTestFixtures.emailpwd1 = emailpwd1;
	}

	/**
	 * Gets the innominds email host.
	 * 
	 * @return the innominds email host
	 */
	public static String getInnomindsEmailHost() {
		return innomindsEmailHost;
	}

	/**
	 * Sets the innominds email host.
	 * 
	 * @param innomindsEmailHost
	 *            the new innominds email host
	 */
	public static void setInnomindsEmailHost(String innomindsEmailHost) {
		ConfigTestFixtures.innomindsEmailHost = innomindsEmailHost;
	}

	/**
	 * Gets the innominds email port.
	 * 
	 * @return the innominds email port
	 */
	public static String getInnomindsEmailPort() {
		return innomindsEmailPort;
	}

	/**
	 * Sets the innominds email port.
	 * 
	 * @param innomindsEmailPort
	 *            the new innominds email port
	 */
	public static void setInnomindsEmailPort(String innomindsEmailPort) {
		ConfigTestFixtures.innomindsEmailPort = innomindsEmailPort;
	}

	/**
	 * Gets the innominds email id.
	 * 
	 * @return the innominds email id
	 */
	public static String getInnomindsEmailId() {
		return innomindsEmailId;
	}

	/**
	 * Sets the innominds email id.
	 * 
	 * @param innomindsEmailId
	 *            the new innominds email id
	 */
	public static void setInnomindsEmailId(String innomindsEmailId) {
		ConfigTestFixtures.innomindsEmailId = innomindsEmailId;
	}

	/**
	 * Gets the innominds email password.
	 * 
	 * @return the innominds email password
	 */
	public static String getInnomindsEmailPassword() {
		return innomindsEmailPassword;
	}

	/**
	 * Sets the innominds email password.
	 * 
	 * @param innomindsEmailPassword
	 *            the new innominds email password
	 */
	public static void setInnomindsEmailPassword(String innomindsEmailPassword) {
		ConfigTestFixtures.innomindsEmailPassword = innomindsEmailPassword;
	}

	/**
	 * Gets the trimble email host.
	 * 
	 * @return the trimble email host
	 */
	public static String getTrimbleEmailHost() {
		return trimbleEmailHost;
	}

	/**
	 * Sets the trimble email host.
	 * 
	 * @param trimbleEmailHost
	 *            the new trimble email host
	 */
	public static void setTrimbleEmailHost(String trimbleEmailHost) {
		ConfigTestFixtures.trimbleEmailHost = trimbleEmailHost;
	}

	/**
	 * Gets the trimble email port.
	 * 
	 * @return the trimble email port
	 */
	public static String getTrimbleEmailPort() {
		return trimbleEmailPort;
	}

	/**
	 * Sets the trimble email port.
	 * 
	 * @param trimbleEmailPort
	 *            the new trimble email port
	 */
	public static void setTrimbleEmailPort(String trimbleEmailPort) {
		ConfigTestFixtures.trimbleEmailPort = trimbleEmailPort;
	}

	/**
	 * Gets the trimble email id.
	 * 
	 * @return the trimble email id
	 */
	public static String getTrimbleEmailId() {
		return trimbleEmailId;
	}

	/**
	 * Sets the trimble email id.
	 * 
	 * @param trimbleEmailId
	 *            the new trimble email id
	 */
	public static void setTrimbleEmailId(String trimbleEmailId) {
		ConfigTestFixtures.trimbleEmailId = trimbleEmailId;
	}

	/**
	 * Gets the trimble email password.
	 * 
	 * @return the trimble email password
	 */
	public static String getTrimbleEmailPassword() {
		return trimbleEmailPassword;
	}

	/**
	 * Sets the trimble email password.
	 * 
	 * @param trimbleEmailPassword
	 *            the new trimble email password
	 */
	public static void setTrimbleEmailPassword(String trimbleEmailPassword) {
		ConfigTestFixtures.trimbleEmailPassword = trimbleEmailPassword;
	}

	/**
	 * Gets the gmail email host.
	 * 
	 * @return the gmail email host
	 */
	public static String getGmailEmailHost() {
		return gmailEmailHost;
	}

	/**
	 * Sets the gmail email host.
	 * 
	 * @param gmailEmailHost
	 *            the new gmail email host
	 */
	public static void setGmailEmailHost(String gmailEmailHost) {
		ConfigTestFixtures.gmailEmailHost = gmailEmailHost;
	}

	/**
	 * Generate config test data.
	 * 
	 * @param env
	 *            the env
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void generateConfigTestData(String env)
			throws FileNotFoundException, IOException {
		Environment = env;
		emailId3 = PropertyReader.getPropValuesFromConfig("emailId3", env);
		emailpwd3 = PropertyReader.getPropValuesFromConfig("emailpwd3", env);
		emailId4 = PropertyReader.getPropValuesFromConfig("emailId4", env);
		emailpwd4 = PropertyReader.getPropValuesFromConfig("emailpwd4", env);

		emailId2 = PropertyReader.getPropValuesFromConfig("emailId2", env);
		emailpwd2 = PropertyReader.getPropValuesFromConfig("emailpwd2", env);

		emailId1 = PropertyReader.getPropValuesFromConfig("emailId1", env);
		emailpwd1 = PropertyReader.getPropValuesFromConfig("emailpwd1", env);

		innomindsEmailHost = PropertyReader.getPropValuesFromConfig(
				"innominds.email.host", env);
		innomindsEmailPort = PropertyReader.getPropValuesFromConfig(
				"innominds.email.port", env);
		innomindsEmailId = PropertyReader.getPropValuesFromConfig(
				"innominds.email.id", env);
		innomindsEmailPassword = PropertyReader.getPropValuesFromConfig(
				"innominds.email.password", env);
		trimbleEmailHost = PropertyReader.getPropValuesFromConfig(
				"trimble.email.host", env);
		trimbleEmailPort = PropertyReader.getPropValuesFromConfig(
				"trimble.email.port", env);
		trimbleEmailId = PropertyReader.getPropValuesFromConfig(
				"trimble.email.id", env);
		trimbleEmailPassword = PropertyReader.getPropValuesFromConfig(
				"trimble.email.password", env);
		gmailEmailHost = PropertyReader.getPropValuesFromConfig(
				"gmail.email.host", env);
		loginUsername = PropertyReader.getPropValuesFromConfig("loginUsername",
				env);
		loginPassword = PropertyReader.getPropValuesFromConfig("loginPassword",
				env);
		webAppUrl = PropertyReader.getPropValuesFromConfig("web.app.url", env);
		adminAppUrl = PropertyReader.getPropValuesFromConfig(
				"web.admin.app.url", env);
		adminAppUsername = PropertyReader.getPropValuesFromConfig(
				"web.admin.app.username", env);
		adminAppPassword = PropertyReader.getPropValuesFromConfig(
				"web.admin.app.password", env);
		uploadEmailId = PropertyReader.getPropValuesFromConfig("uploadEmailId",
				env);
		uploadEmailPwd = PropertyReader.getPropValuesFromConfig(
				"uploadEmailPwd", env);
		trimbleSendEmailHost = PropertyReader.getPropValuesFromConfig(
				"innominds.sendemail.host", env);
		innomindsSendEmailHost = PropertyReader.getPropValuesFromConfig(
				"trimble.sendemail.host", env);
		gmailSendEmailHost = PropertyReader.getPropValuesFromConfig(
				"gmail.sendemail.host", env);
		sendEmailFrom = PropertyReader.getPropValuesFromConfig("sendEmailFrom",
				env);
		sendEmailPwd = PropertyReader.getPropValuesFromConfig("sendEmailPwd",
				env);
		sendEmailTo = PropertyReader
				.getPropValuesFromConfig("sendEmailTo", env);
		sendEmailPort = PropertyReader.getPropValuesFromConfig(
				"sendemail.port", env);
		sapXmlPayloadUrl = PropertyReader.getPropValuesFromConfig(
				"sapxmlpayload", env);
		sapXmlPayloadUsername = PropertyReader.getPropValuesFromConfig(
				"sapxmlpayload.username", env);
		sapXmlPayloadPassword = PropertyReader.getPropValuesFromConfig(
				"sapxmlpayload.password", env);
		country = PropertyReader.getPropValuesFromConfig("Country", env);
		language = PropertyReader.getPropValuesFromConfig("Language", env);
		exceluploadEmailId = PropertyReader.getPropValuesFromConfig(
				"ExceluploadEmailId", env);
		exceluploadEmailPwd = PropertyReader.getPropValuesFromConfig(
				"ExceluploadEmailPwd", env);
	}
	
	public void generateConfigTestData(String webEnv, String mobileEnv) throws FileNotFoundException, IOException {
		deviceName = PropertyReader.getPropValuesFromConfig("deviceName", "", mobileEnv);
		deviceModel=PropertyReader.getPropValuesFromConfig("deviceModel", "", mobileEnv);
		deviceManufacturer = PropertyReader.getPropValuesFromConfig("deviceManufacturer", "", mobileEnv);
		platformName = PropertyReader.getPropValuesFromConfig("platformName", "", mobileEnv);
		platformVersion = PropertyReader.getPropValuesFromConfig("platformVersion", "", mobileEnv);
		udid = PropertyReader.getPropValuesFromConfig("udid", "", mobileEnv);
		appiumServerUrl = PropertyReader.getPropValuesFromConfig("appiumServerUrl", "", mobileEnv);
		objectRepoFile = PropertyReader.getPropValuesFromConfig("objectRepoFile", "", mobileEnv);
		appPackage = PropertyReader.getPropValuesFromConfig("appPackage", "", mobileEnv);
		appActivity = PropertyReader.getPropValuesFromConfig("appActivity", "", mobileEnv);
		userName = PropertyReader.getPropValuesFromConfig("userName", "", mobileEnv);
		passWord = PropertyReader.getPropValuesFromConfig("passWord", "", mobileEnv);
		userFullName = PropertyReader.getPropValuesFromConfig("userFullName", "", mobileEnv);
		defaultLanguage = PropertyReader.getPropValuesFromConfig("language", "", mobileEnv);
		defaultLocation = PropertyReader.getPropValuesFromConfig("defaultLoaction", "", mobileEnv);

		webUsername = PropertyReader.getPropValuesFromConfig("webMobileUsername", webEnv, "");
		webPassword = PropertyReader.getPropValuesFromConfig("webMobilePassword", webEnv, "");
		webAppUrl = PropertyReader.getPropValuesFromConfig("web.app.url", webEnv, "");

		uploadEmailId = PropertyReader.getPropValuesFromConfig("uploadMobileEmailId", webEnv, "");
		uploadEmailPwd = PropertyReader.getPropValuesFromConfig("uploadMobileEmailPwd", webEnv, "");
		gmailEmailHost = PropertyReader.getPropValuesFromConfig("gmail.email.host", webEnv, "");

	}

}
