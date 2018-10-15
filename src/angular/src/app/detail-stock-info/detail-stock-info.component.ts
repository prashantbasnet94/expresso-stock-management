import { Component, OnInit } from '@angular/core';
import {ExpressoService} from '../expresso.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-detail-stock-info',
  templateUrl: './detail-stock-info.component.html',
  styleUrls: ['./detail-stock-info.component.scss']
})
export class DetailStockInfoComponent implements OnInit {

  stock: any[];
  constructor(private service: ExpressoService, private routes: ActivatedRoute) { }

  ngOnInit() {

    this.service.getStockByTicker(this.routes.snapshot.params['ticker']).subscribe((data: any[])=>{
       this.stock = data;
      console.log(this.stock);
    });
  }

}
