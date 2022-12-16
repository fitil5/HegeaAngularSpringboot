import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Organizacion } from '../modelos/Organizacion';
import { OrganizacionService } from '../organizacion.service';

@Component({
  selector: 'app-organizacion',
  templateUrl: './organizacion.component.html',
  styleUrls: ['./organizacion.component.css']
})
export class OrganizacionComponent implements OnInit {
organizaciones:Organizacion[];

  constructor(private organizacionService :OrganizacionService, private router:Router) { }

  ngOnInit() {
    this.getOrganizacion()
  }

  getOrganizacion(){
    this.organizacionService.getOrganizacion().subscribe(organizaciones=> {      
      this.organizaciones=organizaciones;
      
    });
}deleteOrganizacion(id){
  this.organizacionService.deleteOrganizacion(id).subscribe(
    organizacion => {
      
      this.getOrganizacion();
      }
  ); 
}

redireccion(){
  this.router.navigate(['/addOrganizacion']);
}


}
