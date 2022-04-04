create database task_tracker_db;
use task_tracker_db;

create table departments (
                             id int NOT NULL auto_increment,
                             rolename varchar(50),

                             primary key (id)
);

create table user (
                       username varchar(15) primary key,
                       password varchar(15),
                       enabled TINYINT(1)
);

alter table user modify password varchar(100);

create table authorities (
                             username varchar(15),
                             authority varchar (15),

                             FOREIGN KEY (username) references user(username)
);

create table status (
                          id int not null,
                          status_name varchar(50),
                          primary key (id)
);

create table employees (
                           id int not null auto_increment,
                           name varchar (50),
                           surname varchar(50),
                           username varchar(50) unique,
                           email varchar(50),
                           department_id int,
                           primary key (id),

                           foreign key (department_id) references departments(id),
                           foreign key (username) references user(username)
);

create table task (
                       id int not null auto_increment,
                       shortname varchar(50),
                       developer int,
                       status int,
                       done boolean,

                       primary key (id),
                       foreign key (status) references status(id),
                       foreign key (developer) references employees(id)
);

create table employee_task (
                               emp_id int,
                               task_id int,

                               foreign key (emp_id) references employees(id),
                               foreign key (task_id) references task(id)
);