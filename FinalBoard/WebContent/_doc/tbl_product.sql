drop table if exists tbl_product;

create table tbl_product (
pno bigint(20) not null auto_increment,
category varchar(100) default null,
pname varchar(200) default null,
pcontent varchar(2000) default null,
pwriter varchar(100) not null,
readcount int(11) default 0,
regdate timestamp not null default current_timestamp on update current_timestamp,
moddate timestamp not null default current_timestamp on update current_timestamp,
imgfile varchar(2000) default null,
primary key(pno)
) ENGINE=InnoDB default charset=utf8;
