import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/shared/models/usuario.model';
import { usuarioService } from 'src/shared/services/usuario.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  usuario:Usuario;

  constructor(private usuarioService:usuarioService, private router:Router) { }

  ngOnInit(): void {
    this.usuarioService.buscarPorId(localStorage.getItem('idUsuario')).subscribe((usuario:Usuario) => {
      this.usuario = usuario;
    });
  }

  cerrarSesion(){
    localStorage.setItem("token", "");
    localStorage.setItem("idUsuario", "");
    this.router.navigate(['/auth/login']);
  }

}
