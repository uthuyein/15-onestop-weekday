
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

insert into product_tbl(name,category_id,productSize_id) values ('Gar Gar',1,1);
insert into product_tbl(name,category_id,productSize_id) values ('Apple',2,2);
insert into product_tbl(name,category_id,productSize_id) values ('Yogurt',3,3);
insert into product_tbl(name,category_id,productSize_id) values ('YumYum',4,1);
insert into product_tbl(name,category_id,productSize_id) values ('Coffee',5,2);
insert into product_tbl(name,category_id,productSize_id) values ('AvocadoDrink',6,3);
insert into product_tbl(name,category_id,productSize_id) values ('Broccoli',7,1);
insert into product_tbl(name,category_id,productSize_id) values ('Shark',8,2);
insert into product_tbl(name,category_id,productSize_id) values ('Victor',9,2);
insert into product_tbl(name,category_id,productSize_id) values ('Blanket',10,1);
insert into product_tbl(name,category_id,productSize_id) values ('Shwe Man May',1,1);

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

insert into cashier_tbl (username, loginId, password, accountType) values ('Gojo', 'gojo', '123', 'Cashier');
insert into cashier_tbl (username, loginId, password, accountType) values ('Megumi', 'megumi', '456', 'Cashier');

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

insert into purchase_tbl (admin_id, createDate, createTime, supplier_id) values (1, '2022-10-12', '02:20:11', 1);
insert into purchase_tbl (admin_id, createDate, createTime, supplier_id) values (2, '2022-11-05', '10:15:30', 2);
insert into purchase_tbl (admin_id, createDate, createTime, supplier_id) values (1, '2022-12-01', '14:45:00', 3);
insert into purchase_tbl (admin_id, createDate, createTime, supplier_id) values (2, '2023-01-10', '09:20:15', 1);
insert into purchase_tbl (admin_id, createDate, createTime, supplier_id) values (1, '2023-02-18', '13:50:40', 2);
insert into purchase_tbl (admin_id, createDate, createTime, supplier_id) values (2, '2023-03-22', '11:05:30', 3);

insert into purchase_detail_tbl (product_id, purchase_id, price, qty) values (1, 1, 500, 30);
insert into purchase_detail_tbl (product_id, purchase_id, price, qty) values (2, 2, 800, 20);
insert into purchase_detail_tbl (product_id, purchase_id, price, qty) values (3, 3, 450, 40);
insert into purchase_detail_tbl (product_id, purchase_id, price, qty) values (1, 4, 500, 25);
insert into purchase_detail_tbl (product_id, purchase_id, price, qty) values (2, 5, 800, 30);
insert into purchase_detail_tbl (product_id, purchase_id, price, qty) values (3, 6, 450, 35);

insert into sale_tbl (customer_id, cashier_id, saleDate, saleTime) values (1, 1, '2025-05-20', '04:25:10');
insert into sale_tbl (customer_id, cashier_id, saleDate, saleTime) values (2, 2, '2025-05-21', '05:10:30');
insert into sale_tbl (customer_id, cashier_id, saleDate, saleTime) values (3, 1, '2025-05-22', '06:40:15');
insert into sale_tbl (customer_id, cashier_id, saleDate, saleTime) values (1, 2, '2025-05-23', '07:15:50');
insert into sale_tbl (customer_id, cashier_id, saleDate, saleTime) values (2, 1, '2025-05-24', '08:30:20');
insert into sale_tbl (customer_id, cashier_id, saleDate, saleTime) values (3, 2, '2025-05-25', '09:50:45');

insert into sale_price_tbl (product_id, price, createDate) values (1, 500, '2022-10-30');
insert into sale_price_tbl (product_id, price, createDate) values (2, 800, '2022-10-30');
insert into sale_price_tbl (product_id, price, createDate) values (3, 450, '2022-10-30');
insert into sale_price_tbl (product_id, price, createDate) values (1, 500, '2022-11-10');
insert into sale_price_tbl (product_id, price, createDate) values (2, 800, '2022-11-15');
insert into sale_price_tbl (product_id, price, createDate) values (3, 450, '2022-11-20');

INSERT INTO sale_detail_tbl (sale_id, salePrice_id, qty, subTotal, saleDate, saleTime) VALUES (1, 1, 2, 1000, '2025-05-20', '04:25:10');
INSERT INTO sale_detail_tbl (sale_id, salePrice_id, qty, subTotal, saleDate, saleTime) VALUES (2, 2, 1, 800, '2025-05-21', '05:10:30');
INSERT INTO sale_detail_tbl (sale_id, salePrice_id, qty, subTotal, saleDate, saleTime) VALUES (3, 3, 3, 1350, '2025-05-22', '06:40:15');
INSERT INTO sale_detail_tbl (sale_id, salePrice_id, qty, subTotal, saleDate, saleTime) VALUES (4, 4, 1, 500, '2025-05-23', '07:15:50');
INSERT INTO sale_detail_tbl (sale_id, salePrice_id, qty, subTotal, saleDate, saleTime) VALUES (5, 5, 2, 1600, '2025-05-24', '08:30:20');
INSERT INTO sale_detail_tbl (sale_id, salePrice_id, qty, subTotal, saleDate, saleTime) VALUES (6, 6, 1, 450, '2025-05-25', '09:50:45');

