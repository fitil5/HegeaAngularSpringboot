import { Component, OnInit, AfterViewInit } from '@angular/core';
import { DiaactividadService } from 'src/app/services/diaactividad.service';
import { DiasActividad } from 'src/app/modelos/DiasActividad';

@Component({
  selector: 'app-borrar-fecha-actividad',
  templateUrl: './borrar-fecha-actividad.component.html',
  styleUrls: ['./borrar-fecha-actividad.component.css']
})
export class BorrarFechaActividadComponent implements AfterViewInit {
fechaActividadList:DiasActividad[]
  constructor(public diaactividadService:DiaactividadService) { }

  ngAfterViewInit() {
   this.getFechaActividad()
  }
  getFechaActividad(){
    this.diaactividadService.getFechaActividad().subscribe(fechaActividadList=>{
      this.fechaActividadList=fechaActividadList
    }
      );
  }
  delete(fechaActividad:DiasActividad){
    this.diaactividadService.borrarFechaActividad(fechaActividad).subscribe(fechaActividadList=>{
      this.getFechaActividad();
    });
  }

}
