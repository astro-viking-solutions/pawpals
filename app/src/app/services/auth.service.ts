import {Injectable} from '@angular/core';
import {OAuthService, UserInfo} from 'angular-oauth2-oidc';
import {authCodeFlowConfig} from '../auth/auth-code-flow.config';
import {AuthUser} from '../domain/auth-user';
import {Subject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedIn = false;
  private authUserSource = new Subject<AuthUser>();

  authUser$ = this.authUserSource.asObservable();

  constructor(private oauthService: OAuthService) {
    console.log('AuthService constructor');
    this.oauthService.configure(authCodeFlowConfig);
    this.oauthService.loadDiscoveryDocumentAndTryLogin().then(_ => {
      const userInfo: UserInfo = this.oauthService.getIdentityClaims() as UserInfo;
      if (userInfo) {
        this.loggedIn = true;
        console.log('User authenticated: ' + userInfo.sub);
        const authUser: AuthUser = new AuthUser();

        authUser.email = userInfo.email;
        authUser.sub = userInfo.sub;
        authUser.givenName = userInfo.given_name;
        authUser.lastName = userInfo.family_name;

        this.authUserSource.next(authUser);
      }
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
    this.authUserSource.next(null);
    console.log('END: performLogout');
  }

}
