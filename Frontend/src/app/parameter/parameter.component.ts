import { Component, OnInit } from '@angular/core';
import { ParameterService } from '../parameter.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Parameter, ParameterType } from '../Product';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-parameter',
  templateUrl: './parameter.component.html',
  styleUrls: ['./parameter.component.css'],
})
export class ParameterComponent implements OnInit {
  parameters: any[] = [];
  newParameter: Parameter = {
    name: '',
    internalName: '',
    details: '',
    parameterType: ParameterType.QUANTITY,
    id: 0,
    value: ''
  };
  selectedParameter: Parameter = {
    name: '',  
    internalName: '',  
    details: '',  
    parameterType: ParameterType.QUANTITY,  
    id:0,
    value:''
  };
  
  featureInternalName: string = '';
  isEditing: boolean = false;
  isupdate:boolean = false;
  isdelete:boolean = false;
  isAdmin:boolean = false;

  featureName: string |null = "";
  username: string | null = localStorage.getItem("username");

  constructor(private parameterService: ParameterService, private route: ActivatedRoute, private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
    if(this.username === "" || this.username === undefined || this.username === null)
    {
      this.router.navigate(['']);
    }
    this.route.params.subscribe(params => {
      this.featureInternalName = params['internalName'];
      this.featureName = localStorage.getItem("featureName");
      this.loadParameters();
      console.log(this.featureInternalName)
    });
    if(this.authService.getUserScope() === "ROLE_ADMIN"){
      console.log(this.authService.getUserScope());
      this.isAdmin = true;
    }
    else{
      this.isAdmin = false;
    }
  }
  
  loadParameters(): void {
    this.parameterService.getParametersByFeatureInternalName(this.featureInternalName).subscribe((parameters) => {
      this.parameters = parameters;
    });
  }

  addParameter(parameter: any): void {
    const featureInternalName = this.route.snapshot.paramMap.get('internalName') || '';
    console.log(featureInternalName);
    if (this.isValidParameter(parameter)) {
      this.parameterService.addParameterToFeature(featureInternalName, parameter).subscribe(() => {
        this.loadParameters();
        this.resetNewParameter();
        console.log(parameter);
      });
    }
    console.log("outside")
  }
  
  updateParameter(parameter: any): void {
    console.log(parameter);
    
    if (this.isValidParameter(parameter)) {
      this.parameterService.updateParameter(parameter).subscribe(() => {
        this.loadParameters();
        this.selectedParameter = {
          name: '',  
          internalName: '',  
          details: '',  
          parameterType: ParameterType.QUANTITY,  
          id:0,
          value:''
        };
        console.log(parameter);
        this.isupdate = true;
      });
    }
    
  }

  editParameter(parameter: any): void {
    this.isEditing = true;
    this.selectedParameter = { ...parameter };
  }
  

  deleteParameter(internalName: string): void {
    this.parameterService.deleteParameter(internalName).subscribe(() => {
      this.loadParameters();
      this.isdelete = true;
    });
  }

  resetNewParameter(): void {
    this.newParameter = {
      name: '',
      internalName: '',
      details: '',
      parameterType: ParameterType.QUANTITY,
      id:0,
      value:''
    };
    this.selectedParameter = {
      name: '',  
      internalName: '',  
      details: '',  
      parameterType: ParameterType.QUANTITY,  
      id:0,
      value:''
    };
  }

  cancelEdit(): void {
    this.resetNewParameter();
  }

  isValidParameter(parameter: any): boolean {
    if (parameter.type === 'price') {
      return this.isValidFloat(parameter.value);
    } else if (parameter.type === 'quantity') {
      return this.isValidInteger(parameter.value);
    }
    return true;
  }

  isValidFloat(value: string): boolean {
    const floatValue = parseFloat(value);
    return !isNaN(floatValue) && isFinite(floatValue);
  }

  isValidInteger(value: string): boolean {
    const intValue = parseInt(value, 10);
    return !isNaN(intValue) && Number.isInteger(intValue);
  }
}


