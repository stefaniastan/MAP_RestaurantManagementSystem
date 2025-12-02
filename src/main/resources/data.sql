-- ============================================================
-- 1. Curățarea Tabelelor
-- ============================================================
SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM bills;
DELETE FROM order_assignments;
DELETE FROM order_lines;
DELETE FROM orders;
DELETE FROM staff;
DELETE FROM restaurant_tables;
DELETE FROM customers;
DELETE FROM menu_items;

-- ============================================================
-- 2. Resetarea Auto-Increment
-- ============================================================
ALTER TABLE bills AUTO_INCREMENT = 1;
ALTER TABLE order_assignments AUTO_INCREMENT = 1;
ALTER TABLE order_lines AUTO_INCREMENT = 1;
ALTER TABLE orders AUTO_INCREMENT = 1;
ALTER TABLE staff AUTO_INCREMENT = 1;
ALTER TABLE restaurant_tables AUTO_INCREMENT = 1;
ALTER TABLE customers AUTO_INCREMENT = 1;
ALTER TABLE menu_items AUTO_INCREMENT = 1;

SET FOREIGN_KEY_CHECKS = 1;

-- ============================================================
-- 3. Inserare MenuItems
-- ============================================================
INSERT INTO menu_items (name, price) VALUES
                                         ('Pizza Margherita', 32.00),
                                         ('Pizza Prosciutto e Funghi', 38.00),
                                         ('Paste Carbonara', 42.00),
                                         ('Paste Bolognese', 40.00),
                                         ('Burger Vita Black Angus', 55.00),
                                         ('Coaste de Porc BBQ', 60.00),
                                         ('Salata Caesar cu Pui', 35.00),
                                         ('Supa Crema de Legume', 18.00),
                                         ('Lava Cake cu Inghetata', 25.00),
                                         ('Papanasi cu Smantana', 28.00),
                                         ('Limonada Menta 0.4L', 15.00),
                                         ('Apa Minerala 0.75L', 12.00);

-- ============================================================
-- 4. Inserare Customers
-- ============================================================
INSERT INTO customers (name, address, email) VALUES
                                                 ('Ion Popescu', 'Str. Libertatii 10, Cluj', 'ion.pop@mail.com'),
                                                 ('Maria Ionescu', 'Str. Eroilor 5, Bucuresti', 'maria.io@mail.com'),
                                                 ('Andrei Radu', 'Str. Unirii 2, Timisoara', 'andrei.r@mail.com'),
                                                 ('Elena Dumitru', 'Bld. Victoriei 100, Bucuresti', 'elena.d@mail.com'),
                                                 ('George Vasilescu', 'Str. Horea 15, Cluj', 'george.v@mail.com'),
                                                 ('Ana Stan', 'Str. Florilor 3, Brasov', 'ana.stan@mail.com'),
                                                 ('Mihai Oprea', 'Aleea Rozelor 1, Iasi', 'mihai.op@mail.com'),
                                                 ('Diana Marin', 'Str. Lunga 44, Sibiu', 'diana.m@mail.com'),
                                                 ('Vlad Tudor', 'Str. Garii 12, Constanta', 'vlad.t@mail.com'),
                                                 ('Carmen Nistor', 'Str. Pacii 8, Oradea', 'carmen.n@mail.com');

-- ============================================================
-- 5. Inserare RestaurantTables
-- ATENȚIE: Doar 'free' sau 'occupied' (lowercase)
-- ============================================================
INSERT INTO restaurant_tables (number, status) VALUES
                                                   (1, 'occupied'),
                                                   (2, 'free'),
                                                   (3, 'occupied'), -- Fostul RESERVED
                                                   (4, 'occupied'),
                                                   (5, 'free'),
                                                   (6, 'occupied'),
                                                   (7, 'free'),
                                                   (8, 'free'),     -- Fostul COMPLETED
                                                   (9, 'occupied'), -- Fostul RESERVED
                                                   (10, 'free');

-- ============================================================
-- 6. Inserare Staff
-- ============================================================
INSERT INTO staff (staff_type, name, rating, age, specialization, designation) VALUES
                                                                                   ('CHEF', 'Gordon Ramsay', '5.0', 50, 'Head Chef', NULL),
                                                                                   ('CHEF', 'Jamie Oliver', '4.8', 45, 'Italian Cuisine', NULL),
                                                                                   ('CHEF', 'Florin Dumitrescu', '4.9', 35, 'Fine Dining', NULL),
                                                                                   ('CHEF', 'Sorin Bontea', '4.9', 52, 'Asian Fusion', NULL),
                                                                                   ('CHEF', 'Catalin Scarlatescu', '4.7', 48, 'Traditional & Meat', NULL),
                                                                                   ('SERVER', 'Alina Pop', '4.5', 24, NULL, 'Senior Waiter'),
                                                                                   ('SERVER', 'Dan Ionescu', '4.2', 22, NULL, 'Junior Waiter'),
                                                                                   ('SERVER', 'Ioana Radu', '4.9', 28, NULL, 'Shift Manager'),
                                                                                   ('SERVER', 'Bogdan Munteanu', '4.0', 21, NULL, 'Runner'),
                                                                                   ('SERVER', 'Simona Halep', '5.0', 26, NULL, 'VIP Waiter');

-- ============================================================
-- 7. Inserare Orders
-- ATENȚIE: Doar 'pending', 'delivered', 'cancelled' (lowercase)
-- ============================================================
INSERT INTO orders (customer_id, table_id, status) VALUES
                                                       (1, 1, 'pending'),   -- Fostul PREPARING
                                                       (2, 4, 'delivered'), -- Fostul SERVED
                                                       (3, 6, 'delivered'), -- Fostul COMPLETED
                                                       (4, 3, 'pending'),   -- PENDING
                                                       (5, 8, 'delivered'), -- Fostul COMPLETED
                                                       (6, 2, 'cancelled'), -- CANCELLED
                                                       (7, 5, 'delivered'), -- Fostul COMPLETED
                                                       (8, 9, 'pending'),   -- Fostul PREPARING
                                                       (9, 10, 'delivered'),-- Fostul SERVED
                                                       (10, 7, 'delivered');-- Fostul COMPLETED

-- ============================================================
-- 8. Inserare OrderLines
-- ============================================================
INSERT INTO order_lines (order_id, menu_item_id, quantity) VALUES
                                                               (1, 1, 2), (1, 11, 2),
                                                               (2, 5, 1), (2, 12, 1),
                                                               (3, 3, 2), (3, 9, 2),
                                                               (4, 8, 1),
                                                               (5, 6, 1), (5, 12, 1),
                                                               (6, 2, 1),
                                                               (7, 4, 1), (7, 10, 1),
                                                               (8, 5, 2), (8, 11, 2),
                                                               (9, 7, 1),
                                                               (10, 1, 3), (10, 12, 3), (10, 9, 3);

-- ============================================================
-- 9. Inserare OrderAssignments
-- ============================================================
INSERT INTO order_assignments (order_id, staff_id) VALUES
                                                       (1, 1), (1, 6),
                                                       (2, 7),
                                                       (3, 2), (3, 8),
                                                       (4, 9),
                                                       (5, 5), (5, 10),
                                                       (7, 3), (7, 6),
                                                       (8, 4), (8, 7),
                                                       (9, 1), (9, 8),
                                                       (10, 2), (10, 10);

-- ============================================================
-- 10. Inserare Bills
-- ============================================================
INSERT INTO bills (order_id, total_amount) VALUES
                                               (1, 94.00),
                                               (2, 67.00),
                                               (3, 134.00),
                                               (4, 18.00),
                                               (5, 72.00),
                                               (6, 0.00),
                                               (7, 68.00),
                                               (8, 140.00),
                                               (9, 35.00),
                                               (10, 207.00);