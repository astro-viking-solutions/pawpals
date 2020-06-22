import {Injectable, OnInit} from '@angular/core';
import {OAuthService, UserInfo} from 'angular-oauth2-oidc';
import {authCodeFlowConfig} from '../auth/auth-code-flow.config';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedIn = false;

  constructor(private oauthService: OAuthService) {
    console.log('AuthService constructor');
    this.oauthService.configure(authCodeFlowConfig);
    this.oauthService.loadDiscoveryDocumentAndTryLogin().then(_ => {
      console.log('User logged in.');
      const userInfo: UserInfo = this.oauthService.getIdentityClaims() as UserInfo;
      this.loggedIn = true;
      console.log('sub: ' + userInfo.sub);
      console.log('email: ' + userInfo.email);
    });
  }

  isLoggedIn() {
    return this.loggedIn;
  }

  login() {
    console.log('START: performLogin');
    this.oauthService.initCodeFlow();
    console.log('END: performLogin');
  }

  logout() {
    console.log('START: performLogout');
    this.oauthService.logOut();
    this.loggedIn = false;
    console.log('END: performLogout');
  }

}
