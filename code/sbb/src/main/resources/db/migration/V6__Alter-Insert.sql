alter table users add authority varchar(50) not null default 'USER';

--- for admin user.
insert into users (username, password, enabled, authority)
	values ('admin@sbb.com', 'admin', true, 'ADMIN');

