import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SideNavComponent } from './side-nav/side-nav.component';
import { LoginComponent } from './Login/login/login.component';
import { RegisterComponent } from './Register/register/register.component';
import { UserComponent } from './user/user.component';
import { CategoryComponent } from './Category/category/category.component';
import { CategoryAddComponent } from './Category/category-add/category-add.component';
import { ProductComponent } from './Product/product/product.component';
import { ProductAddComponent } from './Product/product-add/product-add.component';
import { SellerComponent } from './Seller/seller/seller.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  // {path: '', component:LoginComponent},
  {path: '', component: SideNavComponent},
  {path: 'homePage', component:SideNavComponent},
  {path: 'user', component:UserComponent},
  {path: 'category', component:CategoryComponent},
  {path: 'categoryAdd', component:CategoryAddComponent},
  {path: 'product', component: ProductComponent},
  {path: 'productAdd', component: ProductAddComponent},
  {path: 'sellerAdd', component: SellerComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
