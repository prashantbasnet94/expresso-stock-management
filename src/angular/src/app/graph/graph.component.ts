import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.scss']
})


export class GraphComponent implements OnInit {

  public chartType = 'line';

  public chartDatasets: Array<any> = [
    {data: [65, 59, 80, 81, 84, 80, 90], label: '$'},
  ];

  public chartLabels: Array<any> = ['J', 'F', 'M', 'A', 'M', 'J', 'J'];

  public chartColors: Array<any> = [
    {
      backgroundColor: 'rgba(170, 205, 204,0.4)',
      borderColor: 'rgba(220,220,220,1)',
      borderWidth: 2,
      pointBackgroundColor: 'rgba(220,220,220,1)',
      pointBorderColor: '#010065',
      pointHoverBackgroundColor: '#00011b',
      pointHoverBorderColor: 'rgba(220,220,220,1)'
    },
  ];

  public chartOptions: any = {
    responsive: true
  };

  constructor() {
  }

  ngOnInit() {
  }


  public chartClicked(e: any): void {
  }

  public chartHovered(e: any): void {
  }

}
