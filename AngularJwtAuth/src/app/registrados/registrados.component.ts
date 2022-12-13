import { Component, OnInit } from '@angular/core';
import { AltaActividad } from '../modelos/AltaActividad';
import { RegistradosService } from '../services/registrados.service';

@Component({
  selector: 'app-registrados',
  templateUrl: './registrados.component.html',
  styleUrls: ['./registrados.component.css']
})
export class RegistradosComponent implements OnInit {
  registrados:AltaActividad[];
  constructor(private registradosService: RegistradosService) { }

  ngOnInit() {
    this. getRegistrados()
  }
  getRegistrados(){
    this.registradosService.getFechaActividad().subscribe(registrados=> {      
      this.registrados = registrados;
      
    });
  }
}
