package com.hegea.jwtauthentication.services;

import org.springframework.web.multipart.MultipartFile;

import com.hegea.jwtauthentication.model.ExcelResponse;

public interface IExcel {
	public void deleteIfFileExists(String filename);
	public ExcelResponse excel(MultipartFile file);
}
