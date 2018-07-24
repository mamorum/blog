create table memo (
  id serial primary key,
  txt varchar(200) not null,
  updated timestamp not null default current_timestamp,
  created timestamp not null default current_timestamp
);

create table person (
  id serial primary key,
  name varchar(100) not null,
  updated timestamp not null default current_timestamp,
  created timestamp not null default current_timestamp
);
