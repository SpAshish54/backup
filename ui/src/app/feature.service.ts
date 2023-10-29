import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Feature } from './Product';

@Injectable({
  providedIn: 'root'
})
export class FeatureService {
  private baseUrl = 'http://localhost:8080/api/features';

  constructor(private http: HttpClient) { }
  internalName: string= "";

  addFeatureToProduct(productInternalName: string, feature: Feature): Observable<void> {
    const url = `${this.baseUrl}/${productInternalName}`;
    return this.http.post<void>(url, feature);
  }

  getParametersByFeatureInternalName(featureInternalName: string): Observable<Feature[]> {
    const url = `${this.baseUrl}/${featureInternalName}/parameters`;
    return this.http.get<Feature[]>(url);
  }

  getAllFeatures(): Observable<Feature[]> {
    return this.http.get<Feature[]>(this.baseUrl);
  }

  getFeatureByInternalName(featureInternalName: string): Observable<Feature> {
    const url = `${this.baseUrl}/${featureInternalName}`;
    return this.http.get<Feature>(url);
  }

  getFeaturesByProductInternalName(productInternalName: string): Observable<Feature[]> {
    const url = `${this.baseUrl}/product/${productInternalName}`;
    return this.http.get<Feature[]>(url);
  }

  updateFeature(feature: Feature): Observable<Feature> {
    const url = `${this.baseUrl}/update`;
    return this.http.put<Feature>(url, feature);
  }

  deleteFeature(feature: Feature): Observable<void> {
    console.log(feature.internalName);
    const url = `${this.baseUrl}?internalName=${feature.internalName}`;
    return this.http.delete<void>(url);
  }

  saveFeatureName(internalName: string): void{
    this.internalName = internalName;
  }

  getFeatureName(): string{
    return this.internalName;
  }
}
