import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration-page',
  templateUrl: './registration-page.component.html',
  styleUrls: ['./registration-page.component.css']
})
export class RegistrationPageComponent {

  constructor(private _http: HttpClient, private router: Router) { } // Inject HttpClient
  name: string = '';
  userpassword: string = ''
  confirmPassword: string = '';


  onSubmit() {
    const userData = {
      name: this.name,
      password: this.userpassword,
      repeatPassword: this.confirmPassword,
      role: 'USER'
    };

    const url = `http://localhost:8080/api/register`;
    if (this.userpassword !== this.confirmPassword) {

      alert("Passwords do not match. Please try again.");

      return;

    }

    this._http.post(url, userData, { responseType: 'text' }).subscribe({
      next: (response) => {
        console.log(userData.name),
        console.log('User registered successfully:', response);
        this.router.navigate(['/login']);
      },

      error: (error) => {
        console.error('Error registering user:', error);
      }
    });

  }

}

 