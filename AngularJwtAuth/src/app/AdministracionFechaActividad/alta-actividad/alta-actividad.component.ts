import { AfterViewInit, Component, OnInit } from '@angular/core';
import { AltaActividad } from 'src/app/modelos/AltaActividad';
import { DataService } from 'src/app/services/data.service';
import { DiaactividadService } from 'src/app/services/diaactividad.service';
import { TokenStorageService } from '../../token-storage.service';

@Component({
  selector: 'app-alta-actividad',
  templateUrl: './alta-actividad.component.html',
  styleUrls: ['./alta-actividad.component.css']
})
export class AltaActividadComponent implements AfterViewInit {
  fechaActividad:AltaActividad[];
  
  constructor(public diaActividadService:DiaactividadService,public tokenStorage: TokenStorageService,public dataService:DataService) { }

  ngAfterViewInit() {
    this.getAltaActividad()
   
  }
  AltaBaja(altaActividad){
    if(altaActividad.alta){
    this.diaActividadService.borrarAltaActividad(altaActividad).subscribe(altaActivi=>{
      this. getAltaActividad();
    })
  }
  else{
    altaActividad.usuario=this.tokenStorage.getUsername()
    altaActividad.alta=true
    altaActividad.name=this.tokenStorage.getName()
    this.diaActividadService.enviarALtaActividad(altaActividad).subscribe(altaActivi=>{
      this. getAltaActividad();
    })
  }
 
  }
  getAltaActividad(){
  this.diaActividadService.getAltaActividad(this.tokenStorage.getUsername()).subscribe(fechaAct=> { 
    this.fechaActividad= fechaAct;
     });
}
deleteAltaActividad(altaActividad){

}
}
