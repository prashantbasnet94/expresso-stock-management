import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../types/user';
import {Stock} from '../types/stock';
import 'rxjs/Rx';

@Injectable({
  providedIn: 'root'
})
export class ExpressoService {

  stock: Stock;

  constructor(private http: HttpClient) {
  }

  signUp(user: User) {
    console.log((user));
    return this.http.post('user/authenticate', user).map((error: Error) => {
      console.log(error);
    });
  }

  getStockByTicker(ticker: string) {
    return this.http.get('/1.0/stock/' + ticker + '/quote').map((data) => {
      return data;
    });
  }

  getStocks() {
    return this.http.get('stock/getQuotes')
      .map(
        (data) => {
          return data;
        });
  }

  addStockToWatchList(id) {
    console.log(id);
    return this.http.get('/stock/createQuoteWatchlist/' + id).map((data) => {
      return data;
    });
  }

  getDataForGraph(ticker) {
    return this.http.get('/1.0/stock/' + ticker + '/chart/1m').map((data: any[]) => {
      return data;
    });
  }

  getLogo(ticker) {
    return this.http.get('1.0/stock/' + ticker + '/logo').map((data) => {
      return data;
    });
  }


}
