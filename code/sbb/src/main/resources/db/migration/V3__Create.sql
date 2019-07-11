create table user_info (
	id serial primary key,
	user_id integer not null references users(id),
	first_name varchar(50),
	last_name varchar(50),
	first_name_kana varchar(50),
	last_name_kana varchar(50),
	version integer not null default 1,
	created_time timestamp not null default current_timestamp
);
