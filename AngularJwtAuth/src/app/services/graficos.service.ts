import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Graficos } from '../modelos/Graficos';
import { GraficoList } from '../modelos/GraficoList';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  
};
@Injectable({
  providedIn: 'root'
})

export class GraficosService {
  private endpoint:string = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) { }
  createGrafico(organizacion): Observable<Graficos[]>{
    return  this.http.post<Graficos[]>(this.endpoint + 'createGrafico',organizacion, httpOptions);
  }
}
