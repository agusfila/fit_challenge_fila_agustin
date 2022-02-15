import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DashboardRoutingModule } from './dashboard-routing.module';
import { AssetComponent } from './asset/asset.component';
import { ExchangeComponent } from './exchange/exchange.component';
import { BrowserModule } from '@angular/platform-browser';
import { DashboardComponent } from './dashboard.component';
import { HeaderComponent } from './header/header.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ComprarComponent } from './comprar/comprar.component';
import { ModalDetalleCompraComponent } from './modal-detalle-compra/modal-detalle-compra.component';


@NgModule({
  declarations: [
    AssetComponent,
    ExchangeComponent,
    DashboardComponent,
    HeaderComponent,
    ComprarComponent,
    ModalDetalleCompraComponent
  ],
  imports: [
    CommonModule,
    DashboardRoutingModule,
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class DashboardModule { }
