import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {AccountComponent} from './account/account.component';
import {ProfileComponent} from './account/profile/profile.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {
    path: 'account', component: AccountComponent,
    children: [
      {path: 'profile', component: ProfileComponent},
      {path: '', redirectTo: 'profile', pathMatch: 'full'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
