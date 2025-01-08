import { Component, signal, TemplateRef, ViewChild } from '@angular/core';
import { AbstractControl, FormBuilder, FormControl, FormGroup, ValidationErrors, ValidatorFn, Validators } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { User } from '../../model/user';
import { UserAddressService } from '../../Service/user-address.service';
import { UserServiceService } from '../../Service/user-service.service';
import { Login } from '../../model/login';
import { Address } from '../../model/address';
import { LoginService } from '../../Service/login.service';
import { MatDialog } from '@angular/material/dialog';

const confirmPasswordValidator: ValidatorFn = (
  control: AbstractControl
): ValidationErrors | null => {
  return control.value.password === control.value.reenterpassword
    ? null
    : { PasswordNoMatch: true };
};

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})

export class RegisterComponent {

  dialogRef: any;

  @ViewChild('myRegisterDialog') registerDialog = {} as TemplateRef<User>;

  addresses: Address[] = [];

  password!: Login[];

  users!: User[];

  usersData!: User[];

  form!: FormGroup;

  formRegister!: FormGroup;

  cancel: any = 'Updated';

  constructor(private fb: FormBuilder,private userService: UserServiceService, private useraddress: UserAddressService, private userLoginService: LoginService,public dialog: MatDialog) {
    this.detail=new User();
    this.pass = new Login();
    this.addr = new Address();
    this.saveCancel = sessionStorage.setItem('cancel', this.cancel);
    this.saveCancelGet = sessionStorage.getItem('cancel');
  }

  ngOnInit(): void {
    this.form = new FormGroup({
       userFirstName: new FormControl('',[Validators.required]),
       userLastName: new FormControl('', [Validators.required]),
       userEmailId: new FormControl('', [Validators.required, Validators.email]),
       userDob: new FormControl('', [Validators.required]),
       password: new FormControl('', [Validators.required]),
       reenterpassword: new FormControl('', [Validators.required]),
       user_Gender: new FormControl('', [Validators.required]),
       userMobileNumber: new FormControl('', [Validators.required, Validators.maxLength(10)]),
       city: new FormControl('', [Validators.required]),
       state: new FormControl('', [Validators.required]),
       address: new FormControl('', [Validators.required]),
       pincode: new FormControl('', [Validators.required])
    },
    { validators: confirmPasswordValidator }
  );

    this.formRegister = new FormGroup({
      userId: new FormControl('', [Validators.required]),
      Cancel: new FormControl('')
    })

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

  }

  hide = signal(true);

  show = signal(true);

  clickEvent(event: MouseEvent) {
    this.hide.set(!this.hide());
    event.stopPropagation();
  }

  clickEventShow(event: MouseEvent) {
    this.show.set(!this.show());
    event.stopPropagation();
  }

  close()
  {
    window.location.reload();
  }

  detail!: User;

  pass!: Login;

  addr!: Address;

  result: String = "";

  userMobileNumber!: any;

  address!: any;

  addressGet!: any;

  storage!: any;

  city!: any;

  cityGet!: any;

  pincode!: any;

  pincodeGet!: any;

  state!: any;

  stateGet!: any;

  passwordData!: any;

  passwordGet!: any;

  firstName!: any;

  firstNameGetData!: any;

  userEmailId!: any;

  userEmailIdData!: any;

  insert(data: any) {
    console.log(data);
    this.detail.userFirstName = data.userFirstName;
    this.detail.userLastName = data.userLastName;
    this.detail.userEmailId = data.userEmailId;
    this.detail.userMobileNumber = data.userMobileNumber;
    this.detail.userDob = data.userDob;
    this.pass.loginUserName = data.userFirstName;
    this.pass.password = data.password;
    this.pass.user = 1;
    this.detail.user_Gender = data.user_Gender;
    this.detail.userType = "customer";
    this.addr.address = data.address;
    this.addr.city = data.city;
    this.addr.pincode = data.pincode;
    this.addr.state = data.state;
    this.addr.user = 1;
    this.userService.insertUserDetail(this.detail).subscribe((resultdata: any) => {
      this.result = resultdata;
      this.userMobileNumber = sessionStorage.setItem('userMobileNumber', data.userMobileNumber); 
      this.storage = sessionStorage.getItem('userMobileNumber');
      this.address = sessionStorage.setItem('address', data.address);
      this.addressGet = sessionStorage.getItem('address');
      this.city = sessionStorage.setItem('city', data.city);
      this.cityGet = sessionStorage.getItem('city');
      this.pincode = sessionStorage.setItem('pincode', data.pincode);
      this.pincodeGet = sessionStorage.getItem('pincode');
      this.state = sessionStorage.setItem('state', data.state);
      this.stateGet = sessionStorage.getItem('state');
      this.passwordData = sessionStorage.setItem('password', data.password);
      this.passwordGet = sessionStorage.getItem('password');
      this.firstName = sessionStorage.setItem('userFirstName', data.userFirstName);
      this.firstNameGetData = sessionStorage.getItem('userFirstName');
      this.userEmailId = sessionStorage.setItem('userEmailId', data.userEmailId);
      this.userEmailIdData = sessionStorage.getItem('userEmailId');
      console.log(this.storage);
    })

    this.ngOnInit();

    this.userService.getUser().subscribe((user) => {
      this.usersData = user;
      console.log(user);
    })

    this.dialogRef = this.dialog.open(this.registerDialog,
      { data: this.detail, height: '300px', width: '400px' });

    this.dialogRef.afterClosed().subscribe((result: User) => {
      console.log('The Register dialog was closed.');
    });
    // this.useraddress.insertAddressDetail(this.addr).subscribe((resultDetail: any) => {
    //   this.result = resultDetail;
    //   console.log(this.result);
    // })
    // this.userLoginService.insertLoginDetail(this.pass).subscribe((resultPassword: any) => {
    //   this.result = resultPassword;
    //   console.log(this.result);
    // })
}

userSellerId: any = "1";

insertRegister(dataGet: any)
{
  console.log(dataGet);
   this.addr.userId = dataGet.userId;
   this.addr.sellerId = this.userSellerId;
   this.addressGet = sessionStorage.getItem('address');
   this.cityGet = sessionStorage.getItem('city');
   this.pincodeGet = sessionStorage.getItem('pincode');
   this.stateGet = sessionStorage.getItem('state');
   this.addr.address = this.addressGet;
   this.addr.city = this.cityGet;
   this.addr.state = this.stateGet;
   this.addr.pincode = this.pincodeGet;
   console.log(dataGet);

   this.useraddress.insertAddressDetail(this.addr).subscribe((resultDetail: any) => {
   this.result = resultDetail;
   console.log(this.result);

   this.pass.userId = dataGet.userId;
   this.firstNameGetData = sessionStorage.getItem('userFirstName');
   this.pass.loginUserName = this.firstNameGetData;
   this.passwordGet = sessionStorage.getItem('password');
   this.pass.password = this.passwordGet;
   this.userEmailIdData = sessionStorage.getItem('userEmailId');
   this.pass.userEmailId = this.userEmailIdData;

   this.userLoginService.insertLoginDetail(this.pass).subscribe((resultPassword: any) => {
   this.result = resultPassword;
   console.log(this.result);
   })
   window.location.reload();
   sessionStorage.clear();
  })

}

deleteUserById(userId: any): void {
  console.log(userId);
  this.userService.deleteUserDetail(userId).subscribe(() => {
    this.users = this.users;
    window.location.reload();
    sessionStorage.clear();
  });
}

saveCancel: any;

saveCancelGet!: any;

save(cancel: any)
{
 console.log(cancel);
 this.saveCancel = sessionStorage.setItem('cancel', cancel);
 this.saveCancelGet = sessionStorage.getItem('cancel');
}

}