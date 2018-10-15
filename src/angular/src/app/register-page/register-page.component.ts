import {Component, OnInit} from '@angular/core';
import {User} from '../types/user';
import {HttpClient} from '@angular/common/http';
import {ExpressoService} from '../expresso.service';

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
    user_id: '',
    dob: '',
  };
  confirmPassword: string;


  constructor(private expressoService: ExpressoService) {
  }

  ngOnInit() {
  }

  sendUser() {
    this.expressoService.signUp(this.user);
  }

  validPassword() {
    return this.user.password.length > 0 && this.user.password !== this.confirmPassword;
  }

  register() {
    console.log(this.user);
    console.log('User Registered');
  }

}
