// summary-page.component.ts

import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { FeatureService } from '../feature.service';
import { ParameterService } from '../parameter.service';
import { Router } from '@angular/router';
import { Product } from '../Product';

@Component({
  selector: 'app-summary-page',
  templateUrl: './summary-page.component.html',
  styleUrls: ['./summary-page.component.css']
})
export class SummaryPageComponent implements OnInit {

  products: Product[] = [];
  selectedProduct: Product | null = null;
  features: any[] = [];
  selectedFeature: any | null = null;
  parameters: any[] = [];

  username: string | null = localStorage.getItem("username");
  constructor(
    private productService: ProductService,
    private featureService: FeatureService,
    private parameterService: ParameterService,
    private router: Router
  ) {}

  ngOnInit(): void {
    if(this.username === "" || this.username === undefined || this.username === null)
    {
      this.router.navigate(['']);
    }
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getAllProducts().subscribe((data: Product[]) => {
      this.products = data;
      this.resetSelection();
    });
  }

  loadFeatures(productInternalName: string): void {
    this.featureService.getFeaturesByProductInternalName(productInternalName).subscribe((data) => {
      this.features = data;
      this.resetFeatureSelection();
    });
  }

  loadParameters(featureInternalName: string): void {
    this.parameterService.getParametersByFeatureInternalName(featureInternalName).subscribe((data) => {
      this.parameters = data;
    });
  }

  viewFeatures(product: Product): void {
    this.selectedProduct = product;
    this.loadFeatures(product.internalName);
  }

  viewParameters(feature: any): void {
    this.selectedFeature = feature;
    this.loadParameters(feature.internalName);
  }

  resetSelection(): void {
    this.selectedProduct = null;
    this.selectedFeature = null;
    this.features = [];
    this.parameters = [];
  }

  resetFeatureSelection(): void {
    this.selectedFeature = null;
    this.parameters = [];
  }
}
