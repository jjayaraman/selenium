package com.jai.file.service;

import java.io.File;
import java.net.URLConnection;

/**
 * 
 * Part 1:
 * 
 * Write a Service layer bean to do the following:
 * 
 * 1. Scan configured directory in file system which will return this information --> filename, file mime type, file size, file extension
 * 
 * 2. Use a directory containing a reasonably large number of files, minimum 10.
 * 
 * 3. Provide a way to retrieve certain supported mime type files: configure excel and csv are supported currently
 * 
 * @author jay
 *
 */
public class FileService {

	public void scanDirectory(String directory) {

		File dir = new File(directory);
		File[] files = dir.listFiles();

		for (File file : files) {

			System.out.println("File name : " + file.getName());
			System.out.println("File mime type : " + URLConnection.guessContentTypeFromName(file.getName()));
			System.out.println("File size : " + file.length() + " bytes");

			String fileName = file.getName();
			System.out.println("File extension : " + fileName.substring(fileName.lastIndexOf(".") + 1));
			System.out.println("");

		}

	}

	public void scanDirectoryFilterByMime(String directory, String mimeType) {

		File dir = new File(directory);
		File[] files = dir.listFiles();

		for (File file : files) {

			String mime = URLConnection.guessContentTypeFromName(file.getName());
			if (mime != null && mime.equalsIgnoreCase(mimeType)) {
				System.out.println("File name : " + file.getName());
				System.out.println("File mime type : " + URLConnection.guessContentTypeFromName(file.getName()));
				System.out.println("File size : " + file.length() + " bytes");

				String fileName = file.getName();
				System.out.println("File extension : " + fileName.substring(fileName.lastIndexOf(".") + 1));
				System.out.println("");

			}
		}

	}

}
