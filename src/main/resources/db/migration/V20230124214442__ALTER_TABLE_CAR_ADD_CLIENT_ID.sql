ALTER TABLE IF EXISTS car ADD COLUMN client_id int8 NOT NULL;

ALTER TABLE IF EXISTS car ADD CONSTRAINT fk_car_client FOREIGN KEY (client_id) REFERENCES client(id);