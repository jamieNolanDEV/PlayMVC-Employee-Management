# --- !Ups

insert into user (email,name,password,role) values ('admin@java.com', 'Admin', 'password', 'admin' );

insert into user (email,name,password,role) values ('employee@java.com', 'Employee', 'password', 'Employee' );

insert into user (email,name,password,role) values ('user@java.com', 'User', 'password', 'User');

insert into department  values (1,'HR');
insert into department  values (2,'Coding');
insert into department  values (3,'QA');

insert into address values (1,'Dublin');
insert into address values (2,'Kildare');
insert into address values (3,'Wicklow');
insert into address values (4, 'Cavan');

insert into employee values (1,1,1,'John');
insert into employee values (2,1,2,'Jim');
insert into employee values (3,2,3,'Paul');
insert into employee values (4,3,4,'Peter');


insert into project values (1,'Coding');
insert into project values (2,'Manage Coders');
insert into project values (3,'Quality Test');

insert into project_employee values (1,1);
insert into project_employee values (1,2);
insert into project_employee values (2,1);
insert into project_employee values (3,1);

