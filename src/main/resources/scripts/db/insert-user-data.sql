insert into users (id, username, password) values
(1, 'james', 'password');

insert into authorities (id, name) values
(1, 'read'),
(2, 'write');

insert into users_authorities (user_id, authority_id) values
(1, 1);