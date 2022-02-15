import { Component, Input, OnInit } from '@angular/core';
import { Compra } from 'src/shared/models/compra.model';

@Component({
  selector: 'app-modal-detalle-compra',
  templateUrl: './modal-detalle-compra.component.html',
  styleUrls: ['./modal-detalle-compra.component.css']
})
export class ModalDetalleCompraComponent implements OnInit {
  @Input('asset') compra:Compra;

  constructor() { 
  }

  ngOnInit(): void {
  }

}
