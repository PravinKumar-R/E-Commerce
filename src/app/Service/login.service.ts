import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Login } from '../model/login';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  url: any;

  getLogin(): Observable<Login[]> {
    return this.httpClient.get<Login[]>(
      'http://localhost:4050/LoginFind'
    );
  }

  insertLoginDetail(login: Login) {
    this.url = 'http://localhost:4050';
    return this.httpClient.post(this.url+"/login", login);
  }

  getLoginByUserEmailId(login: Login): Observable<Login[]> {
    return this.httpClient.get<Login[]>(
      'http://localhost:4050/LoginFindId/' + login
    );
  }
}