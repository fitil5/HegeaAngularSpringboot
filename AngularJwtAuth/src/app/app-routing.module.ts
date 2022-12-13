import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { AdministracionComponent } from './administracion/administracion.component';
import { EditUsuarioComponent } from './administracion/edit-usuario/edit-usuario.component';
import { FormUploadComponent } from './upload/form-upload/form-upload.component';
import { ErroresExcelComponent } from './upload/errores-excel/errores-excel.component';
import { ViewExcelComponent } from './upload/view-excel/view-excel.component';
import { DiaactividadComponent } from './auth/AdministracionFechaActividad/diaactividad/diaactividad.component';
import { BorrarFechaActividadComponent } from './auth/AdministracionFechaActividad/borrar-fecha-actividad/borrar-fecha-actividad.component';
import { AltaActividadComponent } from './auth/AdministracionFechaActividad/alta-actividad/alta-actividad.component';
import { PasswordComponent } from './administracion/password/password.component';
import { ActividadComponent } from './actividad/actividad.component';
import { RegistradosComponent } from './registrados/registrados.component';
import { MapComponent } from './map/map.component';



const routes: Routes = [
    
    
    
    {
        path: 'auth/login',
        component: LoginComponent
    },
    {
        path: 'signup',
        component: RegisterComponent
    },
    {
        path: 'administracion',
        component: AdministracionComponent
    },{
        path: 'editUsuario',
        component: EditUsuarioComponent
    },{
        path: 'upload',
        component: FormUploadComponent
    },{
        path: 'erroresupload',
        component: ErroresExcelComponent
    },{
        path: 'viewexcel',
        component: ViewExcelComponent
    },{
        path: 'dias',
        component: DiaactividadComponent
    },{
        path: 'borrarFechaActividad',
        component: BorrarFechaActividadComponent
    },{
        path: 'altaActividad',
        component: AltaActividadComponent
    },{
        path: 'confirmPassword',
        component: PasswordComponent
    },    {
        path: 'actividad',
        component: ActividadComponent
    },{
        path: 'registrados',
        component: RegistradosComponent
    },{
        path: 'map',
        component: MapComponent
    },
    {
        path: '',
        redirectTo: 'auth/login',
        pathMatch: 'full'
    }
    
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
