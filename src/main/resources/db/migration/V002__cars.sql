create table cars
(
    id  serial not null
        constraint cars_pk
            primary key,
    model_name varchar
);

INSERT INTO cars (id, model_name)
VALUES (1, 'Toyota'),
       (2, 'BMW'),
       (3, 'JEEP'),
       (4, 'HONDA'),
       (5, 'LADA');