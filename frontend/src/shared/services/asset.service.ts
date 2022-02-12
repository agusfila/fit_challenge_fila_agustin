import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { environment } from "src/environments/environment";
import { map } from 'rxjs/operators';
import { BaseService } from "./baseService.service";
import { Asset } from "../models/asset.model";

@Injectable({
    providedIn: 'root'
})
export class AssetService extends BaseService{
    constructor(private _http: HttpClient,){
        super('/assets');
    }

    listarAssets(){
        return this._http.get<Array<Asset>>(this.apiUrl + '/listar', this.getHeaderOptions());
    }
}