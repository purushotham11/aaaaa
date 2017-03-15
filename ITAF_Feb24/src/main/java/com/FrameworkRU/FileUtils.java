package com.FrameworkRU;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class FileUtils.
 * 
 * @author Kiran Kumar Cherukuri
 * 
 */

public class FileUtils {

	/**
	 * Delete screenshots.
	 * 
	 * @param path
	 *            the path
	 */
	public static void deleteFile(String path) {
		List<String> filesList = new ArrayList<String>();
		List<String> folderList = new ArrayList<String>();
		File file = new File(path);
		if (file.exists()) {
			fetchCompleteList(filesList, folderList, path);
			for (String filePath : filesList) {
				File tempFile = new File(filePath);
				tempFile.delete();
			}
			for (String filePath : folderList) {
				File tempFile = new File(filePath);
				tempFile.delete();
			}
		}
	}

	/**
	 * Fetch complete list.
	 * 
	 * @param filesList
	 *            the files list
	 * @param folderList
	 *            the folder list
	 * @param path
	 *            the path
	 */
	private static void fetchCompleteList(List<String> filesList,
			List<String> folderList, String path) {
		File file = new File(path);
		File[] listOfFile = file.listFiles();
		for (File tempFile : listOfFile) {
			if (tempFile.isDirectory()) {
				folderList.add(tempFile.getAbsolutePath());
				fetchCompleteList(filesList, folderList,
						tempFile.getAbsolutePath());
			} else {
				filesList.add(tempFile.getAbsolutePath());
			}

		}

	}

	/**
	 * Write input file to out.
	 * 
	 * @param fileName
	 *            the file name
	 * @param readFile
	 *            the read file
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void writeInputFileToOut(String fileName, String readFile)
			throws IOException {
		String outPath = "src/test/resources/TestResults/SAPXmlOutputFiles/";
		String[] split = fileName.split("\\.");
		File outFile = new File(outPath + "//" + split[0]);
		outFile.mkdir();
		outFile = new File(outFile + "//" + fileName);
		outFile.createNewFile();
		FileWriter fw = new FileWriter(outFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(readFile);
		bw.close();
	}

}
