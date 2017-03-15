package com.FrameworkRU;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * The Class PropertyWriter.
 * 
 * @author Kiran Kumar Cherukuri
 */

public class PropertyWriter {

	/**
	 * Sets the property.
	 * 
	 * @param propertyName
	 *            the property name
	 * @param propertyValue
	 *            the property value
	 */
	public static void setProperty(String propertyName, String propertyValue) {
		InputStream projectStream = null;
		FileOutputStream outStream = null;
		try {
			java.util.Properties projectProperties = new java.util.Properties();
			String projectPropsName = "src/test/resources/Properties/TestData/RuntimeTestData.properties";
			projectStream = new FileInputStream(projectPropsName);
			projectProperties.load(projectStream);

			outStream = new FileOutputStream(projectPropsName);
			projectProperties.setProperty(propertyName, propertyValue);
			projectProperties.store(outStream, null);
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (projectStream != null) {
				try {
					projectStream.close();
				} catch (IOException e) {
					System.out.println(e.getStackTrace());
				}
			}
			if (outStream != null) {
				try {
					outStream.close();
				} catch (IOException e) {
					System.out.println(e.getStackTrace());
				}
			}
		}
	}
}
