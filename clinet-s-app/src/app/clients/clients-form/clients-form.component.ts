import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Params, Router } from '@angular/router';

import { Client } from '../client';
import { ClientsService } from '../../clients.service';

import { Observable } from 'rxjs';


@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent implements OnInit {

  client: Client;
  success: boolean;
  errors: string[];
  id: number;

  constructor(private service : ClientsService, private activatedRoute : ActivatedRoute, private router : Router) {
    this.client = new Client();
  }

  ngOnInit(): void {
    let params : Observable<Params> = this.activatedRoute.params;
    params.subscribe(urlParams => {
      this.id = urlParams['id'];
      if(this.id) {
        this.service.getClientById(this.id).subscribe(response => this.client = response , 
          errorResponse => this.client = new Client());
      }
    });
  }

  onSubmit(form : NgForm){
    if(this.id) {
      this.service.updateClient(this.client).subscribe(reponse => {
        this.success = true;
        this.errors = [];
        this.client = new Client();
        form.resetForm();
      }, errorResponse => {
        this.success = false;
        this.errors = errorResponse.error.errors;
      }
      );
    } else {
      this.service.saveClient(this.client)
      .subscribe(response => {
        this.success = true;
        this.errors = [];
        this.client = new Client();
        form.resetForm();
      }, errorResponse => {
        this.success = false;
        this.errors = errorResponse.error.errors;
      }
      );
    }
  }

  cancelButton() {
    this.router.navigate(['client-list']);
  }
}