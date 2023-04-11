insert into roles(rolename) values ('USER'), ('ADMIN');
insert into users(username, password) values ('Gert','$2a$10$.08U.zhqxJ0YbWR9V3frf.YZZOiWgirH1Qz3jLpovlH9gNHeoUzKO');
insert into users(username, password) values ('Samson','$2a$10$.08U.zhqxJ0YbWR9V3frf.YZZOiWgirH1Qz3jLpovlH9gNHeoUzKO');
insert into users_roles(users_username, roles_rolename) values ('Gert', 'ADMIN');
insert into users_roles(users_username, roles_rolename) values ('Samson', 'USER');