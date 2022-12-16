
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Actividad } from '../modelos/actividad';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  
};
@Injectable({
  providedIn: 'root'
})
export class ActividadService {

  private endpoint:string = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) {};
  getActividades(): Observable<Actividad[]> {
    return this.http.get<Actividad[]>(this.endpoint+'actividades');
  }
  addActividad (actividad): Observable<Actividad> {
    return this.http.post<Actividad>(this.endpoint + 'addActividad' , actividad, httpOptions)
  }
}
