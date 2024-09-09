package com.bd.benu.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bd.benu.model.UserDetails;
import com.bd.benu.repositary.UserdetailsRepositary;
import com.bd.benu.util.FileUploadUtils;

@Service
public class UserdetailsServiceImpl implements UserdetailsService{
	
	@Autowired
	private UserdetailsRepositary userdetailsRepositary;
	
	 @Value("${file.upload-dir}")
	  private String uploadDir;
	
	private FileUploadUtils fileUploadUtils;

	@Override
	public boolean imageUplouad(UserDetails details,MultipartFile file) {
		//details.setFile(uploadDir);
		//details.setImageName(uploadDir);
		try {
			FileUploadUtils.saveImagetoFolder(uploadDir, uploadDir, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	  public String uploadImage(MultipartFile file) throws IOException {
	        // Get the original filename
	        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

	        // Create file path
	        Path filePath = Paths.get(uploadDir, fileName);

	        // Ensure the upload directory exists
	        Files.createDirectories(filePath.getParent());

	        // Copy file to the directory
	        Files.copy(file.getInputStream(), filePath);

	        // Return the file path
	        return filePath.toString();
	    }



	@Override
	public void saveUserDetails(UserDetails userDetails) {
		
		userdetailsRepositary.save(userDetails);
	}

}
