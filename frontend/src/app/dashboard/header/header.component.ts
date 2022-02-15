import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BaseResponse } from 'src/shared/models/baseResponse.model';
import { Usuario } from 'src/shared/models/usuario.model';
import { usuarioService } from 'src/shared/services/usuario.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  usuario:Usuario;
  estadoError:boolean = false;
  mensajeError:string = undefined;

  constructor(private usuarioService:usuarioService, private router:Router) { }

  ngOnInit(): void {
    this.usuarioService.buscarPorId(localStorage.getItem('idUsuario')).subscribe(
      (usuario:Usuario) => {
        this.usuario = usuario;
      },
      (httpError:HttpErrorResponse) => {
          let error:BaseResponse  = httpError.error;
          this.estadoError        = true;
          this.mensajeError       = error.mensaje;
      });
  }

  cerrarSesion(){
    localStorage.setItem("token", "");
    localStorage.setItem("idUsuario", "");
    this.router.navigate(['/auth/login']);
  }

}
