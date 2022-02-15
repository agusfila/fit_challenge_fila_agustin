import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { AuthRoutingModule } from './auth-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { CrearCuentaComponent } from './crear-cuenta/crear-cuenta.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginActivate } from './guards/login-activate.service';



@NgModule({
  declarations: [
    LoginComponent,
    CrearCuentaComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [LoginActivate]
})
export class AuthModule { }
