-- ----------------------------
-- Customers
-- ----------------------------
INSERT INTO customers (id, name, address, email) VALUES
(1, 'John Doe', '123 Main St, Cluj', 'john.doe@email.com'),
(2, 'Jane Smith', '456 Oak Ave, Cluj', 'jane.smith@email.com'),
(3, 'Michael Brown', '789 Pine Rd, Cluj', 'michael.brown@email.com'),
(4, 'Emily Davis', '321 Elm St, Cluj', 'emily.davis@email.com'),
(5, 'David Wilson', '654 Maple Dr, Cluj', 'david.wilson@email.com'),
(6, 'Sarah Johnson', '987 Cedar Ln, Cluj', 'sarah.johnson@email.com'),
(7, 'James Martinez', '147 Birch Ct, Cluj', 'james.martinez@email.com'),
(8, 'Laura Garcia', '258 Spruce Way, Cluj', 'laura.garcia@email.com'),
(9, 'Robert Miller', '369 Willow Pl, Cluj', 'robert.miller@email.com'),
(10, 'Maria Rodriguez', '741 Ash Blvd, Cluj', 'maria.rodriguez@email.com');

-- ----------------------------
-- Menu Items
-- ----------------------------
INSERT INTO menu_items (id, name, price) VALUES
(1, 'Margherita Pizza', 45.0),
(2, 'Carbonara Pasta', 38.0),
(3, 'Caesar Salad', 28.0),
(4, 'Grilled Salmon', 65.0),
(5, 'Beef Steak', 78.0),
(6, 'Chicken Alfredo', 42.0),
(7, 'Vegetable Soup', 22.0),
(8, 'Tiramisu', 25.0),
(9, 'Chocolate Cake', 28.0),
(10, 'Espresso', 12.0),
(11, 'Cappuccino', 15.0),
(12, 'Fresh Orange Juice', 18.0);

-- ----------------------------
-- Restaurant Tables
-- ----------------------------
INSERT INTO restaurant_tables (id, number, occupied_status) VALUES
(1, 1, 'FREE'),
(2, 2, 'FREE'),
(3, 3, 'OCCUPIED'),
(4, 4, 'FREE'),
(5, 5, 'FREE'),
(6, 6, 'OCCUPIED'),
(7, 7, 'FREE'),
(8, 8, 'FREE'),
(9, 9, 'OCCUPIED'),
(10, 10, 'FREE'),
(11, 11, 'FREE'),
(12, 12, 'OCCUPIED'),
(13, 13, 'FREE'),
(14, 14, 'FREE'),
(15, 15, 'OCCUPIED');

-- ----------------------------
-- Chefs
-- ----------------------------
INSERT INTO chefs (id, name, rating, age, specialization) VALUES
(1, 'Gordon Ramsay', '5.0', 45, 'Italian Cuisine'),
(2, 'Jamie Oliver', '4.8', 34, 'British Cuisine'),
(3, 'Marco Pierre', '4.9', 43, 'French Cuisine'),
(4, 'Wolfgang Puck', '4.7', 25, 'Austrian Cuisine'),
(5, 'Emeril Lagasse', '4.6', 54, 'Creole Cuisine'),
(6, 'Bobby Flay', '4.8', 38, 'American Cuisine'),
(7, 'Rachael Ray', '4.5', 36, 'Comfort Food'),
(8, 'Alain Ducasse', '5.0', 46, 'Mediterranean Cuisine'),
(9, 'Thomas Keller', '4.9', 25, 'Modern Cuisine'),
(10, 'Massimo Bottura', '5.0', 46, 'Italian Cuisine'),
(11, 'Heston Blumenthal', '4.8', 64, 'Molecular Gastronomy');

-- ----------------------------
-- Servers
-- ----------------------------
INSERT INTO servers (id, name, rating, age, designation) VALUES
(1, 'Alice Cooper', '4.7', 28, 'Senior Waiter'),
(2, 'Bob Dylan', '4.5', 25, 'Waiter'),
(3, 'Charlie Parker', '4.8', 32, 'Head Waiter'),
(4, 'Diana Ross', '4.6', 27, 'Waitress'),
(5, 'Elvis Presley', '4.9', 35, 'Senior Waiter'),
(6, 'Freddie Mercury', '4.7', 29, 'Waiter'),
(7, 'Grace Kelly', '4.8', 31, 'Waitress'),
(8, 'Harry Styles', '4.5', 23, 'Junior Waiter'),
(9, 'Iris Apfel', '4.6', 26, 'Waitress'),
(10, 'Jack Black', '4.7', 30, 'Waiter'),
(11, 'Kate Moss', '4.8', 33, 'Senior Waitress');

-- ----------------------------
-- Orders
-- ----------------------------
INSERT INTO orders (id, customer_id, table_id, status) VALUES
(1, 1, 1, 'DELIVERED'),
(2, 2, 2, 'PENDING'),
(3, 3, 3, 'CANCELLED'),
(4, 4, 4, 'DELIVERED'),
(5, 5, 5, 'PENDING'),
(6, 6, 6, 'CANCELLED'),
(7, 7, 7, 'DELIVERED'),
(8, 8, 8, 'PENDING'),
(9, 9, 9, 'CANCELLED'),
(10, 10, 10, 'DELIVERED'),
(11, 11, 11, 'PENDING'),
(12, 12, 12, 'DELIVERED');

-- ----------------------------
-- Order Lines
-- ----------------------------
INSERT INTO order_lines (id, order_id, menu_item_id, quantity) VALUES
(1, 1, 1, 2),
(2, 1, 2, 1),
(3, 2, 3, 2),
(4, 2, 4, 1),
(5, 3, 5, 3),
(6, 3, 6, 2),
(7, 4, 7, 1),
(8, 4, 8, 2),
(9, 5, 9, 1),
(10, 5, 10, 3),
(11, 6, 1, 2),
(12, 6, 2, 1);

-- ----------------------------
-- Order Assignments
-- ----------------------------
INSERT INTO order_assignments (id, order_id, staff_id) VALUES
(1, 1, 1), -- chef
(2, 1, 1), -- server
(3, 2, 2),
(4, 2, 2),
(5, 3, 3),
(6, 3, 3),
(7, 4, 4),
(8, 4, 4),
(9, 5, 5),
(10, 5, 5);

-- ----------------------------
-- Bills
-- ----------------------------
INSERT INTO bills (id, order_id, total_amount) VALUES
(1, 1, 115.5),
(2, 2, 130.0),
(3, 3, 145.5),
(4, 4, 161.0),
(5, 5, 176.5),
(6, 6, 192.0),
(7, 7, 207.5),
(8, 8, 223.0),
(9, 9, 238.5),
(10, 10, 254.0);
