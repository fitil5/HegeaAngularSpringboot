import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { UploadFileService } from '../../services/upload-file.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { ExcelResponse} from 'src/app/modelos/ExcelResponse';
import swal from 'sweetalert2'
import { Router } from '@angular/router';
import { DataService } from '../../services/data.service';


@Component({
  selector: 'form-upload',
  templateUrl: './form-upload.component.html',
  styleUrls: ['./form-upload.component.css']
})
export class FormUploadComponent implements OnInit {
  selectedFiles: FileList;
  currentFileUpload: File;
  progress: { percentage: number } = { percentage: 0 };
  excelResponse:any;
 
  constructor(private uploadService: UploadFileService, private router: Router, public dataService: DataService) { }
 
  ngOnInit() {
  }
 
  selectFile(event) {
    this.selectedFiles = event.target.files;
  }
 
  upload() {
    this.progress.percentage = 0; 
    this.currentFileUpload = this.selectedFiles.item(0);
    this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
      if (event.type === HttpEventType.UploadProgress) {
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } /*else if (event instanceof HttpResponse) {
        console.log('File is completely uploaded!');
        this.excelResponse=event.body;
        console.log(event.body);
      }*/
      else  if (event.type === HttpEventType.Response) {
       
      
//this.excelResponse = event.body;
this.dataService.excelResponse= event.body as ExcelResponse;
//this.excelResponse.excelDTOList= event.body['excelDTOList'];
//console.log(this.excelResponse.excelDTOList[0].das);
//console.log(event.body['errores']);
        //uploaded bytes
        //total bytes to upload
      if (this.dataService.excelResponse.errores.length==0 && this.dataService.excelResponse.usuarios.length >0){//} && this.excelResponse.excelDTOList!==null) {
       /* swal(
          'El fichero se ha subido con exito!',
          'No se han encontrado errores',
          'success'
        )*/
        this.redireccionViewExcel();
        
      }else{
        swal.fire({
      title: '¿Quiere verlos?',
      text: "Se han detectador errores",
      //type: 'question',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si'
    }).then((result) => {
if(result.value){
//this.dataService.excelResponse= this.excelResponse;
  this.redireccionErrores();
  
}

    })

      }
    
      }       
    });
 
    this.selectedFiles = undefined;
  }

  redireccionErrores(){
    this.router.navigate(['/erroresupload'])
  }
  redireccionViewExcel(){
    this.router.navigate(['/viewexcel'])
  }
  

}
