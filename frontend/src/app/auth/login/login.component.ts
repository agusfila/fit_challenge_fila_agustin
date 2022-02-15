import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/shared/services/auth.service';
import { Router } from '@angular/router';
import { BaseResponse } from 'src/shared/models/baseResponse.model';
import { InicioSesionRequest } from 'src/shared/models/inicioSesionRequest.model';
import { AssetService } from 'src/shared/services/asset.service';
import { Asset } from 'src/shared/models/asset.model';
import { InicioSesionResponse } from 'src/shared/models/inicioSesionResponse.model';

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

  constructor(private authService:AuthService, private router:Router) { 
  }

  ngOnInit(): void {
  }

  iniciarSesion(): void{
    let inicioSesion:InicioSesionRequest  = new InicioSesionRequest();
    inicioSesion.clave                    = this.pClave;
    inicioSesion.nombreUsuario            = this.pNombreUsuario;
    this.authService.iniciarSesion(inicioSesion).subscribe((res:InicioSesionResponse) => {
      if(res.error){
        this.estadoError  = true;
        this.mensajeError = res.mensaje;
      } else {
        localStorage.setItem('token', res.token);
        localStorage.setItem('idUsuario', res.idUsuario);
        this.router.navigate(['/dashboard/comprar']);
      }
    });
  }

}
