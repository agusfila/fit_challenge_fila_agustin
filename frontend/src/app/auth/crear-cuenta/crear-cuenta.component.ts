import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BaseResponse } from 'src/shared/models/baseResponse.model';
import { CrearCuentaRequest } from 'src/shared/models/crearCuentaRequest.model';
import { AuthService } from 'src/shared/services/auth.service';

@Component({
  selector: 'app-crear-cuenta',
  templateUrl: './crear-cuenta.component.html',
  styleUrls: ['./crear-cuenta.component.css']
})
export class CrearCuentaComponent implements OnInit {
  pNombre:string        = '';
  pApellido:string      = '';
  pNombreUsuario:string = '';
  pMail:string          = '';
  pClave:string         = '';
  estadoError:boolean   = false;
  mensajeError:string   = '';

  constructor(private authService:AuthService, private router:Router) { }

  ngOnInit(): void {
  }

  crearCuenta(): void{
    let crearCuenta:CrearCuentaRequest  = new CrearCuentaRequest();
    crearCuenta.nombre                  = this.pNombre;
    crearCuenta.apellido                = this.pApellido;
    crearCuenta.mail                    = this.pMail;
    crearCuenta.nombreUsuario           = this.pNombreUsuario;
    crearCuenta.clave                   = this.pClave;
    this.authService.crearCuenta(crearCuenta).subscribe((res:BaseResponse) => {
      if(res.error){
        this.estadoError  = true;
        this.mensajeError = res.mensaje;
      } else {
        this.router.navigate(['/auth/login']);
      }
    });
  }

  iniciarSesion(){
    this.router.navigate(['/auth/login']);
  }

}
