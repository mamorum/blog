create table tsubuyaki (
  id serial primary key,
  txt varchar(100) not null,
  version integer not null default 0,
  updated_time timestamp not null default current_timestamp,
  created_time timestamp not null default current_timestamp
);
