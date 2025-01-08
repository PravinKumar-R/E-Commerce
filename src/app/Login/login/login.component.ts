import { Component, inject, signal } from '@angular/core';
import {
  MatDialog
} from '@angular/material/dialog';
import { RegisterComponent } from '../../Register/register/register.component';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from '../../model/user';
import { Login } from '../../model/login';
import { Address } from '../../model/address';
import { UserServiceService } from '../../Service/user-service.service';
import { UserAddressService } from '../../Service/user-address.service';
import { LoginService } from '../../Service/login.service';
import { ForgetPasswordComponent } from '../../ForgetPassword/forget-password/forget-password.component';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  readonly dialog = inject(MatDialog);

  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(RegisterComponent, {
      width: '700px',
      height: '680px',
      enterAnimationDuration,
      exitAnimationDuration,
    });
  }
  
  openDialogForForgetPassword(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(ForgetPasswordComponent, {
      width: '400px',
      height: '300px',
      enterAnimationDuration,
      exitAnimationDuration,
      });
    }

  hide = signal(true);
  
  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }

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
           loginUserName: new FormControl('',[Validators.required]),
           password: new FormControl('', [Validators.required])
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

  userEmailId!: any;

  userEmailIdData!: any;

  userPassword!: any;

  userPasswordData!: any;

  dataSave!: any;

  saveBase!: any;

  login(data: any)
  {
    console.log(data);
    this.userLoginService.getLoginByUserEmailId(data.loginUserName).subscribe((save: any) => {
      this.saveData = save;
      console.log(save);
    console.log(this.saveData);
    this.userEmailId = sessionStorage.setItem('userEmailId', save.userEmailId); 
    this.userEmailIdData = sessionStorage.getItem('userEmailId');

      if(data.loginUserName)
        {
        //  window.location.reload();
        }
    })
  }

}