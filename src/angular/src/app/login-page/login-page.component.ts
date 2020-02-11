import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';
import {ExpressoService} from '../services/expresso.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  constructor(private service: ExpressoService) {
  }

  ngOnInit() {
  }

  submit(f: NgForm) {

    const value = f.value;

    this.service.login(value)
      .then(() => {
        console.log('Successful');
      });
    }
}
