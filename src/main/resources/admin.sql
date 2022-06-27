insert into bdrestboot.users (id, age, email, last_name, name, password)
values (1, 1, 'admin@mail.ru', 'admin', 'admin', '$2a$12$SdmdpI5A1rlZkNExR9N/2e/8Z7f.wFdggcNllwuXoSgxpBukrXsVG
');

insert into bdrestboot.roles (id, role) VALUES (1, 'ADMIN');
insert into bdrestboot.roles (id, role) values (2, 'USER');

insert into bdrestboot.users_roles (user_id, role_id) VALUES (1, 1);