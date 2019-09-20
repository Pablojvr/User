/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  kevin
 * Created: 09-11-2019
 */

create database authors;
use authors;
create table literarygenre(
id int primary key auto_increment,
name varchar(20));
create table authors(
id int primary key auto_increment,
name varchar(60),
birth date,
number varchar(30),
literarygenreid int,
constraint ck_authors
foreign key (literarygenreid) references literarygenre(id)
);
insert into literarygenre (name) values ('Drama'),('Poem'),('Prose'),('Horror');
insert into authors (name, birth, number, literarygenreid) values
('Edgar Allan Poe',STR_TO_DATE('19-01-1980','%d-%m-%Y'),'2222-2222',4),
('William Shakespeare',STR_TO_DATE('01-01-1564','%d-%m-%Y'),'2344-5678',1);