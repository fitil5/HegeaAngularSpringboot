import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Actividad } from 'src/app/modelos/actividad';
import { ActividadService } from 'src/app/services/actividad.service';

@Component({
  selector: 'app-add-actividad',
  templateUrl: './add-actividad.component.html',
  styleUrls: ['./add-actividad.component.css']
})
export class AddActividadComponent implements OnInit {

  constructor(public actividadService:ActividadService, private router: Router) { }
  actividad:Actividad = new Actividad();
  isSignedUp = false;
  isSignUpFailed = false;
  ngOnInit() {
  }
  onSubmit(){

    this.actividadService.addActividad(this.actividad).subscribe(
      actividad => {
        this.isSignedUp = true;
        this.isSignUpFailed = false;
        this.router.navigate(['/actividad'])
        }
    ); 
  }
}
