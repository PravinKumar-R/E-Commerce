import { Seller } from "./seller";
import { User } from "./user";

export class Address {
    addressId!: number;
    address!: String;
    city!: String;
    state!: String;
    pincode!: number;
    user!: any;
    userId!: User;
    seller!: any;
    sellerId!: Seller;
}