import { Component, OnInit } from '@angular/core';
import {DomainService} from '../services/domain.service';
import {GeoState} from '../domain/geo-state';
import {PetBreed} from '../domain/pet-breed';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  states: GeoState[];
  breeds: PetBreed;

  constructor(private domainService: DomainService) { }

  ngOnInit(): void {
    this.domainService.getGeoStates().subscribe(data => {
      this.states = data;
      // console.log(this.states);
    });

    this.domainService.getPetBreed().subscribe(data => {
      this.breeds = data;
      // console.log(this.breeds);
    });
  }

}
