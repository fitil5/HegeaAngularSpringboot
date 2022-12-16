import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Organizacion } from 'src/app/modelos/Organizacion';
import { OrganizacionService } from 'src/app/organizacion.service';

@Component({
  selector: 'app-add-organizacion',
  templateUrl: './add-organizacion.component.html',
  styleUrls: ['./add-organizacion.component.css']
})
export class AddOrganizacionComponent implements OnInit {
  organizacion:Organizacion= new Organizacion();
  isSignedUp = false;
  isSignUpFailed = false;
  constructor(private organizacionService:OrganizacionService, private router:Router) { }

  ngOnInit() {
  }
  onSubmit(){
    this.organizacionService.addOrganizacion(this.organizacion).subscribe(organizacion=> {      
      this.isSignedUp = true;
        this.isSignUpFailed = false;
      
    });
  }
  
}
