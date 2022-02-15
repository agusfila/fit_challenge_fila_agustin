import { Component, OnInit } from '@angular/core';
import { Asset } from 'src/shared/models/asset.model';
import { Compra } from 'src/shared/models/compra.model';
import { Exchange } from 'src/shared/models/exchange.model';
import { NuevaCompra } from 'src/shared/models/nuevaCompra.model';
import { AssetService } from 'src/shared/services/asset.service';
import { CompraService } from 'src/shared/services/compra.service';
import { ExchangeService } from 'src/shared/services/exchange.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  
    constructor() { 
    }
    ngOnInit(): void {
    }

}
