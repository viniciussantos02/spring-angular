import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ClientsFormComponent } from './clients-form/clients-form.component';
import { ClientsListComponent } from './clients-list/clients-list.component';


const routes: Routes = [
  { path : 'client-form', component: ClientsFormComponent },
  { path : 'client-form/:id', component: ClientsFormComponent },
  { path : 'client-list', component: ClientsListComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientsRoutingModule { }
