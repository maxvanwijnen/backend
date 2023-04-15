insert into roles(rolename) values ('USER'), ('ADMIN');
insert into users(username, password) values ('Gert','$2a$10$.08U.zhqxJ0YbWR9V3frf.YZZOiWgirH1Qz3jLpovlH9gNHeoUzKO');
insert into users(username, password) values ('Samson','$2a$10$.08U.zhqxJ0YbWR9V3frf.YZZOiWgirH1Qz3jLpovlH9gNHeoUzKO');
insert into users_roles(users_username, roles_rolename) values ('Gert', 'ADMIN');
insert into users_roles(users_username, roles_rolename) values ('Samson', 'USER');

--customers
INSERT INTO customers (first_name, last_name, email, city, address, postcode, phone)
VALUES ('Anna', 'Bakker', 'annabakker@gmail.com', 'Utrecht', 'Jacobstraat 12', '3511 BS', '0612345678');
INSERT INTO customers (first_name, last_name, email, city, address, postcode, phone)
VALUES ('David', 'Kramer', 'davidkramer@gmail.com', 'Amsterdam', 'Keizersgracht 200', '1016 DW', '0654321098');
INSERT INTO customers (first_name, last_name, email, city, address, postcode, phone)
VALUES ('Ella', 'de Vries', 'elladevries@gmail.com', 'Rotterdam', 'Willemsplein 20', '3016 DR', '0687654321');
INSERT INTO customers (first_name, last_name, email, city, address, postcode, phone)
VALUES ('Luuk', 'van Dijk', 'luukvandijk@gmail.com', 'Den Haag', 'Malieveld 10', '2595 AA', '0643210987');
INSERT INTO customers (first_name, last_name, email, city, address, postcode, phone)
VALUES ('Fleur', 'Jansen', 'fleurjansen@gmail.com', 'Maastricht', 'Vrijthof 10', '6211 LD', '0612345678');


--cars
INSERT INTO cars (license_plate, brand, model, color, number_of_doors, transmission, year, last_check, customer_id)
VALUES ('AB-456-EF', 'Volkswagen', 'Golf', 'Blauw', 5, 'Handgeschakeld', '2018-06-01', '2022-03-18', 1);
INSERT INTO cars (license_plate, brand, model, color, number_of_doors, transmission, year, last_check, customer_id)
VALUES ('CD-789-GH', 'Ford', 'Fiesta', 'Grijs', 3, 'Automaat', '2020-01-01', '2022-03-18', 2);
INSERT INTO cars (license_plate, brand, model, color, number_of_doors, transmission, year, last_check, customer_id)
VALUES ('EF-123-IJ', 'Toyota', 'Yaris', 'Rood', 5, 'Handgeschakeld', '2019-05-01', '2022-03-18', 3);
INSERT INTO cars (license_plate, brand, model, color, number_of_doors, transmission, year, last_check, customer_id)
VALUES ('GH-456-KL', 'Audi', 'A3', 'Zwart', 5, 'Handgeschakeld', '2021-03-01', '2022-03-18', 4);
INSERT INTO cars (license_plate, brand, model, color, number_of_doors, transmission, year, last_check, customer_id)
VALUES ('IJ-789-MN', 'BMW', '3 Serie', 'Wit', 4, 'Automaat', '2017-12-01', '2022-03-18', 5);
INSERT INTO cars (license_plate, brand, model, color, number_of_doors, transmission, year, last_check, customer_id)
VALUES ('KL-123-OP', 'Peugeot', '208', 'Zwart', 3, 'Handgeschakeld', '2022-01-01', '2022-03-18', 1);
INSERT INTO cars (license_plate, brand, model, color, number_of_doors, transmission, year, last_check, customer_id)
VALUES ('MN-456-QR', 'Renault', 'Clio', 'Grijs', 5, 'Automaat', '2016-04-01', '2022-03-18', 3);
INSERT INTO cars (license_plate, brand, model, color, number_of_doors, transmission, year, last_check, customer_id)
VALUES ('OP-789-ST', 'Opel', 'Corsa', 'Rood', 5, 'Handgeschakeld', '2019-09-01', '2022-03-18', 5);


INSERT INTO workingdays (id, date)
VALUES (1,'2023-05-05');
INSERT INTO workingdays (id, date)
VALUES (2, '2023-05-22');
INSERT INTO workingdays (id, date)
VALUES (3, '2023-05-23');
INSERT INTO workingdays (id, date)
VALUES (4, '2023-05-24');
INSERT INTO workingdays (id, date)
VALUES (5, '2023-05-25');
INSERT INTO workingdays (id, date)
VALUES (6, '2023-06-01');
INSERT INTO workingdays (id, date)
VALUES (7, '2023-06-02');
INSERT INTO workingdays (id, date)
VALUES (8, '2023-06-03');

INSERT INTO carparts (name, stock_amount) VALUES ('Remschijf', 10);
INSERT INTO carparts (name, stock_amount) VALUES ('Remblokken', 25);
INSERT INTO carparts (name, stock_amount) VALUES ('Luchtfilter', 50);
INSERT INTO carparts (name, stock_amount) VALUES ('Oliefilter', 35);
INSERT INTO carparts (name, stock_amount) VALUES ('Brandstoffilter', 20);
INSERT INTO carparts (name, stock_amount) VALUES ('Waterpomp', 5);
INSERT INTO carparts (name, stock_amount) VALUES ('Dynamo', 12);
INSERT INTO carparts (name, stock_amount) VALUES ('Radiateur', 8);
INSERT INTO carparts (name, stock_amount) VALUES ('Remslang', 15);
INSERT INTO carparts (name, stock_amount) VALUES ('Stuurbekrachtigingspomp', 3);
INSERT INTO carparts (name, stock_amount) VALUES ('Distributieriem', 7);
INSERT INTO carparts (name, stock_amount) VALUES ('Bougies', 40);
INSERT INTO carparts (name, stock_amount) VALUES ('Startmotor', 2);
INSERT INTO carparts (name, stock_amount) VALUES ('Draagarm', 9);
INSERT INTO carparts (name, stock_amount) VALUES ('Fuseekogel', 13);
INSERT INTO carparts (name, stock_amount) VALUES ('Stabilisatorstang', 6);
INSERT INTO carparts (name, stock_amount) VALUES ('Uitlaat', 22);
INSERT INTO carparts (name, stock_amount) VALUES ('Koppeling', 4);
INSERT INTO carparts (name, stock_amount) VALUES ('Versnellingsbak', 1);
INSERT INTO carparts (name, stock_amount) VALUES ('V-snaar', 30);















