import {Component, OnInit} from '@angular/core';
import {User} from '../types/user';
import {ExpressoService} from '../services/expresso.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.scss']
})
export class RegisterPageComponent implements OnInit {

  user: User = {
    email: '',
    password: '',
    first_name: '',
    last_name: '',
    username: '',
    dob: '',
    enabled: 1
  };
  confirmPassword = '';


  constructor(private expresso: ExpressoService, private route: Router) {
  }

  ngOnInit() {
  }

  register() {
    this.route.navigate(['']).then(() => {
      this.expresso.signUp(this.user)
        .then((res) => {
          console.log(res);
        })
        .then(() => {
          this.route.navigate(['login']);
        });
    });
  }


  validPassword() {
    return this.user.password.length > 8 && this.user.password !== this.confirmPassword;
  }

}
