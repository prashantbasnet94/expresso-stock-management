import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../types/user';
import {Stock} from '../types/stock';
import 'rxjs/Rx';
import {StockDetail} from '../types/stock-details';
import 'rxjs/add/operator/toPromise';
import {CompanyInfo} from '../types/company-info';
import {forEach} from '@angular/router/src/utils/collection';

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

    const promise = new Promise((resolve, reject) => {
      this.http.post('/user/authenticate', user)
        .toPromise()
        .then((res) => {
          console.log(res);
          resolve();
        })
        .catch((error) => {
          console.log(error);
          reject();
        });
    });
    return promise;
  }

  login(user) {
    const params = 'username=' + user.username + '&password=' + user.password;
    return new Promise((resolve, reject) => {
      console.log(params);
      this.http.post('/login', params, { withCredentials: true})
        .toPromise()
        .then(() => {
          resolve();
        });
    });
  }


  getStocks() {
    return new Promise((resolve, reject) => {
      this.http.get('stock/getQuotes')
        .toPromise()
        .then((res: Stock[]) => {
          this.stockList = res;
        })
        .then(() => resolve());
    });
  }

  addStockToWatchList(id): Promise<any> {
    return new Promise((resolve, reject) => {
      this.http.get('/stock/createQuoteWatchlist/' + id)
        .toPromise()
        .then((res: Stock[]) => {
          this.watchList = res;
        })
        .then(() => resolve());
    });
  }

  getWatchlist() {
    return new Promise((resolve, reject) => {
      this.http.get('/stock/getQuoteWatchlist')
        .toPromise()
        .then((res: Stock[]) => {
          this.watchList = res;
        })
        .then(() => resolve());
    });
  }

  getDataForGraph(ticker) {
    return new Promise((resolve, reject) => {
      this.http.get('/1.0/stock/' + ticker + '/batch?types=quote,news,chart&range=6m&last=10')
        .toPromise()
        .then((res: StockDetail) => {
          this.stock = res;
          console.log(res);
        })
        .then(() => this.getCompanyInfo(ticker))
        .then(() => resolve());

    });
  }

  getCompanyInfo(ticker) {
    return new Promise((resolve, reject) => {
      this.http.get('/1.0/stock/' + ticker + '/company')
        .toPromise()
        .then((res: CompanyInfo) => {
          this.company = res;
          resolve();
        });
    });
  }


}
