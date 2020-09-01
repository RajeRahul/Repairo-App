SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP DATABASE IF EXISTS db1;

create database if not exists db1;
use db1;

drop table if exists db1.repairemen;
drop table if exists db1.servicerequests;

create table if not exists repairemen(
	id int not null primary key auto_increment,
    first_name varchar(30),
    last_name varchar(30),
    occupation varchar(50),
    location varchar(200),
    base_price int,
    skills varchar(500),
    rating float(1)
);

create table if not exists servicerequests(
	requestId int not null primary key auto_increment,
    repairmanId int not null,
    user_first_name varchar(50),
    user_last_name varchar(50),
    user_email varchar(100),
    user_phone varchar(20),
    user_address varchar(200),
    user_problem varchar(200),
    foreign key(repairmanId) references repairemen(id)
);

/*
To import csv file in table repairemen:
1. Right click on the Table repairemen from Navigator window.
2. Select Table Data Import Wizard
3. Select the csv file
4. Import into the table
*/
