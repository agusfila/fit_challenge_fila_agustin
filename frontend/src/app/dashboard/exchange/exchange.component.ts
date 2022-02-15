import { Component, Input, OnInit } from '@angular/core';
import { Exchange } from 'src/shared/models/exchange.model';

@Component({
  selector: 'app-exchange',
  templateUrl: './exchange.component.html',
  styleUrls: ['./exchange.component.css']
})
export class ExchangeComponent implements OnInit {
  @Input('exchange') exchange:Exchange;

  constructor() { }
  ngOnInit(): void {
  }

}
