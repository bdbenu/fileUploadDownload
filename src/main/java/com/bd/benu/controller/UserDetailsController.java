package com.bd.benu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bd.benu.model.UserDetails;
import com.bd.benu.service.UserdetailsService;

@Controller
public class UserDetailsController {
	@Autowired
	private UserdetailsService service;

	@GetMapping(value = { "/", "/load" })
	public String loadPage(Model model) {
		UserDetails userDetails = new UserDetails();
		model.addAttribute("userDetails", userDetails);
		return "userdetails";
	}

	// @PostMapping("/uploaded")
	public String uploadFile(@ModelAttribute("userDetails") UserDetails userDetails, MultipartFile file, Model model) {
		boolean imageUplouad = service.imageUplouad(userDetails, file);
		if (imageUplouad) {
			model.addAttribute("sucMsg", "File uploaded successfully......");
		} else {
			model.addAttribute("failMsg", "File uploaded Failed......");
		}

		return "userdetails";
	}

	@PostMapping("/uploaded")
	public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {
		try {
			// Save the file and get its path
			String filePath = service.uploadImage(file);

			// Create new UserDetails object
			UserDetails userDetails = new UserDetails();
			userDetails.setImageName(file.getOriginalFilename());
			userDetails.setFilePath(filePath);

			// Save the userDetails in the database
			service.saveUserDetails(userDetails);

			model.addAttribute("message", "File uploaded successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "File upload failed: ");
		}

		return "redirect:/load";
	}
	

	public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

	@GetMapping("/uploadimage")
	public String displayUploadForm() {
		return "imageupload/index";
	}

}
