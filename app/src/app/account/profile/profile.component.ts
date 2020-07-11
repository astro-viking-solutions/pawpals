import {Component, OnInit} from '@angular/core';
import {ProfileService} from '../../services/profile.service';
import {FormControl, FormGroup} from '@angular/forms';
import {UserProfile} from '../../domain/user-profile';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private profileService: ProfileService, private snackBar: MatSnackBar) {
  }

  private isNew = true;

  profileForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl('')
  });

  ngOnInit(): void {
    this.profileService.getProfile().subscribe(data => {
        this.profileForm.setValue(data);
        this.isNew = false;
      },
      error => {
        console.log(error);
      });
  }

  onSubmit() {
    if (this.isNew) {
      this.profileService.createProfile(this.profileForm.value).subscribe(data => {
        this.snackBar.open('Profile successfully created.', 'Dismiss', {
          duration: 3000,
        });
      });
    } else {
      this.profileService.updateProfile(this.profileForm.value).subscribe(data => {
        this.snackBar.open('Profile successfully updated.', 'Dismiss', {
          duration: 3000,
        });
      });
    }
  }

}
