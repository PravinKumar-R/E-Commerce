import { Component, inject, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import { BreakpointObserver } from '@angular/cdk/layout';
import { ChangeDetectorRef } from '@angular/core';
import {
  MatDialog
} from '@angular/material/dialog';
import { SettingComponent } from '../Dialog/setting/setting.component';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrl: './side-nav.component.css'
})
export class SideNavComponent {

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;

  constructor(private observer: BreakpointObserver, private cdref: ChangeDetectorRef) {}

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