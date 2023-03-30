import { Component, OnInit } from '@angular/core';
import { Semana } from '../../../modelos/Semana';
import { DiaactividadService } from '../../../services/diaactividad.service';
import { DiasActividad } from '../../../modelos/DiasActividad';
import { Actividad } from 'src/app/modelos/actividad';
import { ActividadService } from 'src/app/services/actividad.service';




@Component({
  selector: 'app-diaactividad',
  templateUrl: './diaactividad.component.html',
  styleUrls: ['./diaactividad.component.css']
})
export class DiaactividadComponent implements OnInit {
  diasActividad:DiasActividad[]
  semana:Semana = new Semana(null,null,'',false,false,false,false,false);
  years:number[]
  actividades:Actividad[]
  
  constructor(public diaactividadService:DiaactividadService,public actividadService:ActividadService) { 
    
     
    
  }

  ngOnInit() {
   this.iniYear() 
   this.getActividades()
  }
  onSubmit(){
    this.diaactividadService.enviarFechaActividad(this.diasActividad).subscribe(diaActividad=>{}
      );
  }
  
  enviarSemana(){
    //console.log("lunes");
    this.diaactividadService.enviarSemana(this.semana).subscribe(diaActividad=> {      
      this.diasActividad = diaActividad;
      
    });
  }
  delete(diaActividad){
    this.diasActividad.splice(this.diasActividad.indexOf(diaActividad),1)

  }
 i=new Date().getFullYear()
  iniYear(){  
    this. years = new Array();
    for( this.i=2021; this.i<2118; this.i++){
      this.years.push(this.i);         
    }
  }

months = [
  { key : 'January' , value : 'Enero' },
  { key : 'February' , value : 'Febrero' },
  { key : 'March' , value : 'Marzo' },
  { key : 'April' , value : 'Abril' },
  { key : 'May' , value : 'Mayo' },
  { key : 'June' , value : 'Junio' },
  { key : 'July' , value : 'Julio' },
  { key : 'August' , value : 'Agosto' },
  { key : 'Septembre' , value : 'Septiembre' },
  { key : 'October' , value : ' Octubre' },
  { key : 'November' , value : 'Noviembre' },
  { key : 'December' , value : 'Diciembre' }
]
getActividades(){
  this.actividadService.getActividades().subscribe(actividades=> {      
    this.actividades = actividades;
    console.log(this.actividades);
  });
}

lunes(){
  if(this.semana.lunes){
    this.semana.lunes=false;
  }
  else{
    this.semana.lunes=true;
  }
  this.enviarSemana();
}
martes(){
  if(this.semana.martes){
    this.semana.martes=false;
  }
  else{
    this.semana.martes=true;
  }
  this.enviarSemana();
}
miercoles(){
  if(this.semana.miercoles){
    this.semana.miercoles=false;
  }
  else{
    this.semana.miercoles=true;
  }
  this.enviarSemana();
}
jueves(){
  if(this.semana.jueves){
    this.semana.jueves=false;
  }
  else{
    this.semana.jueves=true;
  }
  this.enviarSemana();
}
viernes(){
  if(this.semana.viernes){
    this.semana.viernes=false;
  }
  else{
    this.semana.viernes=true;
  }
  this.enviarSemana();
}


}
