import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CrearCuentaComponent } from './crear-cuenta/crear-cuenta.component';
import { LoginActivate } from './guards/login-activate.service';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {
    path: 'auth',
    children: [
        {
            path: 'login',
            component: LoginComponent
        },
        {
            path: 'crearCuenta',
            component: CrearCuentaComponent
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
