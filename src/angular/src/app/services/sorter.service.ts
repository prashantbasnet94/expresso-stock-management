import {Injectable} from '@angular/core';
import {Stock} from '../types/stock';

@Injectable({
  providedIn: 'root'
})
export class SorterService {

  constructor() {
  }

  sortByLowestPrice(stocks: Stock[]) {
    stocks = stocks.sort(function (a, b) {
      if (a.price < b.price) {
        return -1;
      } else if (a.price > b.price) {
        return 1;
      }
      return 0;
    });
    return stocks;
  }

  sortByHighestPrice(stocks: Stock[]) {
    stocks = stocks.sort(function (a, b) {
      if (a.price > b.price) {
        return -1;
      } else if (a.price < b.price) {
        return 1;
      }

      return 0;
    });
    return stocks;
  }

  sortNameByAscendingOrder(stocks: Stock[]) {
    stocks = stocks.sort(function (a, b) {
      if (a.name.toLocaleLowerCase() > b.name.toLocaleLowerCase()) {
        return -1;
      } else if (a.name.toLocaleLowerCase() < b.name.toLocaleLowerCase()) {
        return 1;
      }
      return 0;
    });
    return stocks;

  }

  sortNameByDescendingOrder(stocks: Stock[]) {
    stocks = stocks.sort(function (a, b) {
      if (a.name.toLocaleLowerCase() < b.name.toLocaleLowerCase()) {
        return -1;
      } else if (a.name.toLocaleLowerCase() > b.name.toLocaleLowerCase()) {
        return 1;
      }
      return 0;
    });
    return stocks;
  }
}
