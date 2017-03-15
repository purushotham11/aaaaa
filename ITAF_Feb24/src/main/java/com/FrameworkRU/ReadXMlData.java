package com.FrameworkRU;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

/**
 * The Class ReadXMlData.
 * 
 * @author Kiran Kumar Cherukuri
 */

public class ReadXMlData {

	public static String productmaster_materialnumber;
	public static String productmaster_modelnumber;
	public static String productmaster_manufacturer;
	public static String asset_invalidmaterial_scanCode;
	public static String asset_invalidmaterial_materialnumber;
	public static String assset_invalidmaterial_serialNumber;
	public static String assset_onlymanufacturer_serialNumber;
	public static String asset_onlymanufacturer_scanCode;
	public static String assset_onlymodel_serialNumber;
	public static String asset_onlymodel_scanCode;
	public static String asset_onlymanufacturer_materialnumber;
	public static String asset_onlymodel_materialnumber;

	/**
	 * Gets the data from xml productmaster.
	 * 
	 * @param file
	 *            the file
	 * @return the data from xml productmaster
	 * @throws XPathExpressionException
	 *             the x path expression exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             the SAX exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void getDataFromXmlProductmaster(String file)
			throws XPathExpressionException, ParserConfigurationException,
			SAXException, IOException {
		String readFile = file;

		productmaster_materialnumber = ReadXmlByTag.pickXpathData(readFile,
				"/XMLImportSet/Publisher/ProductMaster/MaterialNumber");
		productmaster_modelnumber = ReadXmlByTag.pickXpathData(readFile,
				"/XMLImportSet/Publisher/ProductMaster/Model");
		productmaster_manufacturer = ReadXmlByTag.pickXpathData(readFile,
				"/XMLImportSet/Publisher/ProductMaster/Manufacturer");

	}

	/**
	 * Gets the data from xml assets.
	 * 
	 * @param file
	 *            the file
	 * @return the data from xml assets
	 * @throws XPathExpressionException
	 *             the x path expression exception
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 * @throws SAXException
	 *             the SAX exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void getDataFromXmlAssets(String file)
			throws XPathExpressionException, ParserConfigurationException,
			SAXException, IOException {
		String readFile = file;
		assset_invalidmaterial_serialNumber = ReadXmlByTag.pickXpathData(
				readFile,
				"/XMLImportSet/Publisher/Customer/Asset[5]/SerialNumber");
		asset_invalidmaterial_scanCode = ReadXmlByTag.pickXpathData(readFile,
				"/XMLImportSet/Publisher/Customer/Asset[5]/OnTrackScanCode");
		asset_invalidmaterial_materialnumber = ReadXmlByTag.pickXpathData(
				readFile,
				"/XMLImportSet/Publisher/Customer/Asset[5]/MaterialNumber");
	}
}