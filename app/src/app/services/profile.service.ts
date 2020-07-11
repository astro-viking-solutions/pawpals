import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {UserProfile} from '../domain/user-profile';
@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  constructor(private http: HttpClient) { }

  public getProfile(): Observable<UserProfile> {
    return this.http.get<UserProfile>('http://localhost:8080/user/profile');
  }

  public createProfile(userProfile: UserProfile): Observable<any> {
    console.log('Create');
    console.log(userProfile);
    return this.http.post('http://localhost:8080/user/profile', userProfile);
  }

  public updateProfile(userProfile: UserProfile): Observable<any> {
    return this.http.put('http://localhost:8080/user/profile', userProfile);
  }
}
