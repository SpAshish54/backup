import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {
  username: string = '';
  password: string = '';

  constructor(private authService: AuthService, private router: Router) { }

  login(): void {
    this.authService.login(this.username, this.password).subscribe(
      (response) => {
        const token = response.token; // if login successful then receive a token  Assuming the token is returned as part of the response
        this.authService.setToken(token); // extracted token is set

        // Redirect to the "/home" page
        this.router.navigate(['/products']);

        alert('You have successfully logged in!');

      },

      (error) => {

        console.error('Login failed:', error);

      }

    );

  }

}

