create table if not exists client(
  id int8 not null,
  name varchar not null,
  phone varchar not null,
  status bool not null,
  primary key (id));