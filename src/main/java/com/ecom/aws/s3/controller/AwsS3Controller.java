package com.ecom.aws.s3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.aws.s3.service.AwsS3Service;

@RestController
@RequestMapping(value= "/s3")
public class AwsS3Controller {

	@Autowired
	private AwsS3Service service;

	@PostMapping(value= "/upload")
	public ResponseEntity<String> uploadFile(@RequestPart(value= "file") final MultipartFile multipartFile) {
		service.uploadFile(multipartFile);
		final String response = "[" + multipartFile.getOriginalFilename() + "] uploaded successfully.";
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value= "/download")
    public ResponseEntity<ByteArrayResource> downloadFile(@RequestParam(value= "fileName") final String keyName) {
        final byte[] data = service.downloadFile(keyName);
        final ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; filename=\"" + keyName + "\"")
                .body(resource);
    }
}
