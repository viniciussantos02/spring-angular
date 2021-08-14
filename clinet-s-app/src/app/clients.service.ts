import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

import { Client } from './clients/client';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor(private http : HttpClient) { }

   saveClient(client : Client) : Observable<Client> {
    return this.http.post<Client>('http://localhost:8080/api/clients', client);
   }

   getAllClients() : Observable<Client[]> {
    return this.http.get<Client[]>('http://localhost:8080/api/clients');
   }

   getClientById(id : number) : Observable<Client> {
    return this.http.get<any>(`http://localhost:8080/api/clients/${id}`);
   }

   updateClient(client : Client) : Observable<any> {
    return this.http.put<Client>(`http://localhost:8080/api/clients/${client.id}`, client);
   }

   deleteClientById(id : number) : Observable<any> {
    return this.http.delete<any>(`http://localhost:8080/api/clients/${id}`);
   }
}
