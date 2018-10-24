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
  };
  confirmPassword: string = '';


  constructor(private expresso: ExpressoService, private route: Router) {
  }

  ngOnInit() {
  }

  register() {
    this.route.navigate(['login']).then(() => {
      this.expresso.signUp(this.user).subscribe(() => {
      });
    });
  }


  validPassword() {
    return this.user.password.length > 0 && this.user.password !== this.confirmPassword;
  }

}
