import { Component, inject, ViewChild } from '@angular/core';
import { UserServiceService } from '../Service/user-service.service';
import { User } from '../model/user';
import { UserAddressService } from '../Service/user-address.service';
import { Address } from '../model/address';
import { MatSidenav } from '@angular/material/sidenav';
import { BreakpointObserver } from '@angular/cdk/layout';
import { ChangeDetectorRef } from '@angular/core';
import {
  MatDialog
} from '@angular/material/dialog';
import { SettingComponent } from '../Dialog/setting/setting.component';
@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrl: './user.component.css'
})
export class UserComponent {

  users: User[] = [];

  addresses!: Address[];

  constructor(private userService: UserServiceService, private useraddress: UserAddressService, private observer: BreakpointObserver, private cdref: ChangeDetectorRef)
  {

  }
  ngOnInit()
  {
    this.userService.getUser().subscribe((user) => {
      this.users = user;
      console.log(user);
    });

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
}
