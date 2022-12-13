import { Injectable, OnInit } from '@angular/core';
import { Usuario } from '../modelos/Usuario.models';
import { Observable, of } from 'rxjs';
import { ExcelResponse } from '../modelos/ExcelResponse';
import { AltaActividad } from '../modelos/AltaActividad';

@Injectable() 
export class DataService{ 
  usuario: Usuario;
  excelResponse:ExcelResponse;
  
 
 
} 
