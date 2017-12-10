package com.jai.file.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
			
			if(!file.isFile()) {
				return;
			}

			System.out.println("File name : " + file.getName());
			System.out.println("File mime type : " + URLConnection.guessContentTypeFromName(file.getName()));
			System.out.println("File size : " + file.length() + " bytes");

			String fileName = file.getName();
			System.out.println("File extension : " + fileName.substring(fileName.lastIndexOf(".") + 1));
			System.out.println("");
			
			
			// Read contents
			readFileContents(file);

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

	public void readFileContents(File file) {
		
		BufferedReader fileReader = null;
		try {
			String line;
			 fileReader = new BufferedReader(new FileReader(file));
			
			while ((line = fileReader.readLine()) != null) {
				String[] data = line.split(",");
				
				// Car reg no
				String carReg = data[0];
				String make = data[1];
				String color = data[2];
				
				System.out.println("reg : " +carReg);
				System.out.println("make : " +make);
				System.out.println("color : " +color);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
