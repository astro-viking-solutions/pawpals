import {Component, OnInit} from '@angular/core';
import {AuthResponse} from '../domain/AuthResponse';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private route: ActivatedRoute) {
  }

  authDomain = 'pawpals.auth.us-east-1.amazoncognito.com';
  appClientId = '6rmdvqu0d8oqcv9r5ik55niihf';
  redirectUrl = 'http://localhost:4200/auth/login';

  authResponse = new AuthResponse();

  public isLoggedIn = false;

  ngOnInit(): void {
    this.route.fragment.subscribe(fragment => {
      const response = new URLSearchParams(fragment);
      this.authResponse.accessToken = response.get('access_token');
      this.authResponse.idToken = response.get('id_token');
      this.authResponse.expiresIn = +response.get('expires_in');
      this.authResponse.tokenType = response.get('token_type');
      console.log(this.authResponse);
    });
  }

}
