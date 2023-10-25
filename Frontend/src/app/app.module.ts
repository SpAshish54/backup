import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { FormsModule } from '@angular/forms';
import { ProductComponent } from './product/product.component';
import { FeatureComponent } from './feature/feature.component';
import { ParameterComponent } from './parameter/parameter.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SummaryPageComponent } from './summary-page/summary-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    RegistrationPageComponent,
    ProductComponent,
    FeatureComponent,
    ParameterComponent,
    NavbarComponent,
    SummaryPageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
