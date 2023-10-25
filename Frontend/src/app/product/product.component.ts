
import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from '../Product';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  products: any[] = [];
  productId: number = 0;
  selectedProduct: Product = {
    "id": 0,
    "name": "",
    "internalName": "",
    "details": "",
    "maxProductsPerLocation": 0
  };
  isAdmin :boolean = false;
  isEditing: boolean = false;
  features: any[] = [];
  isupdate: boolean = false;
  isdelete: boolean = false;
  isadded: boolean = true;
  username: string | null = localStorage.getItem("username");
  constructor(
    private productService: ProductService,
    private authService : AuthService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    if(this.username === "" || this.username === undefined || this.username === null)
    {
      this.router.navigate(['']);
    }
    this.route.params.subscribe(params => {
      const internalName = params['internalName'];
      if (internalName) {
        this.getProductDetails(internalName);
      } else {
        this.getAllProducts();
      }
    });
    if(this.authService.getUserScope() === "ROLE_ADMIN"){
      console.log(this.authService.getUserScope());
      this.isAdmin = true;
    }
    else{
      this.isAdmin = false;
    }
  }

  getProductDetails(internalName: string): void {
    this.productService.getProductByInternalName(internalName).subscribe(
      (data: any) => {
        this.selectedProduct = data;
        this.getFeaturesByProductInternalName(internalName);
      },
      (error) => {
        console.error('Error fetching product details:', error);
      }
    );
  }

  getAllProducts(): void {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data;
    });
  }

  getFeaturesByProductInternalName(internalName: string): void {
    if (internalName) {
      this.productService.getFeaturesByProductInternalName(internalName).subscribe(
        (data: any[]) => {
          this.features = data;
          console.log('Features data:', this.features);
        },
        (error) => {
          console.error('Error fetching features:', error);
        }
      );
    } else {
      console.error('Internal name is not available for fetching features.');
    }
  }

  selectProduct(product: any): void {
    this.selectedProduct = { ...product };
    
  }

  addProduct(): void {
    this.productService.addProduct(this.selectedProduct).subscribe(() => {
      this.resetForm();
      this.getAllProducts();
    });
    this.isadded = true;
  }

  updateProduct(): void {
    this.productService.updateProduct(this.selectedProduct).subscribe(() => {
      this.resetForm();
      this.getAllProducts();
      this.isupdate = true;
    });
  }
  
  deleteProduct(): void {
    console.log(this.selectedProduct);
    
    this.productService.deleteProduct(this.selectedProduct).subscribe(
      () => {
        console.log("delete");
        
        this.resetForm();
        this.getAllProducts();
        this.isdelete = true;
      },
      (error) => {
        console.error('Error deleting product:', error);
        // Handle the error, e.g., display an error message to the user
      }
    );
  }
  

  resetForm(): void {
    this.isEditing = false;
    this.productId = 0;
  }

  

  ViewFeatures(productInternalName: string , productName: string): void {
    // Set the selected product
    this.getProductDetails(productInternalName);

    // Navigate to the FeatureComponent with the product's internalName
    localStorage.setItem("name", productName);
    this.router.navigate(['/features', productInternalName]);
    
  }


}
