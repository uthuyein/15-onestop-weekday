--insert into address_tbl(state,township,street)values('Yangon','Innsein','htantapin');
--
--insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-342342','09-2323','andrew@gmail.com')
--
--insert into customer_tbl(username,loginId,password,accountType,memberType)values('Andrew','andrew11','123','Customer','Silver');
--
--insert into category_tbl(name) values('Snacks');
--
--insert into product_size_tbl(name) values('Small');
--
--insert into product_tbl(name,category_id,productSize_id)values('Gar Gar',1,1);
--
--insert into admin_tbl(username,loginId,password,accountType)values('John','john111','222','Admin');
--
--insert into supplier_tbl(name) values ('John Doe');
--
--insert into pruchase_tbl(admin_id,createDate,createTime,supplier_id)values(1,'2022-10-12','02:20:11',1);


insert into address_tbl(state,township,street)values('Yangon','InnSein','HtanTaPin');
insert into address_tbl(state,township,street)values('Yangon','InnSein','YadanarMyaing');
insert into address_tbl(state,township,street)values('Yangon','InnSein','SiiSat');
insert into address_tbl(state,township,street)values('Yangon','Hlaing','ThanLann');
insert into address_tbl(state,township,street)values('Yangon','Hlaing','Zizawa');
insert into address_tbl(state,township,street)values('Yangon','Hlaing','GinnGar');
insert into address_tbl(state,township,street)values('Yangon','Hlaing','ThuKha');
insert into address_tbl(state,township,street)values('Yangon','PazunTaung','Zizawa');
insert into address_tbl(state,township,street)values('Yangon','PazunTaung','Thazin');
insert into address_tbl(state,township,street)values('Yangon','PazunTaung','HninSi');


insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-123456','09-232321','andrew@gmail.com');
insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-123457','09-232322','john@gmail.com');
insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-123458','09-232323','derrek@gmail.com');
insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-123459','09-232324','mercy@gmail.com');
insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-213456','09-232325','annie@gmail.com');
insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-213457','09-232326','marrie@gmail.com');
insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-213458','09-232327','herry@gmail.com');
insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-213459','09-232328','elle@gmail.com');
insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-321456','09-232329','hawsey@gmail.com');
insert into contact_tbl(primaryPhone,secondaryPhone,email)values('09-321457','09-232320','martin@gmail.com');

insert into customer_tbl(username,loginId,password,accountType,memberType,address_id,contact_id)values('Andrew','andrew11','123','Customer','Silver',1,1);
insert into customer_tbl(username,loginId,password,accountType,memberType,address_id,contact_id)values('John','john11','124','Customer','Gold',2,2);
insert into customer_tbl(username,loginId,password,accountType,memberType,address_id,contact_id)values('Derrek','derrek11','125','Customer','Diamond',3,3);
insert into customer_tbl(username,loginId,password,accountType,memberType,address_id,contact_id)values('Mercy','mercy11','126','Customer','Silver',4,4);
insert into customer_tbl(username,loginId,password,accountType,memberType,address_id,contact_id)values('Annie','annie11','127','Customer','Gold',5,5);
insert into customer_tbl(username,loginId,password,accountType,memberType,address_id,contact_id)values('Marrie','marrie11','128','Customer','Diamond',6,6);
insert into customer_tbl(username,loginId,password,accountType,memberType,address_id,contact_id)values('Herry','herry11','129','Customer','Silver',7,7);          
insert into customer_tbl(username,loginId,password,accountType,memberType,address_id,contact_id)values('Elle','elle11','212','Customer','Gold',8,8);           
insert into customer_tbl(username,loginId,password,accountType,memberType,address_id,contact_id)values('Halcy','hawsey11','213','Customer','Diamond',9,9);          
insert into customer_tbl(username,loginId,password,accountType,memberType,address_id,contact_id)values('Martin','martin11','214','Customer','Silver',10,10);         


insert into category_tbl(name) values('Snacks');
insert into category_tbl(name) values('Fruits');
insert into category_tbl(name) values('CoolDrinks');
insert into category_tbl(name) values('InstantFoods');
insert into category_tbl(name) values('HotDrinks');
insert into category_tbl(name) values('FruitDrinks');
insert into category_tbl(name) values('Vegetables');
insert into category_tbl(name) values('EnergyDrinks');
insert into category_tbl(name) values('RiceBox');
insert into category_tbl(name) values('Furniture');

insert into product_size_tbl(name) values ('Small');
insert into product_size_tbl(name) values ('Medium');
insert into product_size_tbl(name) values ('Large');
insert into product_size_tbl(name) values ('Small');
insert into product_size_tbl(name) values ('Medium');
insert into product_size_tbl(name) values ('Large');
insert into product_size_tbl(name) values ('Small');
insert into product_size_tbl(name) values ('Medium');
insert into product_size_tbl(name) values ('Large');
insert into product_size_tbl(name) values ('Small');

insert into product_tbl(name,category_id,productSize_id) values ('Gar Gar',1,10);
insert into product_tbl(name,category_id,productSize_id) values ('Apple',2,9);
insert into product_tbl(name,category_id,productSize_id) values ('Yogurt',3,8);
insert into product_tbl(name,category_id,productSize_id) values ('YumYum',4,7);
insert into product_tbl(name,category_id,productSize_id) values ('Coffee',5,6);
insert into product_tbl(name,category_id,productSize_id) values ('AvocadoDrink',6,5);
insert into product_tbl(name,category_id,productSize_id) values ('Broccoli',7,4);
insert into product_tbl(name,category_id,productSize_id) values ('Shark',8,3);
insert into product_tbl(name,category_id,productSize_id) values ('Victor',9,2);
insert into product_tbl(name,category_id,productSize_id) values ('Blanket',10,1);

insert into admin_tbl(username,loginId,password,accountType) values ('John','john111','222','Admin');
insert into admin_tbl(username,loginId,password,accountType) values ('Andrew','adrew11','123','Customer');
insert into admin_tbl(username,loginId,password,accountType) values ('Derrek','derrek11','125','Cashier');
insert into admin_tbl(username,loginId,password,accountType) values ('Mercy','mercy11','126','Admin');
insert into admin_tbl(username,loginId,password,accountType) values ('Annie','annie11','127','Customer');
insert into admin_tbl(username,loginId,password,accountType) values ('Marrie','marrie11','128','Cashier');
insert into admin_tbl(username,loginId,password,accountType) values ('Herry','herry11','129','Admin');
insert into admin_tbl(username,loginId,password,accountType) values ('Elle','elle11','212','Customer');
insert into admin_tbl(username,loginId,password,accountType) values ('Halcy','halcy11','213','Cashier');
insert into admin_tbl(username,loginId,password,accountType) values ('Martin','martin11','214','Admin');

insert into supplier_tbl(name) values ('John Doe');
insert into supplier_tbl(name) values ('Andrew Saw');
insert into supplier_tbl(name) values ('Derrek J');
insert into supplier_tbl(name) values ('Mercy Linn');
insert into supplier_tbl(name) values ('Annie M');
insert into supplier_tbl(name) values ('Marrie A');
insert into supplier_tbl(name) values ('Herry Jane');
insert into supplier_tbl(name) values ('Elle Venus');
insert into supplier_tbl(name) values ('Halcy Grace');
insert into supplier_tbl(name) values ('Martin Drew');

--insert into purchase_tbl(admin_id,createDate,createTime,supplier_id) values (1,'2022-10-12','02:20:11',1);
--insert into purchase_tbl(admin_id,createDate,createTime,supplier_id) values (1,'2022-10-13','02:20:12',1);
--insert into purchase_tbl(admin_id,createDate,createTime,supplier_id) values (1,'2022-10-14','02:20:13',1);
--insert into purchase_tbl(admin_id,createDate,createTime,supplier_id) values (1,'2022-10-15','02:20:14',1);
--insert into purchase_tbl(admin_id,createDate,createTime,supplier_id) values (1,'2022-10-16','02:20:15',1);
--insert into purchase_tbl(admin_id,createDate,createTime,supplier_id) values (1,'2022-10-17','02:20:16',1);
--insert into purchase_tbl(admin_id,createDate,createTime,supplier_id) values (1,'2022-10-18','02:20:17',1);
--insert into purchase_tbl(admin_id,createDate,createTime,supplier_id) values (1,'2022-10-19','02:20:18',1);
--insert into purchase_tbl(admin_id,createDate,createTime,supplier_id) values (1,'2022-10-21','02:20:19',1);
--insert into purchase_tbl(admin_id,createDate,createTime,supplier_id) values (1,'2022-10-22','02:20:21',1);