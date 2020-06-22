import { Injectable } from '@angular/core';
import {GeoState} from '../domain/geo-state';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PetBreed} from '../domain/pet-breed';

@Injectable({
  providedIn: 'root'
})
export class DomainService {

  constructor(private http: HttpClient) { }

  public getGeoStates(): Observable<GeoState[]> {
    return this.http.get<GeoState[]>('http://localhost:8080/domain/states');
  }

  public getPetBreed(): Observable<PetBreed> {
    return this.http.get<PetBreed>('http://localhost:8080/domain/breeds');
  }
}
