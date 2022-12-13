package com.grokonez.jwtauthentication.services;

import org.springframework.web.multipart.MultipartFile;

import com.grokonez.jwtauthentication.model.ExcelResponse;

public interface IExcel {
	public void deleteIfFileExists(String filename);
	public ExcelResponse excel(MultipartFile file);
}
