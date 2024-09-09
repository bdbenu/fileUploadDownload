package com.bd.benu.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils {

	  // Utility method to upload image to a specified directory
    public static String saveImagetoFolder(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        // Check if directory exists, if not, create it
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Construct the full file path
        Path filePath = uploadPath.resolve(fileName);

        // Save the file to the target location
        Files.copy(multipartFile.getInputStream(), filePath);

        return filePath.toString();  // Return the file path or file name
    }

    // Optional utility method to delete the file if needed
    public static void deleteFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.deleteIfExists(path);
    }

}
