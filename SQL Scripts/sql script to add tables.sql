CREATE DATABASE `project` /*!40100 DEFAULT CHARACTER SET utf8 */;

use project;
create table user_details(
	id int primary key auto_increment,
    name varchar(50),
    age int check(age>=18),
    gender char check(gender='M'|| gender='F'),
	isactive boolean default true,
    city varchar(50)
);

create table user(
	id int references user_details(id),
    mobile bigint,
    primary key(id,mobile)
);

create table prepaid_account(
	mobile bigint primary key references user(mobile),
    balance int,
    plan_id int references plan_details(pid),
    calls int, msgs int,data int
    check(balance>=0 && calls>=0 && data>=0 && msgs>=0)
);
create table postpaid_account(
	mobile bigint primary key references user(mobile),
    plan_id int references plan_details(pid),
    calls int, msgs int,data int
    check(calls>=0 && data>=0 && msgs>=0)
);

create table plan_details(
	pid int primary key auto_increment,
    calls int, msgs int,data int,
    type char(20),
    price int
    check(calls>=0 && data>=0 && msgs>=0 && price>=0)
);


create table bills(
	mobile bigint references user(mobile),
    month date,
    amount int,
	planid int references plan_details(pid),
    ispaid boolean default false,
    check(payment_date>=date && amount>=0),
	primary key(mobile,month)
);
