import {Component, OnInit} from '@angular/core';
import {ExpressoService} from '../services/expresso.service';
import {Router} from '@angular/router';
import {Stock} from '../types/stock';

@Component({
  selector: 'app-index-page',
  templateUrl: './index-page.component.html',
  styleUrls: ['./index-page.component.scss']
})
export class IndexPageComponent implements OnInit {

  stocks: Stock[];
  searchResults: Stock[] = [];
  searchInput = '';
  showDropDown = false;
  pageLoaded = false;
  noOfClicks = 0;

  constructor(private expressoService: ExpressoService, private router: Router) {
  }

  ngOnInit() {
    this.expressoService.getStocks()
      .subscribe((data: Stock[]) => {
<<<<<<< HEAD
          this.stocks = data.filter((value) => {
            return value.name.length > 0;
          });
=======
          this.stocks = data;
          console.log(this.stocks);
>>>>>>> master
          return this.pageLoaded = true;
        },
        (error) => {
          console.log(error);
        });

  }

  onSearchResultsClick(ticker: string) {
    this.router.navigate(['/index', ticker])
      .catch((error) => {
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

  toggleDropDown() {
    this.showDropDown = !this.showDropDown;
  }

  sortByLastPrice($event: Event) {
    if (this.noOfClicks % 2 === 0) {
      this.noOfClicks++;
      console.log($event);
      this.stocks = this.stocks.sort(function (a, b) {
        if (a.price < b.price) {
          return -1;
        } else if (a.price > b.price) {
          return 1;
        }
        return 0;
      });
    } else if (this.noOfClicks % 2 === 1) {
      this.noOfClicks++;
      console.log($event);
      this.stocks = this.stocks.sort(function (a, b) {
        if (a.price > b.price) {
          return -1;
        } else if (a.price < b.price) {
          return 1;
        }

        return 0;
      });
    }
    console.log(this.noOfClicks);
  }


  sortByName() {
    if (this.noOfClicks % 2 === 0) {
      this.noOfClicks++;
      this.stocks = this.stocks.sort(function (a, b) {
        if (a.name < b.name) {
          return -1;
        } else if (a.name > b.name) {
          return 1;
        }
        return 0;
      });
    } else if (this.noOfClicks % 2 === 1) {
      this.noOfClicks++;
      this.stocks = this.stocks.sort(function (a, b) {
        if (a.name > b.name) {
          return -1;
        } else if (a.name < b.name) {
          return 1;
        }

        return 0;
      });
    }
    console.log(this.noOfClicks);
<<<<<<< HEAD
=======
  }

  reload() {
    const container = document.getElementById('name-value');
    const content = container.innerHTML;
    container.innerHTML = content;

    //this line is to watch the result in console , you can remove it later
    console.log('Refreshed');
>>>>>>> master
  }

  reload() {
    const container = document.getElementById('name');
    const content = container.innerHTML;
    container.innerHTML = content;

    //this line is to watch the result in console , you can remove it later
    console.log('Refreshed');
  }

}
