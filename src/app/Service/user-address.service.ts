import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Address } from '../model/address';

@Injectable({
  providedIn: 'root'
})
export class UserAddressService {

  url: any;

  constructor(private httpClient: HttpClient) {}

  getAddress(): Observable<Address[]> {
    return this.httpClient.get<Address[]>(
      'http://localhost:4050/AddressFind'
    );
  }

  insertAddressDetail(address: Address) {
    this.url = 'http://localhost:4050';
    return this.httpClient.post(this.url+"/address", address);
  }
}