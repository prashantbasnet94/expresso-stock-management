import {Component, OnInit} from '@angular/core';
import {Stock} from '../types/stock';
import {ExpressoService} from '../services/expresso.service';
import {Router} from '@angular/router';
import {forEach} from '@angular/router/src/utils/collection';
import {SorterService} from '../services/sorter.service';

@Component({
  selector: 'app-watchlist-page',
  templateUrl: './watchlist-page.component.html',
  styleUrls: ['./watchlist-page.component.scss']
})
export class WatchlistPageComponent implements OnInit {

  stocks: Stock[] = [];
  watchlist: Stock[];
  searchResults: Stock[] = [];
  searchInput = '';
  showDropDown = false;
  tickerToAdd = 'Hello';
  noOfClicks = 0;

  constructor(private expressoService: ExpressoService, private router: Router, private sorter: SorterService) {
  }

  ngOnInit() {
    this.expressoService.getStocks().subscribe((data: Stock[]) => {
      this.stocks = data;
    });
    this.expressoService.getWatchlist().subscribe((data: Stock[]) => {
      this.watchlist = data;
      console.log(data);
    });

  }

  searchStock($event: Event) {
    this.searchInput = $event.srcElement['value'].toString().toLocaleLowerCase();
    this.searchResults = this.stocks.filter((stock: Stock) => {
      return stock.name.toLocaleLowerCase().includes(this.searchInput);
    });
  }

  addStockToWatchlist() {
    this.expressoService.addStockToWatchList(this.tickerToAdd);
  }

  toggleDropDown() {
    this.showDropDown = !this.showDropDown;
  }

  setTicker(ticker) {
    this.tickerToAdd = ticker;
    this.toggleDropDown();
  }

  stockDetails(ticker) {
    return this.router.navigate(['/index/' + ticker]);
  }

  sortByLastPrice() {
    if (this.noOfClicks % 2 === 0) {
      this.noOfClicks++;
      this.stocks = this.sorter.sortByLowestPrice(this.stocks);
    } else if (this.noOfClicks % 2 === 1) {
      this.noOfClicks++;
      this.stocks = this.sorter.sortByHighestPrice(this.stocks);
    }
  }


  sortByName() {
    if (this.noOfClicks % 2 === 0) {
      this.noOfClicks++;
      this.stocks = this.sorter.sortNameByAscendingOrder(this.stocks);
    } else if (this.noOfClicks % 2 === 1) {
      this.noOfClicks++;
      this.stocks = this.sorter.sortNameByDescendingOrder(this.stocks);
    }
  }

}
