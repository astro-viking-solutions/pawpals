import { Component, OnInit } from '@angular/core';
import {AuthService} from '../services/auth.service';
import {AuthUser} from '../domain/auth-user';

@Component({
  selector: 'app-banner',
  templateUrl: './banner.component.html',
  styleUrls: ['./banner.component.css']
})
export class BannerComponent implements OnInit {

  authUser: AuthUser;

  constructor(private authService: AuthService) {
    authService.authUser$.subscribe(user => {
      this.authUser = user;
    });
  }

  ngOnInit(): void {
  }

  login() {
    this.authService.login();
  }

  logout() {
    this.authService.logout();
  }

}
