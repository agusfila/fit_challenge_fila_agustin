import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { BaseService } from "./baseService.service";
import { Asset } from "../models/asset.model";
import { Observable } from "rxjs";
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class AssetService extends BaseService{
    constructor(private _http: HttpClient){
        super('/assets');
    }

    listarAssets(): Observable<Array<Asset>>{
        return this._http.get<Array<Asset>>(this.apiUrl + '/listar', this.getHeaderTokenOptions());
    }
}