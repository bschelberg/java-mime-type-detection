package com.artisan_programming.java_mime_type_detection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.spi.FileTypeDetector;
import java.util.ServiceLoader;

import org.junit.Test;

public class BerniesFileTypeDetectorTest {

	@Test
	public void shouldInstallAsService() {
		boolean found = false;
		
		for (FileTypeDetector fileTypeDetector : ServiceLoader.load(FileTypeDetector.class)) {
			System.out.println(fileTypeDetector.getClass().getName());
			
			found = found || (fileTypeDetector instanceof BerniesFileTypeDetector);
		}
		
		assertTrue(found);
	}
	
	@Test
	public void shouldUseCustomDetector() throws IOException {
		assertEquals("text/prs.bernie", Files.probeContentType(new File("src/test/resources/custom-file.custom").toPath()));
	}
}
