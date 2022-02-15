import { HttpClient, HttpHeaders } from "@angular/common/http";
import { environment } from "src/environments/environment";

export class BaseService {
    apiUrl = environment.API_URL;
    constructor(private partialUrl:string){
        this.apiUrl += partialUrl;
    }

    getHeaderOptions(){
        let options = {
            headers : new HttpHeaders({
                'Content-Type': 'application/json'
            })
        }
        return options;
    }

    getHeaderTokenOptions(){
        let options = {
            headers : new HttpHeaders({
                'Content-Type': 'application/json',
                'Authorization': localStorage.getItem('token')
            })
        }
        return options;

    }
}