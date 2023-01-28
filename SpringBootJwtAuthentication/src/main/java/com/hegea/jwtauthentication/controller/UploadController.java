package com.hegea.jwtauthentication.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.hegea.jwtauthentication.model.ExcelResponse;
import com.hegea.jwtauthentication.model.Usuario;
import com.hegea.jwtauthentication.services.IExcel;

import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


@RestController
public class UploadController {

	@Autowired
	IExcel excelservice;

	List<String> files = new ArrayList<String>();

//	@PostMapping("/post")
//	@CrossOrigin(origins = "http://localhost:4200")
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
//		String message = "";
//		try {
//			//storageService.store(file);
//			//files.add(file.getOriginalFilename());
//			String filePath ="D:\\Angular\\plantilla jwt springboot angular\\Nueva carpeta\\SpringBootJwtAuthentication-1\\SpringBootJwtAuthentication\\src\\main\\java\\com\\grokonez\\jwtauthentication\\file\\"+file.getOriginalFilename();
//			
//			file.transferTo(new File(filePath));
//			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
//			return ResponseEntity.status(HttpStatus.OK).body(message);
//		} catch (Exception e) {
//			message = "FAIL to upload " + file.getOriginalFilename() + "!";
//			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
//		}
//	}
	
	
	@PostMapping("/post")
	@CrossOrigin(origins = "http://localhost:4200")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public ExcelResponse uploadMultipartFile(@RequestParam("file") MultipartFile file) {
    	try {
    		
    		// save file to PostgreSQL
	    	//FileModel filemode = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
	    	//fileRepository.save(filemode);
	    	return excelservice.excel(file);
	    	//return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
	    	
		} catch (Exception e) {
			System.out.println(e.toString());
			//return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}   
    	return new ExcelResponse();
    }
	
	
	
	@PostMapping("/api/file/addExcel")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void upload(@RequestBody List<Usuario> excelEntityList) {
		//excelService.cargarExcel(excelEntityList);
		int i=0;
		
    }
	
	
	
	
	
	
}
