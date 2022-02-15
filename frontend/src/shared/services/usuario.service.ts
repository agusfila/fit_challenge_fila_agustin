import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { BaseService } from "./baseService.service";
import { Usuario } from "../models/usuario.model";
import { Observable } from "rxjs";
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class usuarioService extends BaseService{
    constructor(private _http: HttpClient){
        super('/usuarios');
    }

    buscarPorId(idUsuario:string):Observable<Usuario>{
        return this._http.get<Usuario>(this.apiUrl + '/' + idUsuario, this.getHeaderTokenOptions());
    }
}