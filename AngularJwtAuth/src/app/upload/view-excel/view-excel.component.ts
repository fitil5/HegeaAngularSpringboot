import { Component, OnInit, AfterViewInit } from '@angular/core';
import { ExcelResponse } from 'src/app/modelos/ExcelResponse';
import { DataService } from '../../services/data.service';
import { UploadFileService } from '../../services/upload-file.service';
import { Usuario } from 'src/app/modelos/Usuario.models';

@Component({
  selector: 'app-view-excel',
  templateUrl: './view-excel.component.html',
  styleUrls: ['./view-excel.component.css']
})
export class ViewExcelComponent implements  OnInit{
  excelResponse:ExcelResponse;
  constructor(public dataService:DataService,public uploadFile:UploadFileService) { }

  ngOnInit() {
    this.excelResponse= this.dataService.excelResponse;
  }
  
addExcel(excel:Usuario[]){
  this.uploadFile.addExcel(excel).subscribe(
    excel => {
      console.log("Excel subido");
    }        
    );
  }

}
