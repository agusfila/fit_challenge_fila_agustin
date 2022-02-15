import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginActivate } from '../auth/guards/login-activate.service';
import { AssetComponent } from './asset/asset.component';
import { ComprarComponent } from './comprar/comprar.component';
import { DashboardComponent } from './dashboard.component';

const routes: Routes = [
  {
    path: 'dashboard',
    component: DashboardComponent,
    canActivate: [LoginActivate],
    children: [
      {
      path: 'comprar',
      component: ComprarComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
