create table users
(
    id        serial not null,
    user_name varchar,
    user_pass varchar(255)
);

create unique index users_id_uindex
    on users (id);

alter table users
    add constraint users_pk
        primary key (id);

INSERT INTO users (id, user_name, user_pass)
VALUES (1, 'admin', '$2y$04$jJXOn493TbMM.mSGE5ICSeCEKc4K3Z86aNHGhdRPLdQGR4pBODhTC'),
       (2, 'user', '$2y$04$m6sH/T1EeBwZC7LqHTa2t.QH02qpDkdJiZz0W8YmP.ds119fPeV/m');