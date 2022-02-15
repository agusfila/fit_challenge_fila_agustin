import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { BaseService } from "./baseService.service";
import { NuevaCompra } from "../models/nuevaCompra.model";
import { Compra } from "../models/compra.model";
import { Observable } from "rxjs";
import { map } from 'rxjs/operators';
import { CalcularPrecio } from "../models/calcularPrecio.model";

@Injectable({
    providedIn: 'root'
})
export class CompraService extends BaseService{
    constructor(private _http: HttpClient){
        super('/compras');
    }

    comprar(compra:NuevaCompra): Observable<Compra>{
        return this._http.post<Compra>(this.apiUrl + '/comprar', compra, this.getHeaderTokenOptions());
    }

    calcularPrecio(calcularPrecio:CalcularPrecio): Observable<number>{
        return this._http.post<number>(this.apiUrl + '/calcularPrecioUSD', calcularPrecio, this.getHeaderTokenOptions());
    }

    listarCompras(idUsuario:string): Observable<Array<Compra>>{
        return this._http.post<Array<Compra>>(this.apiUrl + '/' + idUsuario, this.getHeaderTokenOptions());
    }
}