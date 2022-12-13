import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';


import { httpInterceptorProviders } from './auth/auth-interceptor';
import { AdministracionComponent } from './administracion/administracion.component';
import { EditUsuarioComponent } from './administracion/edit-usuario/edit-usuario.component';
import { DataService } from './services/data.service';
import {UsernameFilterPipe} from './administracion/username-filter.pipe';
import {MatNativeDateModule} from '@angular/material/core';
import { FormUploadComponent } from './upload/form-upload/form-upload.component';
import { UploadFileService } from './services/upload-file.service';
import { ViewExcelComponent } from './upload/view-excel/view-excel.component';
import { ErroresExcelComponent } from './upload/errores-excel/errores-excel.component';

import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import {MatButtonToggleModule} from '@angular/material/button-toggle';

import { DiaactividadComponent } from './auth/AdministracionFechaActividad/diaactividad/diaactividad.component';
import { BorrarFechaActividadComponent } from './auth/AdministracionFechaActividad/borrar-fecha-actividad/borrar-fecha-actividad.component';
import { AltaActividadComponent } from './auth/AdministracionFechaActividad/alta-actividad/alta-actividad.component';
import { RegisterComponent } from './register/register.component';
import { PasswordComponent } from './administracion/password/password.component';
import { ActividadComponent } from './actividad/actividad.component';
import { RegistradosComponent } from './registrados/registrados.component';
import { MapComponent } from './map/map.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,    
    RegisterComponent,
    AdministracionComponent,
    EditUsuarioComponent,
    UsernameFilterPipe,
    FormUploadComponent,
    ViewExcelComponent,
    ErroresExcelComponent,
    DiaactividadComponent,
    BorrarFechaActividadComponent,
    AltaActividadComponent,
    PasswordComponent,
    ActividadComponent,
    RegistradosComponent,
    MapComponent

       
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
    MatSlideToggleModule,
    MatButtonToggleModule
    
    
  ],
  providers: [httpInterceptorProviders,DataService,UploadFileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
