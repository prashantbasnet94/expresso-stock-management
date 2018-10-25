import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../types/user';
import {Stock} from '../types/stock';
import 'rxjs/Rx';
import { StockDetail } from '../types/stock-details';

@Injectable({
  providedIn: 'root'
})
export class ExpressoService {

  stock: Stock;

  constructor(private http: HttpClient) {
  }

  signUp(user: User) {
    console.log((user));
    return this.http.post('/user/authenticate', user).map((res) => {
      return (res);
    }).toPromise()
      .catch((error) => {
        return error;
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

  addStockToWatchList(id): Promise<any> {
    return this.http.get('/stock/createQuoteWatchlist/' + id).map((data) => {
      return (data);
    })
      .toPromise()
      .catch((error) => {
        console.log(error);
      });
  }

  getWatchlist() {
    return this.http.get('/stock/getQuoteWatchlist').map((data: Stock[]) => {
      return data;
    });
  }

  getDataForGraph(ticker) {
    return this.http.get('/1.0/stock/' + ticker + '/batch?types=quote,news,chart&range=1d&last=10').map((data: StockDetail[]) => {
      console.log(data);
      return data;
    });
  }

  getLogo(ticker) {
    return this.http.get('1.0/stock/' + ticker + '/logo').map((data) => {
      return data;
    });
  }

  getCompanyInfo(ticker){
    return this.http.get('/1.0/stock/' + ticker + '/company').map((data) => {
      return data;
    });
  }


}
