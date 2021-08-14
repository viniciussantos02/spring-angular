import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Client } from '../client';
import { ClientsService } from '../../clients.service';

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit {

  clients: Client[] = [];
  clientSelected: Client;
  msgSuccess: string;
  msgError: string;

  constructor(private service : ClientsService, private router : Router) { }

  ngOnInit(): void {
    this.getAllClients();
  }

  newRegister() {
    this.router.navigate(['client-form']);
  }

  updateClient(client : Client){
    this.service.updateClient(client);
  }

  prepareDelection(client : Client){
    this.clientSelected = client;
  }

  deleteClientById() {
    this.service.deleteClientById(this.clientSelected.id).subscribe(
      response => {
        this.msgSuccess = 'Client deleted!'
        this.ngOnInit();
      } , 
    reponseError => this.msgError = 'Error whili deleting a client!');
  }

  private getAllClients() {
    this.service.getAllClients().subscribe(response => this.clients = response);
  }
}
