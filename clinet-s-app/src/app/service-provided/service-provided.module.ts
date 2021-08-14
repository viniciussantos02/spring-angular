import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { ServiceProvidedRoutingModule } from './service-provided-routing.module';
import { ServiceProvidedFormComponent } from './service-provided-form/service-provided-form.component';
import { ServiceProvidedListComponent } from './service-provided-list/service-provided-list.component';


@NgModule({
  declarations: [
    ServiceProvidedFormComponent,
    ServiceProvidedListComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    ServiceProvidedRoutingModule
  ],
  exports: [
    ServiceProvidedFormComponent,
    ServiceProvidedListComponent
  ]
})
export class ServiceProvidedModule { }
