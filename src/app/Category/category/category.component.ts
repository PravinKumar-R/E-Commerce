import { BreakpointObserver } from '@angular/cdk/layout';
import { ChangeDetectorRef, Component, inject, ViewChild } from '@angular/core';
import { MatSidenav } from '@angular/material/sidenav';
import {
  MatDialog
} from '@angular/material/dialog';
import { SettingComponent } from '../../Dialog/setting/setting.component';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Category } from '../../model/category';
import { CategoryService } from '../../Service/category.service';
@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrl: './category.component.css'
})
export class CategoryComponent {
  
    form!: FormGroup;
  
    dataCategory!: Category;
  
    categoryData!: Category[];
  
    result: String = "";

    constructor(private observer: BreakpointObserver, private cdref: ChangeDetectorRef, private categoryService: CategoryService)
    {
      this.dataCategory =new Category();
    }
    
    ngOnInit()
    {
      this.form = new FormGroup({
      categoryName: new FormControl('',[Validators.required]),
      addedDate: new FormControl('', [Validators.required])
      })
      
      this.categoryService.getCategory().subscribe((category) => {
      this.categoryData = category;
      console.log(category);
      });
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
