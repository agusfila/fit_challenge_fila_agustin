import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/shared/services/auth.service';
import { Router } from '@angular/router';
import { InicioSesionRequest } from 'src/shared/models/inicioSesionRequest.model';
import { InicioSesionResponse } from 'src/shared/models/inicioSesionResponse.model';
import { BaseResponse } from 'src/shared/models/baseResponse.model';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  estadoError:boolean   = false;
  mensajeError:string   = '';
  pNombreUsuario:string = '';
  pClave:string         = '';
  creoCuenta:boolean    = false;

  constructor(private authService:AuthService, private router:Router) { 
    this.creoCuenta = (this.router.getCurrentNavigation().extras.state) ? this.router.getCurrentNavigation().extras.state.creoCuenta: false;
  }

  ngOnInit(): void {
  }

  iniciarSesion(): void{
    let inicioSesion:InicioSesionRequest  = new InicioSesionRequest();
    inicioSesion.clave                    = this.pClave;
    inicioSesion.nombreUsuario            = this.pNombreUsuario;
    this.authService.iniciarSesion(inicioSesion).subscribe(
      (res:InicioSesionResponse) => {
          localStorage.setItem('token', res.token);
          localStorage.setItem('idUsuario', res.idUsuario);
          this.router.navigate(['/dashboard/comprar']);
      },
      (httpError:HttpErrorResponse) => {
          let error:BaseResponse  = httpError.error;
          this.estadoError        = true;
          this.mensajeError       = error.mensaje;
      });
  }

}
