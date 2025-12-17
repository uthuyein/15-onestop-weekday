insert into address_tbl(state,township,street)values('Yangon','Innsein','htantapin');

insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-342342','09-2323','andrew@gmail.com')

insert into customer_tbl(username,loginId,password,accountType,memberType)values('Andrew','andrew11','123','Customer','Silver');

insert into category_tbl(name) values('Snacks');

insert into product_size_tbl(name) values('Small');

insert into product_tbl(name,category_id,productSize_id)values('Gar Gar',1,1);

insert into admin_tbl(username,loginId,password,accountType)values('John','john111','222','Admin');

insert into supplier_tbl(name) values ('John Doe');

insert into pruchase_tbl(admin_id,createDate,createTime,supplier_id)values(1,'2022-10-12','02:20:11',1);