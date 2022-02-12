import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";

export class BaseService {
    apiUrl = environment.API_URL;
    constructor(private partialUrl:string){
        this.apiUrl += partialUrl;
    }

    getHeaderOptions(){
        let options = {
            headers : {
                'Content-Type': 'application/json'
            }
        }
        return options;
    }
}