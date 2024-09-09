package com.bd.benu.controller;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDetailsRestController {
	
	
	 private final Path imageLocation = Paths.get("/Users/benudharmunda/Desktop/Angular/uploads");
	 //@GetMapping("/get")
	 
	    /*public ResponseEntity<Resource> getImage(@RequestParam String filename) {
		 try {
	            Path file = imageLocation.resolve(filename).normalize();
	            Resource resource = (Resource) new UrlResource(file.toUri());

	            if (((AbstractFileResolvingResource) resource).exists() || ((AbstractFileResolvingResource) resource).isReadable()) {
	                return ResponseEntity.ok()
	                        .header(HttpHeaders.CONTENT_TYPE, "image/png") // Adjust content type if needed
	                        .body(resource);
	            } else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	            }
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
		 
	 }*/

}
