create table if not exists car(
    id int8 not null,
    model varchar not null,
    brand varchar not null,
    plate varchar not null,
    color varchar not null,
    date_enter timestamp,
    date_exit timestamp,
    primary key (id))
