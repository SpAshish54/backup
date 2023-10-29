import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginPageComponent } from './login-page/login-page.component';
import { RegistrationPageComponent } from './registration-page/registration-page.component';
import { ProductComponent } from './product/product.component';
import { FeatureComponent } from './feature/feature.component';
import { ParameterComponent } from './parameter/parameter.component';
import { SummaryPageComponent } from './summary-page/summary-page.component';

const routes: Routes = [
  {path:'login', component: LoginPageComponent},
  {path:'register', component: RegistrationPageComponent},
  {path: 'summary', component: SummaryPageComponent},
    { path: '', redirectTo: '/login', pathMatch: 'full' },
    { path: 'products', component: ProductComponent },
    { path: 'products/:internalName', component: ProductComponent },
    { path: 'features/:internalName', component: FeatureComponent },
    { path: 'parameters/:internalName', component: ParameterComponent },
    { path: 'products/:internalName/features/:featureInternalName/parameters/:internalName', component: ParameterComponent},
    { path: 'products/:internalName/features/:featureInternalName', component: FeatureComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
