package com.hegea.jwtauthentication.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hegea.jwtauthentication.model.ExcelResponse;
import com.hegea.jwtauthentication.model.Usuario;
@Service
public class Excel implements IExcel {
	@Override
	public void deleteIfFileExists(String filename) {
		File tmpDir = new File("D:\\Angular\\copia seguridad 10 upload\\SpringBootJwtAuthentication\\src\\main\\java\\com\\grokonez\\jwtauthentication\\file\\"+filename);
		if( tmpDir.exists()) {
			tmpDir.delete();
		}
	}  
	
	@Override
	public ExcelResponse excel(MultipartFile file) {
		  
		  //File convFile = new File();
		  
		  //after item.write(f); add this

		 // InputStream inputStream= new ByteArrayInputStream(file.getBytes());//IOUtils.toByteArray(//;getInputStream()));
		  File f;
		  String excelname = file.getOriginalFilename();
		  
		  File convFile =null;
		  try {
			   //f =new File("C:\\Users\\A709060\\Desktop\\jwt002\\src\\main\\java\\com\\example\\demo\\excel\\"+ excelname);
			  //f =new File("C:\\Users\\A709060\\Desktop\\jwt002\\src\\main\\java\\com\\example\\demo\\excel\\"+ file.getOriginalFilename());
			 // file.transferTo(new File("C:\\Users\\A709060\\Desktop\\jwt002\\src\\main\\java\\com\\example\\demo\\excel\\"+ file.getOriginalFilename()));
			  //file.transferTo(f);
			 // InputStream stream = new FileInputStream(f);
			  
			  deleteIfFileExists(excelname) ;
			 
				  /*convFile = new File("C:\\Users\\A709060\\Desktop\\jwt002\\src\\main\\java\\com\\example\\demo\\excel\\" +excelname);
				    convFile.createNewFile(); 
				    FileOutputStream fos = new FileOutputStream(convFile); 
				    fos.write(file.getBytes());
				    fos.close(); */
				  
				  f =new File("C:\\\\Users\\\\Gaming\\\\Documents\\\\Copia de seguridad\\\\Angular\\\\Angular\\\\copia seguridad17 email\\\\SpringBootJwtAuthentication\\\\src\\\\main\\\\java\\\\com\\\\grokonez\\\\jwtauthentication\\\\file"+ excelname);
				  file.transferTo(f);
			  
			  
			
			  
		  }
		  catch(Exception e) {
			 
		  }
		  
		  
		
		  file = null;
		  f= null;
			Workbook workbook;
			Sheet sheet= null;
			try {
				workbook = WorkbookFactory.create(new FileInputStream("C:\\Users\\Gaming\\Documents\\Copia de seguridad\\Angular\\Angular\\copia seguridad17 email\\SpringBootJwtAuthentication\\src\\main\\java\\com\\grokonez\\jwtauthentication\\file"+ excelname));
				 sheet = workbook.getSheetAt(0);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//"C:\\Users\\A709060\\Desktop\\jwt002\\src\\main\\java\\com\\example\\demo\\excel\\"+ excelname));//new FileInputStream("C:\\CursoLDCMadrid\\HegeaGrupo2\\src\\main\\webapp\\pages\\admin\\upload\\carga_parcial.xlsx"));
		
		   

		   
			DataFormatter dataFormatter = new DataFormatter();
			List<Usuario> excelDTOlist = new ArrayList<>();
			System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
			List<Usuario> erroresDTOList=new ArrayList<>();
			List <String> errores= new ArrayList<>();
			
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			
				if(dataFormatter.formatCellValue(sheet.getRow(i).getCell(0)).equals("") 
						|| dataFormatter.formatCellValue(sheet.getRow(i).getCell(1)).equals("") 
						|| dataFormatter.formatCellValue(sheet.getRow(i).getCell(2)).equals("") 
						|| dataFormatter.formatCellValue(sheet.getRow(i).getCell(3)).equals("") 
						|| dataFormatter.formatCellValue(sheet.getRow(i).getCell(4)).equals("")
						|| dataFormatter.formatCellValue(sheet.getRow(i).getCell(5)).equals("")
						) {
					erroresDTOList.add(new Usuario(dataFormatter.formatCellValue(sheet.getRow(i).getCell(0)).toString().equals("")?00:new Long(dataFormatter.formatCellValue(sheet.getRow(i).getCell(0))),
													dataFormatter.formatCellValue(sheet.getRow(i).getCell(1)),
													dataFormatter.formatCellValue(sheet.getRow(i).getCell(2)),
													dataFormatter.formatCellValue(sheet.getRow(i).getCell(3)),
													dataFormatter.formatCellValue(sheet.getRow(i).getCell(4)),
													dataFormatter.formatCellValue(sheet.getRow(i).getCell(5)),true
													)
										);
													errores.add("El das esta vacio en la fila " +i );
				
				}
				else {
			
						excelDTOlist.add(new Usuario(new Long(dataFormatter.formatCellValue(sheet.getRow(i).getCell(0))),
										  			  dataFormatter.formatCellValue(sheet.getRow(i).getCell(1)),
										  			  dataFormatter.formatCellValue(sheet.getRow(i).getCell(2)),
										  			  dataFormatter.formatCellValue(sheet.getRow(i).getCell(3)),
										  			  dataFormatter.formatCellValue(sheet.getRow(i).getCell(4)),
										  			  dataFormatter.formatCellValue(sheet.getRow(i).getCell(5)),true
										  			 )
										  			   
										);
						System.out.println(sheet.getRow(i).getCell(0) );
				}
			}

				//numErrores=errores.size();
				

				
		   //return excelDTOlist;
				/*if(erroresDTOList.isEmpty() || erroresDTOList==null ||  erroresDTOList.size()==0) {
					erroresDTOList.add(new ExcelDTO("vacio","vacio", "vacio", "vacio", "vacio",
							"vacio","vacio", "vacio", "vacio"));
				}*/
			ExcelResponse e = new  ExcelResponse(excelDTOlist,erroresDTOList);
				return 
		   e;
				
		   
		}
}
