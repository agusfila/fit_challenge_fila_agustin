import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthComponent } from './auth.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: 'auth',
    component: LoginComponent,
    children: [
        {
            path: 'login',
            component: LoginComponent
        }
    ]
  }
];

@NgModule({
    declarations: [],
    imports: [
        RouterModule.forChild(routes)
    ],
    exports: [RouterModule]
})
export class AuthRoutingModule { }
