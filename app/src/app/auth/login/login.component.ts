import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private route: ActivatedRoute, private authService: AuthService) {
  }

  ngOnInit(): void {

  }

  isLoggedIn() {
    return this.authService.isLoggedIn();
  }

  public performLogin() {
    this.authService.login();
  }

  public performLogout() {
    this.authService.logout();
  }

}
