import { Component, OnInit } from '@angular/core';
import { Password } from 'src/app/modelos/Password';

@Component({
  selector: 'app-password',
  templateUrl: './password.component.html',
  styleUrls: ['./password.component.css']
})
export class PasswordComponent implements OnInit {
password:Password
  constructor() { }

  ngOnInit() {
  }
  onSubmit() {

  }

}
