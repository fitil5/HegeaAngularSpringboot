import {Injectable} from '@angular/core';
import {HttpClient, HttpRequest, HttpEvent, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';


const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class UploadFileService {

  constructor(private http: HttpClient) {}
 
  pushFileToStorage(file: File): Observable<HttpEvent<{}>> {
    let formdata: FormData = new FormData();

    formdata.append('file', file);

    const req = new HttpRequest('POST', 'http://localhost:8080/post', formdata, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.http.request(req);
  }

   getFiles(): Observable<string[]> {
     return this.http.get<string[]>('/getallfiles');
   }
   addExcel(Excel){
    return  this.http.post('http://localhost:8080/api/file/addExcel',Excel, httpOptions);
  }
}
