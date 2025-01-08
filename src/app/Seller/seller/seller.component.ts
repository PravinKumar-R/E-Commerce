import { ChangeDetectorRef, Component, inject, TemplateRef, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import {
  MatDialog
} from '@angular/material/dialog';
import { Seller } from '../../model/seller';
import { BreakpointObserver } from '@angular/cdk/layout';
import { SellerService } from '../../Service/seller.service';
import { MatSidenav } from '@angular/material/sidenav';
import { SettingComponent } from '../../Dialog/setting/setting.component';
import { Address } from '../../model/address';
import { UserAddressService } from '../../Service/user-address.service';
@Component({
  selector: 'app-seller',
  templateUrl: './seller.component.html',
  styleUrl: './seller.component.css'
})
export class SellerComponent {

  form!: FormGroup;
  
  dataSeller!: Seller;
  
  sellerData!: Seller[];
  
  result: String = "";
  
  dialogRef: any;

  @ViewChild('myRegisterDialog') registerDialog = {} as TemplateRef<Seller>;

  addr!: Address;

  address!: any;

  addressGet!: any;

  city!: any;

  cityGet!: any;

  pincode!: any;

  pincodeGet!: any;

  state!: any;

  stateGet!: any;

  formRegister!: FormGroup;

  seller!: Seller[];

  addresses: Address[] = [];

  sellersData!: Seller[];

  saveCancel!: any;

  saveCancelGet!: any;

  sellerPhoneNumber!: any;

  storage!: any;

  cancel: any = 'Updated';

  constructor(private observer: BreakpointObserver, private cdref: ChangeDetectorRef, private sellerService: SellerService, private useraddress: UserAddressService)
  {
    this.dataSeller =new Seller();
    this.addr = new Address();
    // this.saveCancel = sessionStorage.setItem('cancel', this.cancel);
    // this.saveCancelGet = sessionStorage.getItem('cancel');
  }
  
  ngOnInit()
  {
    this.form = new FormGroup({
    sellerName: new FormControl('',[Validators.required]),
    addedDate: new FormControl('', [Validators.required]),
    sellerRate: new FormControl('',[Validators.required]),
    sellerPhoneNumber: new FormControl('',[Validators.required]),
    city: new FormControl('', [Validators.required]),
    state: new FormControl('', [Validators.required]),
    address: new FormControl('', [Validators.required]),
    pincode: new FormControl('', [Validators.required])
    })
  
    this.sellerService.getSeller().subscribe((seller) => {
    this.sellerData = seller;
    console.log(seller);
    });

    this.formRegister = new FormGroup({
      sellerId: new FormControl('', [Validators.required]),
      Cancel: new FormControl('')
    })

    this.useraddress.getAddress().subscribe((address) => {
      this.addresses = address;
      console.log(address);
    })

  }
      
  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;
      
  ngAfterViewInit() {
    this.observer.observe(["(max-width: 800px)"]).subscribe((res) => {
      if (res.matches) {
        this.sidenav.mode = "over";
        this.sidenav.close();
        this.sidenav.open();
      } else {
        this.sidenav.mode = "side";
        this.sidenav.open();
      }
        this.cdref.detectChanges();
        });
      }
      
  toggleSideNavBarClose()
    {
      if(this.sidenav.mode = "side")
        {
          this.sidenav.close();
        }
        else{
          this.sidenav.open();
        }
    }
      
  toggleSideNavBaropen()
    {
      if(this.sidenav.mode = "over")
       {
          this.sidenav.open();
       }
    }
      
  readonly dialog = inject(MatDialog);
      
  openDialog(enterAnimationDuration: string, exitAnimationDuration: string): void {
    this.dialog.open(SettingComponent, {
      width: '400px',
      enterAnimationDuration,
      exitAnimationDuration,
    });
  }
  
  add(data: any)
  {
    console.log(data);
    this.dataSeller.sellerName = data.sellerName;
    this.dataSeller.addedDate = data.addedDate;
    this.dataSeller.sellerPhoneNumber = data.sellerPhoneNumber;
    this.dataSeller.sellerRate = data.sellerRate;
    this.addr.address = data.address;
    this.addr.city = data.city;
    this.addr.pincode = data.pincode;
    this.addr.state = data.state;
    this.sellerService.insertSellerDetail(this.dataSeller).subscribe((resultdata: any) => {
      this.result = resultdata;
      this.sellerPhoneNumber = sessionStorage.setItem('sellerPhoneNumber', data.sellerPhoneNumber); 
      this.storage = sessionStorage.getItem('sellerPhoneNumber');
      this.address = sessionStorage.setItem('address', data.address);
      this.addressGet = sessionStorage.getItem('address');
      this.city = sessionStorage.setItem('city', data.city);
      this.cityGet = sessionStorage.getItem('city');
      this.pincode = sessionStorage.setItem('pincode', data.pincode);
      this.pincodeGet = sessionStorage.getItem('pincode');
      this.state = sessionStorage.setItem('state', data.state);
      this.stateGet = sessionStorage.getItem('state');
      console.log(resultdata);
      })
    this.ngOnInit();

    this.sellerService.getSeller().subscribe((seller) => {
    this.sellersData = seller;
    console.log(seller);
    });

    this.dialogRef = this.dialog.open(this.registerDialog,
    { data: this.dataSeller, height: '300px', width: '400px' });
    
    this.dialogRef.afterClosed().subscribe((result: Seller) => {
    console.log('The Register dialog was closed.');
    });
  }

  deleteSellerById(sellerId: any): void {
    console.log(sellerId);
    this.sellerService.deleteSellerDetail(sellerId).subscribe(() => {
      this.seller = this.seller;
      window.location.reload();
      sessionStorage.clear();
    });
  }
 
  sellerUserId: any = "1";

  insertSeller(dataGet: any)
{
  console.log(dataGet);
   this.addr.sellerId = dataGet.sellerId;
   this.addr.userId = this.sellerUserId;
   this.addressGet = sessionStorage.getItem('address');
   this.cityGet = sessionStorage.getItem('city');
   this.pincodeGet = sessionStorage.getItem('pincode');
   this.stateGet = sessionStorage.getItem('state');
   this.addr.address = this.addressGet;
   this.addr.city = this.cityGet;
   this.addr.state = this.stateGet;
   this.addr.pincode = this.pincodeGet;
   console.log(dataGet);
   console.log(this.addr);

   this.useraddress.insertAddressDetail(this.addr).subscribe((resultDetail: any) => {
   this.result = resultDetail;
   console.log(this.result);

   window.location.reload();
   sessionStorage.clear();
  })
}

save(cancel: any)
{
 console.log(cancel);
 this.saveCancel = sessionStorage.setItem('cancel', cancel);
 this.saveCancelGet = sessionStorage.getItem('cancel');
}

}