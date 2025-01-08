import { Component, inject } from '@angular/core';
import {
  MatDialog
} from '@angular/material/dialog';
import { User } from '../../model/user';
import { Login } from '../../model/login';
import { Address } from '../../model/address';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { UserServiceService } from '../../Service/user-service.service';
import { UserAddressService } from '../../Service/user-address.service';
import { LoginService } from '../../Service/login.service';
@Component({
  selector: 'app-forget-password',
  templateUrl: './forget-password.component.html',
  styleUrl: './forget-password.component.css'
})
export class ForgetPasswordComponent {

    detail!: User;
    
    pass!: Login;
    
    addr!: Address;
  
    form!: FormGroup;
  
    addresses: Address[] = [];
  
    password!: Login[];
  
    users!: User[];
  
    saveData: Login[] = [];
  
    constructor(private fb: FormBuilder,private userService: UserServiceService, private useraddress: UserAddressService, private userLoginService: LoginService)
    {
      this.detail=new User();
      this.pass = new Login();
      this.addr = new Address();
  
      this.saveData;
      console.log(this.saveData);
    }
  
    ngOnInit()
    {
      this.form = new FormGroup({
        userEmailId: new FormControl('',[Validators.required]),
          }
        );
  
        this.userLoginService.getLogin().subscribe((login) => {
          this.password = login;
          console.log(login);
        });
    
        this.useraddress.getAddress().subscribe((address) => {
          this.addresses = address;
          console.log(address);
        })
    
        this.userService.getUser().subscribe((user) => {
          this.users = user;
          console.log(user);
        })
  
        this.saveData;
        console.log(this.saveData);
    }
  
    login(data: any)
    {
      console.log(data);
      this.userLoginService.getLoginByUserEmailId(data.loginUserName).subscribe((save: any) => {
        this.saveData = save;
        console.log(save);
  
        if(data.loginUserName === save)
          {
            console.log(save);
          }
      })
  
    }

}
