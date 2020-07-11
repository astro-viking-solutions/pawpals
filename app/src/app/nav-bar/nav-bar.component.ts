import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AuthService} from '../services/auth.service';
import {AuthUser} from '../domain/auth-user';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  @Output() navToggle: EventEmitter<any> = new EventEmitter<any>();

  authUser: AuthUser;

  constructor(private authService: AuthService) {
    authService.authUser$.subscribe(user => {
      this.authUser = user;
    });
  }

  ngOnInit(): void {
  }

  showNav() {
    this.navToggle.emit();
  }

  login() {
    this.authService.login();
  }

  logout() {
    this.authService.logout();
  }

}
