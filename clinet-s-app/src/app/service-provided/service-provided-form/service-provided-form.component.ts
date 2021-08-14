import { Component, OnInit } from '@angular/core';

import { Client } from '../../clients/client';
import { ClientsService } from '../../clients.service';
import { ServiceProvided } from '../ServiceProvided';

@Component({
  selector: 'app-service-provided-form',
  templateUrl: './service-provided-form.component.html',
  styleUrls: ['./service-provided-form.component.css']
})
export class ServiceProvidedFormComponent implements OnInit {

  clientList: Client[] = [];
  serviceProvided: ServiceProvided;

  constructor(private clientService : ClientsService) {
    this.serviceProvided = new ServiceProvided();
   }

  ngOnInit(): void {
    this.clientService.getAllClients().subscribe(response => this.clientList = response);
  }

  onSubmit() {
    console.log(this.serviceProvided);
  }

}
