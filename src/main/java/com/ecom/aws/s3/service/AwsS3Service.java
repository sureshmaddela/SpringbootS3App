package com.ecom.aws.s3.service;

import org.springframework.web.multipart.MultipartFile;

public interface AwsS3Service {

	void uploadFile(MultipartFile multipartFile);

	byte[] downloadFile(String keyName);
}
