import {Component, OnInit} from '@angular/core';
import {ExpressoService} from '../expresso.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-index-page',
  templateUrl: './index-page.component.html',
  styleUrls: ['./index-page.component.scss']
})
export class IndexPageComponent implements OnInit {

  stocks : any[];
  constructor(private data: ExpressoService, private router: Router) {
  }

  ngOnInit() {
    this.loadData();
  }

  loadData() {
      this.data.getStocks()
        .subscribe((data: any[]) => {
            this.stocks = data;
            console.log(this.stocks);
          },
          (error) => {
            console.log(error);
          });
  }

  onClick(ticker: string){
    this.router.navigate(["/index", ticker])
      .catch((error)=>{
        console.log(error)
      })
  }
}
