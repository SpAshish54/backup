import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface Parameter {
  internalName: string;
  // Add other properties as needed
}

@Injectable({
  providedIn: 'root',
})
export class ParameterService {
  private baseUrl = 'http://localhost:8080/api/parameters';

  constructor(private http: HttpClient) {}

  addParameterToFeature(featureInternalName: string, parameter: Parameter): Observable<void> {
    const url = `${this.baseUrl}/${featureInternalName}`;
    return this.http.post<void>(url, parameter);
  }

  getParameterById(parameterId: number): Observable<Parameter> {
    const url = `${this.baseUrl}/${parameterId}`;
    return this.http.get<Parameter>(url);
  }

  getParametersByFeatureInternalName(featureInternalName: string): Observable<Parameter[]> {
    const url = `${this.baseUrl}/feature/${featureInternalName}`;
    return this.http.get<Parameter[]>(url);
  }

  getAllParameters(): Observable<Parameter[]> {
    return this.http.get<Parameter[]>(this.baseUrl);
  }

  updateParameter(parameter: Parameter): Observable<Parameter> {
    return this.http.put<Parameter>(this.baseUrl, parameter);
  }

  // deleteParameter(internalName: string): Observable<void> {
  //   const url = `${this.baseUrl}?internalName=${internalName}`;
  //   return this.http.delete<void>(url);
  // }



  deleteParameter(internalName: string): Observable<void> {
    const url = `${this.baseUrl}/delete`;
    return this.http.post<void>(url, internalName);
  }  
    
}
