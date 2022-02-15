import { Usuario } from "./usuario.model";

export class Compra{
    public id:string;
    public usuario: Usuario;
    public assetId:string;
    public exchangeId:string;
    public comisionTotal:number;
    public cantidad:number;
    public costoTotal:number;
    public valorUnitarioUSD:number;
    public fecha:string;
}