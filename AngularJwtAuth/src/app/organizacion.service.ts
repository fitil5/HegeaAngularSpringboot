import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Organizacion } from './modelos/Organizacion';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  
};
@Injectable({
  providedIn: 'root'
})
export class OrganizacionService {

  private endpoint:string = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) {};
  getOrganizacion(): Observable<Organizacion[]> {
    return this.http.get<Organizacion[]>(this.endpoint+'getOrganizacion');
  }
  addOrganizacion(organizacion): Observable<Organizacion> {
    return this.http.post<Organizacion>(this.endpoint + 'addOrganizacion' ,organizacion, httpOptions)
  }
  deleteOrganizacion (id:string): Observable<string> {
    return this.http.post<string>(this.endpoint + 'deleteOrganizacion/' + id, httpOptions)
  }
}
