import { Component, OnInit, Input } from '@angular/core';
import { Usuario } from '../../modelos/Usuario.models';
import { AdminstracionService } from '../../services/adminstracion.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../../services/data.service';
import swal from 'sweetalert2'

@Component({
  selector: 'app-edit-usuario',
  templateUrl: './edit-usuario.component.html',
  styleUrls: ['./edit-usuario.component.css']
})
export class EditUsuarioComponent implements OnInit {
 // usuario = new Usuario();
  //@Input() usuario:Usuario;// = { username: '', password: '', rol:'',enabled:null, visitado:null};
  usuario=new  Usuario();
  constructor(public adminstracionService:  AdminstracionService, private route: ActivatedRoute,public dataService: DataService, private router: Router) {}
  isSignedUp = false;
  isSignUpFailed = false;
  ngOnInit() {
    //this.usuario =this.route.snapshot.params['Usuario'];
    if(this.dataService.usuario==null){
      this.router.navigate(['/'])
    }
    else{
      this.usuario =this.dataService.usuario;
    }
   // this.usuario =this.dataService.usuario;
  }
  
  

 

     
  
  onSubmit(){ 
    
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
            this.adminstracionService.updateUsuario(this.usuario).subscribe(
              usuario => {
                this.isSignedUp = true;
                this.isSignUpFailed = false;
                console.log("Usuario modificado");
                
                }
            ); 
            this.redireccion();
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
  redireccion(){
    this.router.navigate(['/administracion'])
  }
  // roles = [
  //   { key : 'ROLE_ADMIN' , value : 'ROLE_ADMIN' },
  //   { key : 'ROLE_USER' , value : 'ROLE_USER' },
  //   { key : 'ROLE_PM' , value : 'ROLE_PM' },  

  // ]
  enable = [
    { key : true , value : 'true' },
    { key : false , value : 'false' },
      

  ]

  roles=[
    {key:'ROLE_ADMIN',value:'ROLE_ADMIN'},
    {key:'ROLE_PM',value:'ROLE_PM'},
    {key:'ROLE_USER',value:'ROLE_USER'},
];

  
  

}
