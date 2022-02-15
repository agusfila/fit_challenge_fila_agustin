import { Component, Input, OnInit } from '@angular/core';
import { Asset } from 'src/shared/models/asset.model';

@Component({
  selector: 'app-asset',
  templateUrl: './asset.component.html',
  styleUrls: ['./asset.component.css']
})
export class AssetComponent implements OnInit {
  @Input('asset') asset:Asset;
  constructor() { }

  ngOnInit(): void {
  }

}
