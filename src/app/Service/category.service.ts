import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../model/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient: HttpClient) { }
  
    url: any;
  
    getCategory(): Observable<Category[]> {
      return this.httpClient.get<Category[]>(
        'http://localhost:4050/CategoryFind'
      );
    }
  
    insertCategoryDetail(category: Category) {
      this.url = 'http://localhost:4050';
      return this.httpClient.post(this.url+"/category", category);
    }
  
    deleteCategoryDetail(categoryId: any): Observable<any> {
      return this.httpClient.delete(this.url + "/categoryDelete/" + categoryId);
    }
}
