package com.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.FrameworkRU.Constants;

/**
 * The listener interface for receiving SAPIntegrationTests events. The class
 * that is interested in processing a SAPIntegrationTests event implements this
 * interface, and the object created with that class is registered with a
 * component using the component's
 * <code>addSAPIntegrationTestsListener<code> method. When
 * the SAPIntegrationTests event occurs, that object's appropriate
 * method is invoked.
 * 
 * @author Kiran Kumar Cherukuri
 */

public class TestSuiteListener implements IAnnotationTransformer 
{
	
	/* (non-Javadoc)
	 * @see org.testng.IAnnotationTransformer#transform(org.testng.annotations.ITestAnnotation, java.lang.Class, java.lang.reflect.Constructor, java.lang.reflect.Method)
	 */
	@Override
	public void transform(ITestAnnotation annotation, @SuppressWarnings("rawtypes") Class testClass,
			@SuppressWarnings("rawtypes") Constructor testConstructor, Method testMethod) 
	{
    	try {
    		//setExecutor(annotation, Constants.TESTSUITE_FILE_PATH, Constants.TESTSUITE_FILE_SHEETNAME, "TestSuites", testMethod.getName());
    		setExecutor(annotation, Constants.TESTSUITE_FILE_PATH, Constants.TESTSUITE_FILE_SHEETNAME, "SAP", testMethod.getName());
    		setExecutor(annotation, Constants.TESTSUITE_FILE_PATH, Constants.TESTSUITE_FILE_SHEETNAME, "Login", testMethod.getName());
			setExecutor(annotation, Constants.TESTSUITE_FILE_PATH, Constants.TESTSUITE_FILE_SHEETNAME, "TPASS", testMethod.getName());
			setExecutor(annotation, Constants.MOBILE_TESTSUITE_FILE_PATH, Constants.TESTSUITE_FILE_SHEETNAME, "Mobile", testMethod.getName());
		} catch (IOException e) 
    	{
			e.printStackTrace();
		}
    }	
	
	/**
	 * Sets the executor.
	 *
	 * @param annotation the annotation
	 * @param filepath the filepath
	 * @param sheetName the sheet name
	 * @param module the module
	 * @param testMethod the test method
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void setExecutor(ITestAnnotation annotation,String filepath,String sheetName, String module, String testMethod) throws IOException
	{
		Path path = Paths.get(filepath);
		String fileNamefromfullfilepath = path.getFileName().toString();
		String filepathfromfullfilepath = path.getParent().toString();
		LinkedHashMap<String, String> hmSuites = readExcel(filepathfromfullfilepath, fileNamefromfullfilepath, sheetName);
    	Iterator<Entry<String, String>> Ihm=hmSuites.entrySet().iterator();
    	LinkedHashMap<String, String> hm = null;
    	while(Ihm.hasNext())
    	{
    		Entry<String, String> keyvalues=Ihm.next();
    		if(keyvalues.getKey().equalsIgnoreCase(module) && keyvalues.getValue().equalsIgnoreCase("Yes"))
    		{
    			try 
    			{
					hm = readExcel(filepathfromfullfilepath, fileNamefromfullfilepath, module);
				} catch (IOException e) 
    			{
					e.printStackTrace();
				}
    			Set<Entry<String, String>> set = hm.entrySet();
    			Iterator<Entry<String, String>> l = set.iterator();
    			while (l.hasNext()) 
    			{
    				Entry<String, String> me = l.next();
    				String methodName = me.getKey();
    				String methodRunmode = me.getValue();
    				if (methodName.equals(testMethod)) 
    				{
    					if (methodRunmode.equalsIgnoreCase("No"))
    					{
    						annotation.setEnabled(false);
    					} else 
    					{
    						annotation.setEnabled(true);
    					}
    				}
    			}
    		}
       	}    
   	}

	/**
	 * Read excel.
	 *
	 * @param filePath the file path
	 * @param fileName the file name
	 * @param sheetName the sheet name
	 * @return the linked hash map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("resource")
	public static LinkedHashMap<String, String> readExcel(String filePath,
			String fileName, String sheetName) throws IOException 
	{
		LinkedHashMap<String, String> lhm;
		File file = new File(filePath +File.separator+ fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook DriverWorkBook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		if (fileExtensionName.equals(".xlsx")) 
		{
			DriverWorkBook = new XSSFWorkbook(inputStream);
		}
		else if (fileExtensionName.equals(".xls")) 
		{
			DriverWorkBook = new HSSFWorkbook(inputStream);
		}
		Sheet sheet = DriverWorkBook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		lhm = new LinkedHashMap<String, String>();
		for (int i = 1; i < rowCount + 1; i++) 
		{
			Row row = sheet.getRow(i);
			lhm.put(row.getCell(1).getStringCellValue(), row.getCell(2)
					.getStringCellValue());
		}
		return lhm;
	}

}