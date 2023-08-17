create database dummy;
use dummy;

create table users ;
create table users(id int primary key auto_increment,
             Email varchar(10),Password varchar(20));
             
select * from users;

use dummy;
select * from users where mail='mohan@gmail.com' and pwd='mohan';
select * from users where mail='Mohan@gmail.com' and pwd='mohan';
select * from users;

