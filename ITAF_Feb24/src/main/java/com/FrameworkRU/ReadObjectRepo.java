package com.FrameworkRU;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * The Class ReadObjectRepo.
 */
public class ReadObjectRepo {

	public Log logger;
	FileInputStream file;

	/**
	 * Instantiates a new read object repo.
	 * 
	 * @param fileName
	 *            the file name
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public ReadObjectRepo(String fileName) throws IOException {
		file = new FileInputStream(new File(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\ObjectRepo\\" + fileName + ".xls")); 
	}

	/**
	 * Generate or.
	 * 
	 * @param orSheetName
	 *            the or sheet name
	 * @return the map
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Map<String, Map<String, String>> generateOR(String orSheetName)
			throws IOException {
		@SuppressWarnings("resource")
		HSSFWorkbook workbook = new HSSFWorkbook(file);

		// Get first/desired sheet from the workbook
		HSSFSheet sheet = workbook.getSheet(orSheetName);

		int nRowCount = sheet.getLastRowNum();
		Map<String, Map<String, String>> map = new HashMap<String, Map<String, String>>();
		for (int j = 1; j <= nRowCount; j++) {
			try {
				String cell = sheet.getRow(j).getCell(0).getStringCellValue()
						.trim();
				String proType = sheet.getRow(j).getCell(1)
						.getStringCellValue().trim();
				String ProValue = sheet.getRow(j).getCell(2)
						.getStringCellValue().trim();
				Map<String, String> map2 = new HashMap<String, String>();
				if (cell != null) {
					if (proType != null) {
						map2.put(sheet.getRow(0).getCell(1)
								.getStringCellValue(), proType);
					} else {
						map2.put(sheet.getRow(0).getCell(1)
								.getStringCellValue(), "");
					}
					if (ProValue != null) {
						map2.put(sheet.getRow(0).getCell(2)
								.getStringCellValue(), ProValue);
					} else {
						map2.put(sheet.getRow(0).getCell(2)
								.getStringCellValue(), "");
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
