import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {FlexLayoutModule} from '@angular/flex-layout';
import { BannerComponent } from './banner/banner.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { InfoComponent } from './info/info.component';
import { HomeComponent } from './home/home.component';
import {AppRoutingModule} from './app.routing.module';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    BannerComponent,
    NavBarComponent,
    InfoComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    RouterModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
