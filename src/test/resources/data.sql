INSERT INTO country (name) VALUES ('Bulgaria');
INSERT INTO address (address_line, city, postal_code, country_id) VALUES ('Bul. Bulgaria 236', 'Sofia', 4000, 1);
INSERT INTO contact (email, mobile, name, phone, address_id) VALUES ('asd@gmail.com', '+359-876794597', 'Contact 1', '+359-876794597', 1);
INSERT INTO supplier (deleted, id_number, max_quantity, min_quantity, name, contact_id) VALUES (false, '22345678', 2, 5, 'Supplier 1', 1);