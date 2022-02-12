import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { BaseService } from "./baseService.service";
import { Exchange } from "../models/exchange.model";

@Injectable({
    providedIn: 'root'
})
export class ExchangeService extends BaseService{
    constructor(private _http: HttpClient){
        super('/exchanges');
    }

    listarExchanges(){
        return this._http.get<Array<Exchange>>(this.apiUrl + '/listar', this.getHeaderOptions());
    }
}