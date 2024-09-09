package com.bd.benu.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.bd.benu.model.UserDetails;

public interface UserdetailsService {
	
	public boolean imageUplouad(UserDetails details,MultipartFile file);

	public String uploadImage(MultipartFile file) throws IOException;

	public void saveUserDetails(UserDetails userDetails);

}
