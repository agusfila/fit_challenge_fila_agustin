import { HttpErrorResponse } from '@angular/common/http';
import { Component, Input, OnChanges, OnInit } from '@angular/core';
import { BaseResponse } from 'src/shared/models/baseResponse.model';
import { Compra } from 'src/shared/models/compra.model';
import { CompraResponse } from 'src/shared/models/compraResponse.model';
import { NuevaCompra } from 'src/shared/models/nuevaCompra.model';
import { CompraService } from 'src/shared/services/compra.service';

@Component({
  selector: 'app-modal-detalle-compra',
  templateUrl: './modal-detalle-compra.component.html',
  styleUrls: ['./modal-detalle-compra.component.css']
})
export class ModalDetalleCompraComponent implements OnInit {
  @Input('nuevaCompra') nuevaCompra:NuevaCompra;
  public muestraSuccess:boolean = false;
  public muestraError:boolean   = false;
  public mensaje:string         = undefined;

  constructor(private compraService:CompraService) { 
  }

  ngOnInit(): void {
  }

  comprarAsset(){
      this.compraService.comprar(this.nuevaCompra).subscribe(
        (compraResponse:CompraResponse) => {
          this.muestraSuccess     = true;
          this.muestraError       = false;
          this.mensaje            = compraResponse.mensaje;
        },
        (httpError:HttpErrorResponse) => {
            let error:BaseResponse  = httpError.error;
            this.muestraError       = true;
            this.muestraSuccess     = false;
            this.mensaje            = error.mensaje;
        });
  }

}
