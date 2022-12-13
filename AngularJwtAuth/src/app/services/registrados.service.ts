import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AltaActividad } from '../modelos/AltaActividad';

@Injectable({
  providedIn: 'root'
})
export class RegistradosService {

  private endpoint:string = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) { }
  getFechaActividad(): Observable<AltaActividad[]> {
    return this.http.get<AltaActividad[]>(this.endpoint+'registrados')
    }
}
