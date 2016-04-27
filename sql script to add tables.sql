CREATE DATABASE `project` /*!40100 DEFAULT CHARACTER SET utf8 */;

use project;
create table user_details(
	id int primary key,
    name varchar(50),
    age int check(age>=18),
    address varchar(100),
    gender char check(gender='M'|| gender='F'),
    user_since date,
    city varchar(50)
);

create table user(
	id int references user_details(id) primary key,
    mobile bigint primary key,
    type char(20)
);

create table prepaid_account(
	mobile bigint primary key,
    balance int,
    account_since date,
    plan_id int references plan_details(pid),
    calls int, msgs int,data int
    check(balance>=0 && calls>=0 && data>=0 && msgs>=0)
);
create table postpaid_account(
	mobile bigint primary key,
    account_since date,
    plan_id int references plan_details(pid),
    calls int, msgs int,data int
    check(calls>=0 && data>=0 && msgs>=0)
);

create table plan_details(
	pid int primary key,
    calls int, msgs int,data int,
    type char(20),
    price int
    check(calls>=0 && data>=0 && msgs>=0 && price>=0)
);

create table recharges(
	mobile bigint primary key references user(mobile),
    date date,
    amount int
	
    check(amount>0)
);

create table bills(
	mobile bigint primary key references user(mobile),
    month date,
    amount int,
    ispaid boolean default false,
    payment_date date,
    check(payment_date>=date && amount>=0)
);
