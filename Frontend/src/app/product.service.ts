import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Feature, Product } from './Product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  
  private apiUrl = 'http://localhost:8080/api/products';

  constructor(private http: HttpClient) {}
  internalName: string= "";

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.apiUrl);
  }

  getProductByInternalName(internalName: string): Observable<Product> {
    const url = `${this.apiUrl}/${internalName}`;
    return this.http.get<Product>(url);
  }

  getFeaturesByProductInternalName(productInternalName: string): Observable<Feature[]> {
    const url = `${this.apiUrl}/${productInternalName}/features`;
    return this.http.get<Feature[]>(url);
  }

  addProduct(product: Product): Observable<void> {
    const url = `${this.apiUrl}/add`;
    return this.http.post<void>(url, product);
  }

  updateProduct(product: Product): Observable<Product> {
    const url = `${this.apiUrl}/update`;
    return this.http.put<Product>(url, product);
  }

  deleteProduct(product: Product) {

    const url = `${this.apiUrl}/delete`;
    console.log(url);
    
    return this.http.post(url,product.internalName);
  }

  saveProductName(internalName: string): void{
    this.internalName = internalName;
  }

  getProductName(): string{
    return this.internalName;
  }
  
  }
