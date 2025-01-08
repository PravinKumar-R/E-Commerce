import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Seller } from '../model/seller';

@Injectable({
  providedIn: 'root'
})
export class SellerService {

  constructor(private httpClient: HttpClient) { }
      
  url: any;
      
  getSeller(): Observable<Seller[]> {
    return this.httpClient.get<Seller[]>(
    'http://localhost:4050/SellerFind'
    );
  }
      
  insertSellerDetail(seller: Seller) {
    this.url = 'http://localhost:4050';
    return this.httpClient.post(this.url+"/seller", seller);
  }
      
  deleteSellerDetail(sellerId: any): Observable<any> {
    return this.httpClient.delete(this.url + "/sellerDelete/" + sellerId);
  }

}