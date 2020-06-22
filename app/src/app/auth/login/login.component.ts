import {Component, OnInit} from '@angular/core';
import {AuthResponse} from '../domain/AuthResponse';
import {ActivatedRoute} from '@angular/router';
import {OAuthService} from 'angular-oauth2-oidc';
import {authCodeFlowConfig} from '../auth-code-flow.config';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private route: ActivatedRoute, private authService: AuthService) {
  }

  public isLoggedIn = false;
  public email;

  ngOnInit(): void {

  }

  public performLogin() {
    this.authService.login();
  }

  public performLogout() {
    this.authService.logout();
  }

}
