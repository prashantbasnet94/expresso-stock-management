import {Component, OnInit} from '@angular/core';
<<<<<<< HEAD
import {ExpressoService} from '../services/expresso.service';
import {ActivatedRoute} from '@angular/router';
import {StockQuote} from '../types/stockQuote';
=======
import {ExpressoService} from '../expresso.service';
import {ActivatedRoute} from '@angular/router';
>>>>>>> master

@Component({
  selector: 'app-detail-stock-info',
  templateUrl: './detail-stock-info.component.html',
  styleUrls: ['./detail-stock-info.component.scss']
})
export class DetailStockInfoComponent implements OnInit {

<<<<<<< HEAD
  stock: StockQuote[];
  pageLoaded = false;
  ticker: string;
  graphData: number[] = [];
  graphLabel: string[] = [];
  logo: string;
=======
  stock: any[];
  stockLoaded = false;

  constructor(private service: ExpressoService, private routes: ActivatedRoute) {
  }
>>>>>>> master

  constructor(private service: ExpressoService, private routes: ActivatedRoute) {
    this.ticker = this.routes.snapshot.params['ticker'];

<<<<<<< HEAD
    this.service.getStockByTicker(this.ticker).subscribe((data: StockQuote[]) => {
      this.stock = data;
      console.log(this.stock);
=======
    this.service.getStockByTicker(this.routes.snapshot.params['ticker']).subscribe((data: any[]) => {
      this.stock = data;
      this.stockLoaded = true;
>>>>>>> master
    });
    this.pageLoaded = true;
    this.service.getDataForGraph(this.ticker).subscribe((data: any[]) => {
      data.forEach((value) => {
        this.graphData.push(value.open);
        this.graphLabel.push(value.label);
      });
    });
    this.service.getLogo(this.ticker).subscribe((data: string) => {
      this.logo = data;
    });
  }

  ngOnInit() {

  }

}
