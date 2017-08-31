create table devices (
  id                int not null AUTO_INCREMENT primary key ,
  inventory_nr      varchar(45),
  user              varchar(45),
  producer          varchar(45),
  model             varchar(45),
  series_nr         varchar(45),
  origin            varchar(45),
  date_of_purchase  varchar(45),
  type              varchar(45),
  status            varchar(45)
);

insert into devices(inventory_nr,user,producer,model,series_nr,origin,date_of_purchase,type,status)
            values("650032","","Dell","Latitude D430","8Z8Z337","","20.11.2013","Notebook","");

insert into devices(inventory_nr,user,producer,model,series_nr,origin,date_of_purchase,type,status)
            values("650037","","Dell","Precision M4400","FY7NX3J","","24.02.2009","Notebook","verkauft");

insert into devices(inventory_nr,user,producer,model,series_nr,origin,date_of_purchase,type,status)
            values("650038","","Dell","Latitude E6400","FLY564J","","29.01.2009","Notebook","");
            
insert into devices(inventory_nr,user,producer,model,series_nr,origin,date_of_purchase,type,status)
            values("651007","","Apple","Mac Mini","CO7G4476DJD0","Adam","28.10.2011","pc","");