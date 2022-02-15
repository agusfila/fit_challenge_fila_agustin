import { BaseResponse } from "./baseResponse.model";

export class InicioSesionResponse extends BaseResponse{
    public token:string;
    public idUsuario:string;
}