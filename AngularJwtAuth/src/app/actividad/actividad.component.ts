import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Actividad } from '../modelos/actividad';
import { ActividadService } from '../services/actividad.service';

@Component({
  selector: 'app-actividad',
  templateUrl: './actividad.component.html',
  styleUrls: ['./actividad.component.css']
})
export class ActividadComponent implements OnInit {
actividades:Actividad[];
  constructor(public actividadService:ActividadService, private router: Router) { }

  ngOnInit() {
    this.getActividades()
  }
getActividades(){
  this.actividadService.getActividades().subscribe(actividades=> {      
    this.actividades = actividades;
    console.log(this.actividades);
  });
}
redireccionar()
{this.router.navigate(['/addActividad']);}


}
