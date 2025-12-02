-- ----------------------------
-- Staff (Chefs + Servers)
-- ----------------------------
INSERT INTO staff (id, name, rating, staff_type, age, specialization, designation) VALUES
-- Chefs
(1, 'Gordon Ramsay', '5.0', 'CHEF', 45, 'Italian Cuisine', 'room1'),
(2, 'Jamie Oliver', '4.8', 'CHEF', 34, 'British Cuisine', 'room2'),
(3, 'Marco Pierre', '4.9', 'CHEF', 43, 'French Cuisine', 'room3'),
(4, 'Wolfgang Puck', '4.7', 'CHEF', 25, 'Austrian Cuisine', 'room4'),
(5, 'Emeril Lagasse', '4.6', 'CHEF', 54, 'Creole Cuisine', 'room5'),
(6, 'Bobby Flay', '4.8', 'CHEF', 38, 'American Cuisine', 'room6'),
(7, 'Rachael Ray', '4.5', 'CHEF', 36, 'Comfort Food', 'room7'),
(8, 'Alain Ducasse', '5.0', 'CHEF', 46, 'Mediterranean Cuisine', 'room8'),
(9, 'Thomas Keller', '4.9', 'CHEF', 25, 'Modern Cuisine', 'room9'),
(10, 'Massimo Bottura', '5.0', 'CHEF', 46, 'Italian Cuisine', 'room10'),
(11, 'Heston Blumenthal', '4.8', 'CHEF', 64, 'Molecular Gastronomy', 'room11'),
-- Servers
(12, 'Alice Cooper', '4.7', 'SERVER', 28, 'dinner', 'Senior Waiter'),
(13, 'Bob Dylan', '4.5', 'SERVER', 25, 'breakfast', 'Waiter'),
(14, 'Charlie Parker', '4.8', 'SERVER', 32, 'breakfast', 'Head Waiter'),
(15, 'Diana Ross', '4.6', 'SERVER', 27, 'breakfast', 'Waitress'),
(16, 'Elvis Presley', '4.9', 'SERVER', 35, 'dinner', 'Senior Waiter'),
(17, 'Freddie Mercury', '4.7', 'SERVER', 29, 'breakfast', 'Waiter'),
(18, 'Grace Kelly', '4.8', 'SERVER', 31, 'breakfast', 'Waitress'),
(19, 'Harry Styles', '4.5', 'SERVER', 23, 'dinner', 'Junior Waiter'),
(20, 'Iris Apfel', '4.6', 'SERVER', 26, 'breakfast', 'Waitress'),
(21, 'Jack Black', '4.7', 'SERVER', 30, 'dinner', 'Waiter'),
(22, 'Kate Moss', '4.8', 'SERVER', 33, 'breakfast', 'Senior Waitress');
