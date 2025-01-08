import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { MatButtonModule} from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import {MatSidenavModule } from '@angular/material/sidenav';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDividerModule } from '@angular/material/divider';
import { SideNavComponent } from './side-nav/side-nav.component';
import { RouterOutlet } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { SettingComponent } from './Dialog/setting/setting.component';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatRadioModule} from '@angular/material/radio';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatCardModule} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
import { LoginComponent } from './Login/login/login.component';
import {TextFieldModule} from '@angular/cdk/text-field';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { RegisterComponent } from './Register/register/register.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import { UserComponent } from './user/user.component';
import { RegiterSuccessComponent } from './Dialog/regiter-success/regiter-success.component';
import { ForgetPasswordComponent } from './ForgetPassword/forget-password/forget-password.component';
import { CategoryComponent } from './Category/category/category.component';
import { CategoryAddComponent } from './Category/category-add/category-add.component';
import { ProductAddComponent } from './Product/product-add/product-add.component';
import { ProductComponent } from './Product/product/product.component';
import { SellerComponent } from './Seller/seller/seller.component';
import {MatGridListModule} from '@angular/material/grid-list';

@NgModule({
  declarations: [
    AppComponent,
    SideNavComponent,
    SettingComponent,
    LoginComponent,
    RegisterComponent,
    UserComponent,
    RegiterSuccessComponent,
    ForgetPasswordComponent,
    CategoryComponent,
    CategoryAddComponent,
    ProductAddComponent,
    ProductComponent,
    SellerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatDividerModule,
    HttpClientModule,
    RouterOutlet,
    MatCheckboxModule,
    MatRadioModule,
    FormsModule,
    MatCardModule,
    MatProgressBarModule,
    MatChipsModule,
    TextFieldModule,
    MatInputModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule ,
    MatSelectModule,
    ReactiveFormsModule,
    MatGridListModule
  ],
  providers: [
    provideClientHydration(),
    MatNativeDateModule 
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
