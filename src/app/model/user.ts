import { Address } from "./address";
import { Login } from "./login";

export class User {
    userFirstName!: String;
    userLastName!: String;
    userId!: number;
    userEmailId!: String;
    userDob!: Date;
    user_Gender!: String;
    userType!: String;
    userMobileNumber!: number;
    address!: Address;
    login!: Login;
}