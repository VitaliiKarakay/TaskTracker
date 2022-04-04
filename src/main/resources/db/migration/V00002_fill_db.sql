use task_tracker_db;

insert into status (id, status_name)
values
    (1, 'new'),
    (2, 'WIP'),
    (3, 'done');

insert into departments (rolename)
values
    ('developer'),
    ('manager'),
    ('director');

insert into user(username, password, enabled) values
                                                   ('vkarakai','{bcrypt}$2a$10$Cg6FdM4IJtpVojq5hZhXNux8tkh/cgi0zjMn1XTUzuXDfP1mjmAbq',1),
                                                   ('okarakai','{bcrypt}$2a$10$VcGDtMQIMys6bExZmDuN0.xCwCJ1Yc0KO3gffO07NcwlVK9Th/YWy',1),
                                                   ('shatilov','{bcrypt}$2a$10$Qv66TUMOBCJR52HVrUxoUe/Wl6q013kZgG4XkpSUPzFgZh8AT6cVC',1);

insert into employees (name, surname, username, email, department_id) values
                                                                          ('Vitalii','Karakai','vkarakai','vkarakai@v.net',1),
                                                                          ('Olga','Karakai','okarakai','okarakai@v.net',2),
                                                                          ('Sergei','Hatilov','shatilov','shatilov@v.net',3);

insert into authorities (username, authority) values
                                                  ('vkarakai','developer'),
                                                  ('okarakai','manager'),
                                                  ('shatilov','director');

insert into user (username, password, enabled) values ('isapil','{bcrypt}$2a$10$pKyYR.vYHi4C071aR0RhOOyfpmwZJP9KbUZVyaCCel85LfC6PIblW',1);
