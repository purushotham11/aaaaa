package com.ExcelUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import com.FrameworkRU.Constants;

public class WebObjectRepoReader {
	public Log logger;
	FileInputStream file;
	public String webEnv = "Primeoqa";
	// public String webEnv = System.getProperty("webEnv");

	public WebObjectRepoReader(String fileName) {
		if (webEnv.equalsIgnoreCase("Primeoqa")) 
		{
			try {
				file = new FileInputStream(new File(Constants.WEB_OBJECT_REPO_FILE_PATH + fileName + ".xls"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unused")
	public Map<String, Map<String, String>> generateOR(String orSheetName) {
		HSSFWorkbook workbook = null;
		try {
			workbook = new HSSFWorkbook(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		HSSFSheet sheet = workbook.getSheet(orSheetName);
		int nRowCount = sheet.getLastRowNum();
		Row header1 = sheet.getRow(0);
		int nColumnCount = header1.getLastCellNum();

		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
		for (int j = 1; j <= nRowCount; j++) {
			try {
				String cell = sheet.getRow(j).getCell(0).getStringCellValue().trim();
				String proType = sheet.getRow(j).getCell(1).getStringCellValue().trim();
				String ProValue = sheet.getRow(j).getCell(2).getStringCellValue();// .trim();
				Map<String, String> map2 = new HashMap<String, String>();

				if (cell != null) {
					if (proType != null) {
						map2.put(sheet.getRow(0).getCell(1).getStringCellValue(), proType);
					} else {
						map2.put(sheet.getRow(0).getCell(1).getStringCellValue(), "");
					}
					if (ProValue != null) {
						map2.put(sheet.getRow(0).getCell(2).getStringCellValue(), ProValue);
					} else {
						map2.put(sheet.getRow(0).getCell(2).getStringCellValue(), "");
					}
					map.put(cell, map2);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return map;
	}
}
