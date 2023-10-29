import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
 
import { Router } from '@angular/router';
import { LoginRequest } from './model/LoginRequest';


@Injectable({
    providedIn: 'root',
})
 
export class AuthService {
    private apiUrl = 'http://localhost:8080/api/auth/token';
    loginRequest: any;
 
    constructor(private http: HttpClient, private router: Router) { }
 
    login(loginRequest: LoginRequest): Observable<any> {
        return this.http.post(`${this.apiUrl}`, loginRequest);
    }
 
    setToken(token: string): void {
        localStorage.setItem('token', token);
    }
 
    getToken(): string | null {
        return localStorage.getItem('token');
    }
 
    getHeaders(): HttpHeaders {
        const token = this.getToken();
        return new HttpHeaders({
            'Content-Type': 'application/json',
            Authorization: `Bearer ${token}`,
        });
    }
 
    get isLoggedIn(): boolean {
        let authToken = localStorage.getItem('token');
        return authToken !== null ? true : false;
    }
 
    logout(): void {
        localStorage.removeItem('token');
        this.router.navigate(['login'])
    }

    getUserScope(): string | null { //extract users scope/role

        const token = this.getToken();  //users role extract
    
        if (token) {  //if present
    
          // the token contains the user's role information in some way (e.g., as a claim)
    
          // You would need to parse the token and extract the role information based on your token structure
    
          // For simplicity, let's assume the token contains a field called 'role'
    
          const decodedToken = JSON.parse(atob(token.split('.')[1]));  //headder,payload,sign
    
          console.log(decodedToken.scope);
    
          return decodedToken.scope;//  if token structure==assumption ret users scope/role
    
        }
    
        return null;
    
    }
}
 