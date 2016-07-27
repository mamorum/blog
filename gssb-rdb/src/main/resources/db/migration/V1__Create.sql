create table memo (
	id serial primary key,
	text varchar(255) not null,
	version integer not null default 0,
	updated_time timestamp not null default current_timestamp,
	created_time timestamp not null default current_timestamp
);
