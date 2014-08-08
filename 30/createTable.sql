use Product


drop table Products

create table Products(
ProductID int identity(1,1) primary key,
 ProductName varchar(200)not null, 
 UnitPrice money not null,
 UnitsInStock int not null
 )
 
 insert into Products values('iogurte danone',0.45,100)
 insert into Products values('banana',0.10,20)
 insert into Products values('bolacha maria',1.10,100)
 insert into Products values('leite mimosa',0.54,300)
 insert into Products values('sapato',40.0,500)
 
 select *
 from Products
 