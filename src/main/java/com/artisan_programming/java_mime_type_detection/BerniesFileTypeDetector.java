package com.artisan_programming.java_mime_type_detection;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;

public class BerniesFileTypeDetector extends FileTypeDetector {

    @Override
    public String probeContentType(Path path) throws IOException {
        System.out.println("Checking if this is a Bernie file...");
        BufferedReader reader = Files.newBufferedReader(path.toAbsolutePath(), StandardCharsets.UTF_8);
        
        if (reader.readLine().contains("Bernie")) {
            return "text/prs.bernie";
        }
        
        return null;
    }

}
