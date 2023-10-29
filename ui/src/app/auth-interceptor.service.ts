// import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
// import { Injectable } from '@angular/core';
// import { Observable } from 'rxjs';

// @Injectable({
//   providedIn: 'root'
// })


// export class AuthInterceptorService implements HttpInterceptor {
//   intercept(
//     request: HttpRequest<any>,
//     next: HttpHandler
//   ): Observable<HttpEvent<any>> {
//     // Check if a token exists in local storage
//     const token = localStorage.getItem('token');

//     const ignoreEndpoint = request.url.includes('http://localhost:8080/api/auth/token');

//     if (token && !ignoreEndpoint) {
//       request = request.clone({
//         setHeaders: {
//           Authorization: `Bearer ${token}`,
//         },
//       });
//     }
    
//     return next.handle(request); 
//   }
// }
