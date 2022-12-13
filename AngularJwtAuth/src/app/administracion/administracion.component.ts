import { Component, OnInit, AfterViewInit } from '@angular/core';
import { AdminstracionService } from '../services/adminstracion.service';
import { Usuario } from '../modelos/Usuario.models';
import { Router } from '@angular/router';
import { DataService } from '../services/data.service';
import swal from 'sweetalert2'
import { TokenStorageService } from '../auth/token-storage.service';

@Component({
  selector: 'app-administracion',
  templateUrl: './administracion.component.html',
  styleUrls: ['./administracion.component.css']
})
export class AdministracionComponent implements AfterViewInit
    
   {

  constructor(private token: TokenStorageService,public adminstracionService:AdminstracionService, private router: Router,public dataService: DataService) { }
  usuarios:Usuario[];
  username:string;
  searchTerm:string;
  
  ngAfterViewInit(){
    
    if(this.token.getAuthorities().length ==0){
     // this.router.navigate(['/'])
    }
    this.getUsuarios();
      
  }
  getUsuarios(){
    this.adminstracionService.getUsuarios().subscribe(usuarios=> {      
      this.usuarios = usuarios;
      console.log(this.usuarios);
    });
}
update(usuario:Usuario) {
  this.dataService.usuario = usuario;    
  this.router.navigate(['/editUsuario']);
}   

      delete(id){
        swal.fire({
          title: '¿Estas Seguro?',
          text: "No podras volver atras",
          type: 'question',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Si, Modificalo!'
        }).then((result) => {
          if (result.value) {
            swal.fire(
              'Modificado!',
              'El registro ha sido modificado',
              'success'
            ).then((result) => {
              if (result.value) {
                console.log("Usuario dborrado");
                this.adminstracionService.deleteUsuario(id).subscribe(
                  usuario => {
                    console.log("Usuario dborrado");
                    this.getUsuarios();
                    }
                ); 
               // this.redireccion();
              }
            })
            
          }else{
            swal.fire(
              'Cancelado',
          'No se ha modificado el registro',
          'error')
          }
        })
      }
}
