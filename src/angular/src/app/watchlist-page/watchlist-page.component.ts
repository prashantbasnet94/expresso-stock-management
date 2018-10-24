import {Component, OnInit} from '@angular/core';
import {Stock} from '../types/stock';
<<<<<<< HEAD
import {ExpressoService} from '../services/expresso.service';
import {Router} from '@angular/router';
=======
import {ExpressoService} from '../expresso.service';
>>>>>>> master

@Component({
  selector: 'app-watchlist-page',
  templateUrl: './watchlist-page.component.html',
  styleUrls: ['./watchlist-page.component.scss']
})
export class WatchlistPageComponent implements OnInit {

<<<<<<< HEAD
  stocks: Stock[] = [];
  watchlist: Stock[];
  searchResults: Stock[] = [];
  searchInput = '';
  showDropDown = false;
  tickerToAdd = 'Hello';
  logoUrl = '';

  constructor(private expressoService: ExpressoService, private router: Router) {
  }

  ngOnInit() {
    this.expressoService.getStocks().subscribe((data: Stock[]) => {
      this.stocks = data;
    });
  }

  searchStock($event: Event) {
    this.searchInput = $event.srcElement['value'].toString().toLocaleLowerCase();
    this.searchResults = this.stocks.filter((stock: Stock) => {
      return stock.name.toLocaleLowerCase().includes(this.searchInput);
    });
  }

  addStockToWatchlist() {
    this.expressoService.addStockToWatchList(this.tickerToAdd).subscribe((data: Stock[]) => {
      this.watchlist = data;
      console.log(this.watchlist);
    });
  }

  toggleDropDown() {
    this.showDropDown = !this.showDropDown;
  }

  setTicker(ticker) {
    this.tickerToAdd = ticker;
    this.toggleDropDown();
  }

  // getLogo(ticker) {
  //   return this.expressoService.getCompanyLogo(ticker).subscribe((data: string) => {
  //     this.logoUrl = data;
  //   });
  // }
=======
  stocks: Stock[];
  searchResults: Stock[] = [];
  searchInput = '';
  showDropDown = false;

  constructor(private expressoService: ExpressoService) {
  }

  ngOnInit() {
    this.expressoService.getStocks()
      .subscribe((data: Stock[]) => {
          this.stocks = data;
          console.log(this.stocks);
        },
        (error) => {
          console.log(error);
        });
  }

  searchStock($event: Event) {
    this.searchInput = $event.srcElement['value'].toString().toLocaleLowerCase();
    this.searchResults = this.stocks.filter((stock: Stock) => {
      return stock.name.toLocaleLowerCase().includes(this.searchInput);
    });
    console.log(this.searchResults);
  }

  addStockToWatchlist() {
    console.log();
  }

  toggleDropDown() {
    this.showDropDown = !this.showDropDown;
  }

  setSearchParams(name) {
    this.searchInput = name;
  }
>>>>>>> master
}
