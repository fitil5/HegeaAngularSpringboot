import { Component, OnInit } from '@angular/core';
import { Actividad } from '../modelos/actividad';
import { ActividadService } from '../services/actividad.service';

@Component({
  selector: 'app-actividad',
  templateUrl: './actividad.component.html',
  styleUrls: ['./actividad.component.css']
})
export class ActividadComponent implements OnInit {
actividades:Actividad[]
  constructor(public actividadService:ActividadService) { }

  ngOnInit() {
    this.getActividades()
  }
getActividades(){
  this.actividadService.getActividades().subscribe(actividades=> {      
    this.actividades = actividades;
    console.log(this.actividades);
  });
}
}
