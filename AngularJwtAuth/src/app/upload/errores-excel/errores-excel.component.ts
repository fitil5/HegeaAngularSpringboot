import { Component, OnInit,  Input } from '@angular/core';
import { DataService } from '../../services/data.service';
import { ExcelResponse } from 'src/app/modelos/ExcelResponse';
import { Router } from '@angular/router';
import swal from 'sweetalert2'

@Component({
  selector: 'app-errores-excel',
  templateUrl: './errores-excel.component.html',
  styleUrls: ['./errores-excel.component.css']
})
export class ErroresExcelComponent implements OnInit {
  excelResponse:ExcelResponse;
  constructor(public dataService:DataService,private router: Router) { }

  ngOnInit() {
    this.excelResponse= this.dataService.excelResponse;
  }
  redireccion(){
    this.router.navigate(['/viewexcel'])
  }
  comprobacionForm(){ 
    
    for (let line of this.excelResponse.errores) {
      
      if(line.username==""){
        
        return true;
      }    
    }
    return false;
  }

  siguiente(){

    if( this.comprobacionForm()){
  swal.fire({
      title: '¿Desea eliminar estas filas?',
      text: "Se han detectador errores",
      //type: 'question',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si'
    }).then((result) => {
if(result.value){
  this.eliminarVacio();
  this.dataService.excelResponse.usuarios=this.dataService.excelResponse.usuarios.concat(this.dataService.excelResponse.errores);
  this.redireccion();  
}
    })
  } 
  else {
     this.dataService.excelResponse.usuarios=this.dataService.excelResponse.usuarios.concat(this.dataService.excelResponse.errores);
    this.redireccion();
  } 
}
eliminarVacio()
{
 
  for (let i =0; i<this.excelResponse.errores.length; i++) {
    if(this.excelResponse.errores[i].username==""){
      
     this.excelResponse.errores.splice(i,1);   
    } 
  
  }
 
}


  


}
