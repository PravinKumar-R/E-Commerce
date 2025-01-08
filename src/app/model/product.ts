import { Category } from "./category";
import { Seller } from "./seller";

export class Product {
    productId!: number;
    productName!: String;
    addedDate!: Date;
    productAmount!: number;
    manufactureDate!: Date;
    productQuality!: number;
    categoryId!: Category;
    sellerId!: Seller;
}