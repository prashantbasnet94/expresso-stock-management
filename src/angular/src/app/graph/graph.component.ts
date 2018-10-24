import {Component, Input, OnInit} from '@angular/core';
import * as Chart from 'chart.js';

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.scss']
})


export class GraphComponent implements OnInit {
  @Input() dataset: number[];
  @Input() dataLabel: string[];

<<<<<<< HEAD
  chart: any;
=======
  public chartType = 'line';

  public chartDatasets: Array<any> = [
    {data: [65, 59, 80, 81, 84, 80, 90], label: '$'},
  ];

  public chartLabels: Array<any> = ['J', 'F', 'M', 'A', 'M', 'J', 'J'];

  public chartColors: Array<any> = [
    {
      backgroundColor: 'rgba(21, 100, 191, 0.4)',
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
>>>>>>> master

  constructor() {
  }

  ngOnInit() {
    console.log(this.dataset);
    console.log(this.dataLabel);
    this.chart = new Chart('canvas', {
      type: 'line',
      data: {
        labels: this.dataLabel,
        datasets: [{
          data: this.dataset,
          borderColor: '#3cba9f',
          fill: '#3cba9f',
        }]
      }
    });
  }
}
