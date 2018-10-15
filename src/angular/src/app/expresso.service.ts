import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from './types/user';
import {Response} from '@angular/http';
import {Stock} from './types/stock';
import {map} from 'rxjs/operators';
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
    return this.http.post('/users/user', (user));
  }

  getStockByTicker(ticker: string) {
    return this.http.get('/stock/getQuoteDetails/'+ ticker).map((data) => {
      console.log(data);
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

  login(username: string, password: string) {

  }


}
