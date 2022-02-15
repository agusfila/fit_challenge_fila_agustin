import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Asset } from 'src/shared/models/asset.model';
import { BaseResponse } from 'src/shared/models/baseResponse.model';
import { CalcularPrecio } from 'src/shared/models/calcularPrecio.model';
import { CalcularPrecioResponse } from 'src/shared/models/calcularPrecioResponse.model';
import { Compra } from 'src/shared/models/compra.model';
import { Exchange } from 'src/shared/models/exchange.model';
import { NuevaCompra } from 'src/shared/models/nuevaCompra.model';
import { AssetService } from 'src/shared/services/asset.service';
import { CompraService } from 'src/shared/services/compra.service';
import { ExchangeService } from 'src/shared/services/exchange.service';

@Component({
  selector: 'app-comprar',
  templateUrl: './comprar.component.html',
  styleUrls: ['./comprar.component.css']
})
export class ComprarComponent implements OnInit {
  assets:Array<Asset>           = new Array<Asset>();//JSON.parse("[{\"asset_id\":\"USDT\",\"name\":\"Tether\",\"price_usd\":1.0005627264559007,\"rate_usd\":1.0006624756446927,\"url\":\"https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png\"},{\"asset_id\":\"MOM\",\"name\":\"MOM\",\"price_usd\":0.5602931908764668,\"rate_usd\":0.5603472883345807,\"url\":\"https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png\"},{\"asset_id\":\"BTC\",\"name\":\"Bitcoin\",\"price_usd\":42187.31914435228,\"rate_usd\":42263.34944048125,\"url\":\"https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png\"},{\"asset_id\":\"EXP\",\"name\":\"Expanse\",\"price_usd\":860198717.7879665,\"rate_usd\":859135911.0411863,\"url\":\"https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png\"},{\"asset_id\":\"USD\",\"name\":\"US Dollar\",\"price_usd\":0,\"rate_usd\":1,\"url\":\"https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/0a4185f21a034a7cb866ba7076d8c73b.png\"}]");
  exchanges:Array<Exchange>     = new Array<Exchange>();//JSON.parse('[{"exchange_id":"BITFOREX","website":"https://bitforex.com/","name":"BitForex","comision":0.25,"url":"https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/32a3ccb439ba4d20b995fd61194c5e18.png"},{"exchange_id":"BITTREX","website":"https://bittrex.com/","name":"Bittrex","comision":0.4,"url":"https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/430d0c2db3624ce983702b770293ed3e.png"},{"exchange_id":"BITMEX","website":"https://www.bitmex.com/","name":"BitMEX","comision":0.55,"url":"https://s3.eu-central-1.amazonaws.com/bbxt-static-icons/type-id/png_512/e36f2079c2f340399b58cec837879b74.png"}]');
  muestraExchanges:boolean      = false;
  puedeComprar:boolean          = false;
  pAsset:string                 = undefined;
  pExchange:string              = undefined;
  pCantidad:number              = undefined;
  pCantidadDolares:number       = undefined;
  pComision:number              = undefined;
  pValorUnitarioUSD:number      = undefined;
  mostrarDetalleCompra:boolean  = false;
  error:boolean                 = false;
  mensajeError:string           = undefined;
  nuevaCompra:NuevaCompra       = new NuevaCompra();

  constructor(private assetService:AssetService, private exchangeService:ExchangeService, private compraService:CompraService) { }
  
  ngOnInit(): void {
      this.assetService.listarAssets().subscribe(
        (assets:Array<Asset>) => {
            this.assets = assets;
        },
        (httpError:HttpErrorResponse) => {
            let error:BaseResponse  = httpError.error;
            this.error              = true;
            this.mensajeError       = error.mensaje;
        });
  }

  seleccionarAsset(asset_id:string){
      this.seleccionar(asset_id, 'asset');
      this.pAsset             = asset_id;
      this.muestraExchanges   = true;
      if(this.puedeComprar) this.setCantidad();
      this.pValorUnitarioUSD  = this.assets.filter(unAsset => unAsset.asset_id == this.pAsset)[0].rate_usd;
      if(this.exchanges.length == 0){
          this.exchangeService.listarExchanges().subscribe(
            (exchanges:Array<Exchange>) => {
                this.exchanges = exchanges;
            },
            (httpError:HttpErrorResponse) => {
                let error:BaseResponse  = httpError.error;
                this.error              = true;
                this.mensajeError       = error.mensaje;
            });
      }
  }

  seleccionarExchange(exchange_id:string){
      this.seleccionar(exchange_id, 'exchange');
      this.pExchange      = exchange_id;
      this.puedeComprar   = true;
      this.pComision      = this.exchanges.filter(unExchange => unExchange.exchange_id == this.pExchange)[0].comision;
  }

  seleccionar(id:string, clase:string){
      document.querySelectorAll('.' + clase).forEach(unAsset => {
          unAsset.classList.remove(clase + 'Seleccionado');
          unAsset.classList.add(clase + 'SinSeleccionar');
      });
      let assetSeleccionado = document.getElementById(id);
      assetSeleccionado.classList.add(clase + 'Seleccionado');
      assetSeleccionado.classList.remove(clase + 'SinSeleccionar');
  }

  setCantidad(){
      let calcularPrecio:CalcularPrecio = new CalcularPrecio();
      calcularPrecio.cantidad           = this.pCantidad;
      calcularPrecio.comision           = this.pComision;
      calcularPrecio.valorUnitarioUSD   = this.pValorUnitarioUSD;
      this.compraService.calcularPrecio(calcularPrecio).subscribe(
        (calcularPrecioResponse:CalcularPrecioResponse) => {
            this.pCantidadDolares               = calcularPrecioResponse.precioTotal;
            this.mostrarDetalleCompra           = true;
            this.nuevaCompra.idUsuario          = localStorage.getItem("idUsuario");
            this.nuevaCompra.asset_id           = this.pAsset;
            this.nuevaCompra.cantidad           = this.pCantidad;
            this.nuevaCompra.exchange_id        = this.pExchange;
            this.nuevaCompra.comision           = this.pComision;
            this.nuevaCompra.valorUnitarioUSD   = this.pValorUnitarioUSD;
            this.nuevaCompra.cantidadDolar      = this.pCantidadDolares;
        },
        (httpError:HttpErrorResponse) => {
            let error:BaseResponse  = httpError.error;
            this.error              = true;
            this.mensajeError       = error.mensaje;
        });
  }

}
