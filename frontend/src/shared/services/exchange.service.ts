import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { BaseService } from "./baseService.service";
import { Exchange } from "../models/exchange.model";
import { map } from 'rxjs/operators';
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class ExchangeService extends BaseService{
    constructor(private _http: HttpClient){
        super('/exchanges');
    }

    listarExchanges(): Observable<Array<Exchange>>{
        return this._http.get<Array<Exchange>>(this.apiUrl + '/listar', this.getHeaderTokenOptions());
    }
}