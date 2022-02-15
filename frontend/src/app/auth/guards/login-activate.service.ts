import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { AuthService } from "src/shared/services/auth.service";
import { catchError, tap } from 'rxjs/operators';

@Injectable()
export class LoginActivate implements CanActivate {
    constructor(private authService:AuthService, private router:Router){}
    canActivate() {
        return this.authService.validarToken()
        .pipe(
            tap((res:boolean) => { 
                if(!res) {
                    this.router.navigate(['auth/login']);
                }
            })
        )
    }
}