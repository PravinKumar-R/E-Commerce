import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpClient: HttpClient) { }
    
      url: any;
    
      getProduct(): Observable<Product[]> {
        return this.httpClient.get<Product[]>(
          'http://localhost:4050/ProductFind'
        );
      }
    
      insertProductDetail(product: Product) {
        this.url = 'http://localhost:4050';
        return this.httpClient.post(this.url+"/product", product);
      }
    
      deleteProductDetail(productId: any): Observable<any> {
        return this.httpClient.delete(this.url + "/productDelete/" + productId);
      }
}
