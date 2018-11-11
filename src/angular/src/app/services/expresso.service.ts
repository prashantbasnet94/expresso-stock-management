import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../types/user';
import {Stock} from '../types/stock';
import 'rxjs/Rx';
import {StockDetail} from '../types/stock-details';
import 'rxjs/add/operator/toPromise';
import {CompanyInfo} from '../types/company-info';

@Injectable({
  providedIn: 'root'
})
export class ExpressoService {

  stock: StockDetail;
  company: CompanyInfo;
  stockList: Stock[];
  watchList: Stock[];

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

  getStocks() {
    const promise = new Promise((resolve, reject) => {
      this.http.get('stock/getQuotes')
        .toPromise()
        .then((res: Stock[]) => {
          this.stockList = res;
        })
        .then(() => resolve());
    });
    return promise;
  }

  addStockToWatchList(id): Promise<any> {

    const promise = new Promise((resolve, reject) => {
      this.http.get('/stock/createQuoteWatchlist/' + id)
        .toPromise()
        .then((res: Stock[]) => {
          this.watchList = res;
        })
        .then(() => resolve());
    });
    return promise;
  }

  getWatchlist() {
    const promise = new Promise((resolve, reject) => {
      this.http.get('/stock/getQuoteWatchlist')
        .toPromise()
        .then((res: Stock[]) => {
          this.watchList = res;
        })
        .then(() => resolve());
    });
    return promise;
  }

  getDataForGraph(ticker) {
    const promise = new Promise((resolve, reject) => {
      this.http.get('/1.0/stock/' + ticker + '/batch?types=quote,news,chart&range=1m&last=10')
        .toPromise()
        .then((res: StockDetail) => {
          this.stock = res;
        })
        .then(() => this.getCompanyInfo(ticker))
        .then(() => resolve());

    });
    return promise;
  }

  getCompanyInfo(ticker) {
    const promise = new Promise((resolve, reject) => {
      this.http.get('/1.0/stock/' + ticker + '/company')
        .toPromise()
        .then((res: CompanyInfo) => {
          this.company = res;
          resolve();
        });
    });
    return promise;
  }


}
