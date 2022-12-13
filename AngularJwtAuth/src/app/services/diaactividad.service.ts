import { Injectable } from '@angular/core';
import { DiasActividad } from '../modelos/DiasActividad';
import { Observable } from 'rxjs';
import { Semana } from '../modelos/Semana';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { AltaActividad } from '../modelos/AltaActividad';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  
};
@Injectable({
  providedIn: 'root'
})
export class DiaactividadService {
  private endpoint:string = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) { }

  enviarSemana (semana): Observable<DiasActividad[]> {
    return this.http.post<DiasActividad[]>(this.endpoint + 'diaactividad' , semana, httpOptions)
  }
  enviarFechaActividad(fechaActividadList):Observable<DiasActividad[]>{
  return this.http.post<DiasActividad[]>(this.endpoint + 'guardarFechaActividad' , fechaActividadList, httpOptions)
}
borrarFechaActividad(fechaActividad):Observable<DiasActividad>{
  return this.http.post<DiasActividad>(this.endpoint + 'deleteFechaActividad' , fechaActividad, httpOptions)
}
getFechaActividad(): Observable<DiasActividad[]> {
  return this.http.get<DiasActividad[]>(this.endpoint+'getFechaActividad')
  }
  getAltaActividad(usuario):Observable<AltaActividad[]>{
    return this.http.post<AltaActividad[]>(this.endpoint + 'altaActividad' , usuario, httpOptions)
  }
  borrarAltaActividad(altaActividad):Observable<AltaActividad>{
    return this.http.post<AltaActividad>(this.endpoint + 'deleteAltaActividad' , altaActividad, httpOptions)
  }
  enviarALtaActividad(altaActividad):Observable<AltaActividad>{
    return this.http.post<AltaActividad>(this.endpoint + 'guardarAltaActividad' , altaActividad, httpOptions)
  }
}
