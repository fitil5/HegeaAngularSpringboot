import { Component, OnInit } from '@angular/core';

import { AuthService } from '../auth/auth.service';
import { SignUpInfo } from '../auth/signup-info';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  form: any = {};
  signupInfo: SignUpInfo;
  
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) { }
  value: string;
  viewValue: string;
  ngOnInit() { 
    //this.form.role='admin'
  }
 
  onSubmit() {
    console.log(this.form);
    this.signupInfo = new SignUpInfo(
      this.form.name,
      this.form.username,
      this.form.email,
      this.form.role,
      this.form.enabled);

    this.authService.signUp(this.signupInfo).subscribe(
      data => {
        console.log(data);
       
        this.isSignUpFailed = false;
        this.redireccion()
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
  redireccion(){
    this.router.navigate(['/administracion'])
  }
  
  roles = [
    { key : 'admin' , value : 'admin' },
    { key : 'user' , value : 'user' },
    { key : 'pm' , value : 'pm' },  

  ]
  enable = [
    { key : 'true' , value : 'true' },
    { key : 'false' , value : 'false' },
      

  ]
 
  
}
