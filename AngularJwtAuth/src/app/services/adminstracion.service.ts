import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';
import { Usuario } from '../modelos/Usuario.models';
import { ActivatedRoute, Router } from '@angular/router';

 const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  
};
@Injectable({
  providedIn: 'root'
})
export class AdminstracionService {

  private endpoint:string = 'http://localhost:8080/api/';
  constructor(private http: HttpClient) {};
  getUsuarios(): Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.endpoint+'usuarios');
  }
  //updateUsuario (usuario){
   // console.log(usuario.username);
    //return this.http.post(this.endpoint + 'editusuario' , usuario, httpOptions)
  //}
  updateUsuario (usuario): Observable<Usuario> {
    return this.http.post<Usuario>(this.endpoint + 'editusuario' , usuario, httpOptions)
  }
  deleteUsuario (id:number): Observable<string> {
    return this.http.post<string>(this.endpoint + 'deleteUsuario/' + id, httpOptions)
  }
  
  
}
