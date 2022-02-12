import { Component, OnInit } from '@angular/core';
import { Asset } from 'src/shared/models/asset.model';
import { Exchange } from 'src/shared/models/exchange.model';
import { AssetService } from 'src/shared/services/asset.service';
import { ExchangeService } from 'src/shared/services/exchange.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  

  constructor(public assetService:AssetService, public exchangeService:ExchangeService) { 
    console.log('HOLA')
  }

  ngOnInit(): void {
    this.assetService.listarAssets().subscribe((assets:Array<Asset>) => {
      console.log(assets);
    });
    this.exchangeService.listarExchanges().subscribe((exchanges:Array<Exchange>) => {
      console.log(exchanges);
    });
  }

}
