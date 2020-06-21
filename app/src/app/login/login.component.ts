import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor() { }

  private appClientId = '6rmdvqu0d8oqcv9r5ik55niihf';
  public isLoggedIn = false;

  ngOnInit(): void {
  }

}
