package com.jai.file.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileServiceTest {

	static FileService fileService = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fileService = new FileService();
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testScanDirectory() {
		
		String directory = "src/test/java/"; // Your file directory
		fileService.scanDirectory(directory);
	}

	
	@Test
	public void scanDirectoryFilterByMime() {
		
		String directory = "src/test/java/"; // Your file directory
		fileService.scanDirectoryFilterByMime(directory,"text/plain");
	}
}
