create database e_commerce;
use e_commerce;
show tables;
select * from tbl_user;
insert into tbl_user values(6,'2008-01-13','rts@gmail.com','Sahayam','Kumar',6369755541,'customer','Female');
select * from tbl_user_address;
insert into tbl_user_address values(6,'40 Sun Street','Thenthiruperi',628053,'Tamilnadu',6);
select * from tbl_login;
insert into tbl_login values(3,"Preethi","Password@11948",3);
select * from tbl_category;
select * from tbl_seller;
alter table tbl_seller drop column address_id;
ALTER TABLE tbl_category DROP COLUMN user_id;