import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ServiceProvidedFormComponent } from './service-provided-form/service-provided-form.component';


const routes: Routes = [
  { path: 'service-provided-form', component: ServiceProvidedFormComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServiceProvidedRoutingModule { }
