import {Component, OnInit} from '@angular/core';
import {ProfileService} from '../services/profile.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  constructor(private profileService: ProfileService, private router: Router) {
  }

  ngOnInit(): void {
    this.profileService.getProfile().subscribe(data => {
      console.log(data);
    }, error => {
      console.log(error);
      if (error.status === 404) {
        console.log('Profile not found!');
        this.router.navigate(['/account/profile/create']).then(r => {});
      }
    });
  }

}
