import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { LoginRequest } from '../model/LoginRequest';
import { catchError } from 'rxjs';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {

  loginRequest: LoginRequest = new LoginRequest();
  isLoggedIn: boolean = false;
  loginError: boolean = false;

  constructor(private authService: AuthService, private router: Router) { }

  login(): void {
    this.authService.login(this.loginRequest).pipe(
      catchError((error) => {
        console.error('Login failed:', error);
        this.loginError = true; // Set login error to true on failure
        throw error;
      })
    ).subscribe((response) => {
      const token = response.token;
      this.authService.setToken(token);
      this.isLoggedIn = true; // Set isLoggedIn to true on successful login
      this.router.navigate(["/products"]);
    });
  }
}
