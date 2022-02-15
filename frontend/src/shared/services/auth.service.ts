import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { BaseService } from "./baseService.service";
import { InicioSesionRequest } from "../models/inicioSesionRequest.model";
import { CrearCuentaRequest } from "../models/crearCuentaRequest.model";
import { BaseResponse } from "../models/baseResponse.model";

@Injectable({
    providedIn: 'root'
})
export class AuthService extends BaseService{
    constructor(private _http: HttpClient){
        super('/auth');
    }

    iniciarSesion(inicioSesionReq:InicioSesionRequest){
        return this._http.post<BaseResponse>(this.apiUrl + '/login', inicioSesionReq, this.getHeaderOptions());
    }

    crearCuenta(crearCuentaReq:CrearCuentaRequest){
        return this._http.post<BaseResponse>(this.apiUrl + '/crear_cuenta', crearCuentaReq, this.getHeaderOptions());
    }

    validarToken(){
        let token = localStorage.getItem('token') ? localStorage.getItem('token') : 'vacio';
        return this._http.post<boolean>(this.apiUrl + '/validar_token', token, this.getHeaderOptions());
    }
}