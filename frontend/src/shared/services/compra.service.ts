import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { BaseService } from "./baseService.service";
import { NuevaCompra } from "../models/nuevaCompra.model";
import { Compra } from "../models/compra.model";
import { Observable } from "rxjs";
import { map } from 'rxjs/operators';
import { CalcularPrecio } from "../models/calcularPrecio.model";
import { CompraResponse } from "../models/compraResponse.model";
import { CalcularPrecioResponse } from "../models/calcularPrecioResponse.model";

@Injectable({
    providedIn: 'root'
})
export class CompraService extends BaseService{
    constructor(private _http: HttpClient){
        super('/compras');
    }

    comprar(compra:NuevaCompra): Observable<CompraResponse>{
        return this._http.post<CompraResponse>(this.apiUrl + '/comprar', compra, this.getHeaderTokenOptions());
    }

    calcularPrecio(calcularPrecio:CalcularPrecio): Observable<CalcularPrecioResponse>{
        return this._http.post<CalcularPrecioResponse>(this.apiUrl + '/calcularPrecioUSD', calcularPrecio, this.getHeaderTokenOptions());
    }
}