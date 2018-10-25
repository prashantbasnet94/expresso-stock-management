import {Component, OnInit} from '@angular/core';
import {ExpressoService} from '../services/expresso.service';
import {Router} from '@angular/router';
import {Stock} from '../types/stock';
import {SorterService} from '../services/sorter.service';

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

  constructor(private expressoService: ExpressoService, private router: Router, private sorter: SorterService) {
  }

  ngOnInit() {
    this.expressoService.getStocks()
      .subscribe((data: Stock[]) => {
          this.stocks = data.filter((value) => {
            return value.name.length > 0;
          });
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
