--- fix for authority value to add 'ROLE_' prefix.

alter table users alter column authority set default 'ROLE_USER';

update users set authority = 'ROLE_' || authority;
