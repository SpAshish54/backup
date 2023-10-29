import { Component, OnInit } from '@angular/core';
import { FeatureService } from '../feature.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Feature } from '../Product';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-feature',
  templateUrl: './feature.component.html',
  styleUrls: ['./feature.component.css']
})

export class FeatureComponent implements OnInit {
  isDelete : boolean = false;

  features: Feature[] = [];
  featureId: number = 0;
  isupdateFeature: boolean = false;
  isAddingFeature: boolean = true;
  selectedFeature: Feature = {
    id: 0,
    name: "",
    internalName: "",
    details: "",
    productName: "",
    productInternalName: ""
  };
  isEditing: boolean = false;
  isFeatureSelected: boolean = false;
  internalName :string='';
  featureName:string='';
  username: string | null = localStorage.getItem("username");
  isAdmin :boolean = false;

  constructor(
    private featureService: FeatureService,
    private authService: AuthService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    if(this.username === "" || this.username === undefined || this.username === null)
    {
      this.router.navigate(['']);
    }
    this.route.params.subscribe(params => {
      const productInternalName = params['internalName'];
      this.internalName = localStorage.getItem("name") || 'InternalName not found';
      if (productInternalName) {
        
        this.loadFeaturesByProductInternalName(productInternalName);
      } else {
        
        this.getAllFeatures();
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

  loadFeaturesByProductInternalName(productInternalName: string): void {
    this.featureService.getFeaturesByProductInternalName(productInternalName).subscribe(
      (data: any[]) => {
        this.features = data;
      },
      (error) => {
        console.error('Error fetching features:', error);
      }
    );
  }

  getAllFeatures(): void {
    this.featureService.getAllFeatures().subscribe(data => {
      this.features = data;
    });
  }

  getFeatureByInternalName(featureInternalName: string): void {
    this.featureService.getFeatureByInternalName(featureInternalName).subscribe(
      (data: Feature) => {
        this.selectedFeature = data;
        this.isFeatureSelected = true;
        
        this.loadParametersByFeatureInternalName(this.selectedFeature.internalName);
      },
      (error) => {
        console.error('Error fetching feature:', error);
      }
    );
  }

  addFeatureToProduct(): void {
    this.isAddingFeature = true;
    const productInternalName = this.route.snapshot.paramMap.get('internalName') || '';
    this.featureService.addFeatureToProduct(productInternalName, this.selectedFeature).subscribe(() => {
      this.resetForm();
      this.loadFeaturesByProductInternalName(productInternalName);
      this.isAddingFeature = false;
    });
  }
  

  updateFeature(): void {
    
    this.featureService.updateFeature(this.selectedFeature).subscribe(() => {
      this.resetForm();
      this.loadFeaturesByProductInternalName(this.selectedFeature.productInternalName);
    });
    this.isupdateFeature = true;
    setTimeout(() => {
      this.isupdateFeature = false;
    }, 3000); // Hide the message after 5 seconds

  }

  deleteFeature(feature : Feature): void {
    this.isDelete = true;
    this.featureService.deleteFeature(feature).subscribe(() => {
      this.loadFeaturesByProductInternalName(feature.productInternalName);
    });
    setTimeout(() => {
      this.isDelete = false;
    }, 7000);
    
  }

  loadParametersByFeatureInternalName(featureInternalName: string): void {
    this.featureService.getParametersByFeatureInternalName(featureInternalName).subscribe(
      (data: any[]) => {
        this.features = data;
      },
      (error) => {
        console.error('Error fetching parameters:', error);
      }
    );
  }

  cancelEdit(): void {
    this.resetForm();
  }


  cancelFeature() {
    this.isAddingFeature = !this.isAddingFeature;
  }

  
  selectFeature(feature: any): void {
    this.isFeatureSelected = true;
    this.selectedFeature = { ...feature };
    
    this.selectedFeature.productInternalName = feature.productInternalName;
  }
  
  
  resetForm(): void {
    this.isEditing = false;
    this.isAddingFeature = false;
    this.selectedFeature = {
      id: 0,
      name: "",
      internalName: "",
      details: "",
      productName: "",
      productInternalName: ""
    };
  }
  
  editFeature(feature: any): void {
    this.isEditing = true;
    this.isAddingFeature = false;
    this.selectedFeature = { ...feature };
    
    this.selectedFeature.productInternalName = feature.productInternalName;
  }
  
  
  viewParameters(featureInternalName: string,featureName: string): void {
    this.loadFeaturesByProductInternalName(featureInternalName)
    localStorage.setItem("featureName", featureName);
    this.router.navigate(['/parameters', featureInternalName]);
  }
  
  addFeature(): void {
    this.isAddingFeature = !this.isAddingFeature;
    this.isEditing = false;
    this.resetForm(); 
    
  }

}

