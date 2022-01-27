create table if not exists hibernate_sequence
(
    next_val bigint null
);


create table  if not exists stock
(
    id            int            not null
        primary key,
    current_price decimal(19, 2) null,
    deleted       bit            not null,
    last_update   datetime(6)    not null,
    name          varchar(255)   not null
);

INSERT INTO stock (id, current_price, deleted, last_update, name) VALUES (1, 100000.00, false, '2022-01-27 10:04:26', 'apple');
INSERT INTO stock (id, current_price, deleted, last_update, name) VALUES (2, 5555.00, false, '2022-01-27 10:04:26', 'macbook');
INSERT INTO stock (id, current_price, deleted, last_update, name) VALUES (3, 66666.00, false, '2022-01-27 10:04:26', 'iphone12');
INSERT INTO stock (id, current_price, deleted, last_update, name) VALUES (4, 33333.00, false, '2022-01-27 10:04:26', 'orange');
INSERT INTO stock (id, current_price, deleted, last_update, name) VALUES (5, 333.00, false, '2022-01-27 10:04:26', 'asus');
INSERT INTO stock (id, current_price, deleted, last_update, name) VALUES (6, 121211.00, false, '2022-01-27 10:04:26', 'imac');
INSERT INTO stock (id, current_price, deleted, last_update, name) VALUES (7, 4545.00, false, '2022-01-27 10:04:26', 'del');
INSERT INTO stock (id, current_price, deleted, last_update, name) VALUES (8, 852.00, false, '2022-01-27 10:04:26', 'iphone');
INSERT INTO stock (id, current_price, deleted, last_update, name) VALUES (9, 9666.00, false, '2022-01-27 10:04:26', 'pixel');
INSERT INTO stock (id, current_price, deleted, last_update, name) VALUES (10, 12154.00, false, '2022-01-27 10:04:26', 'iphone14');
INSERT INTO hibernate_sequence (next_val) VALUES (11);