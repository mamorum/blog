create table users (
	id serial primary key,
	username varchar(50) not null,
	password varchar(50) not null,
	enabled boolean not null,
	version integer not null default 1,
	created_time timestamp not null default current_timestamp
);

create table customer (
	id serial primary key,
	user_id integer not null references users(id),
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	version integer not null default 1,
	created_time timestamp not null default current_timestamp
);
