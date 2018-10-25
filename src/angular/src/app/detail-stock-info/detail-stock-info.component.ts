import {Component, OnInit} from '@angular/core';
import {ExpressoService} from '../services/expresso.service';
import {ActivatedRoute, Router} from '@angular/router';
import { Quote } from '../types/quote';
import { StockDetail } from '../types/stock-details';
import { News } from '../types/news';
import {CompanyInfo} from '../types/company-info';

@Component({
  selector: 'app-detail-stock-info',
  templateUrl: './detail-stock-info.component.html',
  styleUrls: ['./detail-stock-info.component.scss']
})
export class DetailStockInfoComponent implements OnInit {

  stock: Quote[];
  pageLoaded = false;
  ticker: string;
  graphDataLow: number[] = [];
  graphDataHigh: number[] = [];
  graphLabel: string[] = [];
  news: News[];
  company: CompanyInfo[];
  tags: string[];

  constructor(private service: ExpressoService, private routes: ActivatedRoute, private router: Router) {

    this.ticker = this.routes.snapshot.params['ticker'];
  }

  ngOnInit() {
    this.service.getDataForGraph(this.ticker).subscribe((data: StockDetail[]) => {
      this.stock = data['quote'];
      this.news = data['news'];
      console.log(data);
      data['chart'].forEach((value) => {
        if(value.marketAverage !== -1) {
          this.graphDataLow.push(value.marketAverage);
          // this.graphDataHigh.push(value.marketLow);
          this.graphLabel.push(value.label);
          this.pageLoaded = true;
        }

      });
    });

    this.service.getCompanyInfo(this.ticker).subscribe((data: CompanyInfo[]) => {
      this.company = data;
      this.tags = data['tags'];
      console.log(data);
    });
  }

  addToWatchlist() {
    this.service.addStockToWatchList(this.ticker)
      .then(() => {
        this.router.navigate(['watchlist']);
      });
  }

}
