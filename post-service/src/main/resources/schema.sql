drop table if exists POST;

create table POST
(
    user_id number,
    id      number primary key not null,
    title   varchar2,
    body    varchar2
);