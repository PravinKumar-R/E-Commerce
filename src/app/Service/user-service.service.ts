import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private httpClient: HttpClient) {}

  url: any;

  getUser(): Observable<User[]> {
    return this.httpClient.get<User[]>(
      'http://localhost:4050/findAllCustomers'
    );
  }

  insertUserDetail(user: User) {
    this.url = 'http://localhost:4050';
    return this.httpClient.post(this.url+"/insertUsers", user);
  }

  deleteUserDetail(userId: any): Observable<any> {
    return this.httpClient.delete(this.url + "/deleteUsers/" + userId);
  }

}