create table persons
(
    identity    integer not null
        constraint persons_pkey
            primary key,
    first_name  varchar(40),
    second_name varchar(50),
    birthday    date,
    address     varchar(250)
);

alter table persons
    owner to admin;

