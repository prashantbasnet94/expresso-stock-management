import {BrowserModule} from '@angular/platform-browser';
import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';

import {AppComponent} from './app.component';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import {NavbarComponent} from './navbar/navbar.component';
import {IndexPageComponent} from './index-page/index-page.component';
import {PortfolioPageComponent} from './portfolio-page/portfolio-page.component';
import {WatchlistPageComponent} from './watchlist-page/watchlist-page.component';
import {LoginPageComponent} from './login-page/login-page.component';
import {RegisterPageComponent} from './register-page/register-page.component';
import {ForumPageComponent} from './forum-page/forum-page.component';
import {GraphComponent} from './graph/graph.component';
import {DetailStockInfoComponent} from './detail-stock-info/detail-stock-info.component';
import {TimeDatePipe} from './Pipes/time-date.pipe';

@NgModule({
  declarations: [
    AppComponent,
    IndexPageComponent,
    PortfolioPageComponent,
    WatchlistPageComponent,
    NavbarComponent,
    LoginPageComponent,
    RegisterPageComponent,
    ForumPageComponent,
    GraphComponent,
    DetailStockInfoComponent,
    TimeDatePipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    MDBBootstrapModule.forRoot(),
    AppRoutingModule,
    HttpClientModule
  ],
  schemas: [NO_ERRORS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
