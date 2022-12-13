import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Actividad } from '../modelos/actividad';

@Injectable({
  providedIn: 'root'
})
export class ActividadService {

  private endpoint:string = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) {};
  getActividades(): Observable<Actividad[]> {
    return this.http.get<Actividad[]>(this.endpoint+'actividades');
  }
}
