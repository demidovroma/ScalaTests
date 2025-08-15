DROP DATABASE IF EXISTS `test`;

CREATE DATABASE IF NOT EXISTS `test` CHARACTER SET utf8 COLLATE utf8_general_ci;

USE `test`;

# Создать в базе test UTF8 таблицу users с полями:
# id: auto increment
# email
# pass: md5 от пароля
# sum: деньги, целое число
# updated: дата время изменения пользователя, должно проставляться автоматически при изменении данных
# created: дата время создания пользователя, ставится руками при добавлении
CREATE TABLE IF NOT EXISTS `users` (
    `id` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `email` varchar(255) DEFAULT NULL,
    `pass` VARCHAR(32) NOT NULL,
    `sum` INTEGER DEFAULT 0,
    `updated` TIMESTAMP DEFAULT NOW() ON UPDATE CURRENT_TIMESTAMP,
    `created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

# Создать несколько пользователей, дата создания должна отличаться мин на 1 день + 1 запись на сегодня
INSERT INTO users (email, pass, sum, created) VALUES ('user@example.com', MD5('password'), 1000, NOW() - INTERVAL 1 MONTH - INTERVAL 3 DAY);
INSERT INTO users (email, pass, sum, created) VALUES ('user1@example.com', MD5('password1'), 1000, NOW() - INTERVAL 1 MONTH - INTERVAL 2 DAY);
INSERT INTO users (email, pass, sum, created) VALUES ('user2@example.com', MD5('password2'), 1000, NOW() - INTERVAL 1 DAY);
INSERT INTO users (email, pass, sum, created) VALUES ('user3@example.com', MD5('password3'), 1000, NOW() - INTERVAL 1 DAY + INTERVAL 1 HOUR);
INSERT INTO users (email, pass, sum, created) VALUES ('user4@example.com', MD5('password4'), 1000, NOW());

# Сделать выборки:
# пользователь с email=XXXX
SELECT * FROM `users` WHERE email = 'user@example.com';
SELECT * FROM `users` WHERE email LIKE '%user@%';

# выбрать всех созданных сегодня пользователей
SELECT * FROM `users` WHERE created BETWEEN DATE_FORMAT(CURRENT_DATE(), "%Y-%m-%d 00:00:00") AND DATE_FORMAT(CURRENT_DATE(), "%Y-%m-%d 23:59:59");

# посчитать сколько было зарегистрировано пользователей за каждый день
SELECT DATE_FORMAT(created, "%Y-%m-%d") as created, COUNT(*) FROM `users` GROUP BY DATE_FORMAT(created, "%Y-%m-%d");

# посчитать сумму денег всех пользователей
SELECT SUM(sum) FROM `users`;

# Изменить деньги пользователей:
# по id
UPDATE `users` SET sum = sum * 2 WHERE id = 1;
UPDATE `users` SET sum = sum * 3 WHERE id IN (2,3);

# по email
UPDATE `users` SET sum = sum * 2 WHERE email = 'user@example.com';

# всех которые были созданы в прошлом месяце
UPDATE `users` SET sum = sum * 2 WHERE created BETWEEN DATE_FORMAT(ADDDATE(CURRENT_DATE, INTERVAL -1 MONTH),"%Y-%m-01 00:00:00") AND LAST_DAY(ADDDATE(CURRENT_DATE, INTERVAL -1 MONTH));

# Добавить уникальный ключ по полю email
ALTER TABLE `users` ADD CONSTRAINT unique_email UNIQUE (email);

# Добавить нового пользователя, но если пользователь с таким email уже есть, то обновить его данные. on duplicate
INSERT INTO users (email, pass, sum, created) VALUES ('user@example.com', MD5('password5'), 1000, NOW())
ON DUPLICATE KEY UPDATE pass = VALUES(pass), sum = VALUES(sum), updated = NOW();

# Вывести все доступные базы данных
SHOW DATABASES;

# Вывести список таблиц
SHOW TABLES;

# Вывести описание таблицы users
DESCRIBE `users`;

# Получить команду создания таблицы users
SHOW CREATE TABLE `users`;

# Добавить в таблицу users поле sex после поля pass, которое может принимать три значения: 'unknown', 'M', 'F'. По умолчанию должно быть 'unknown'.
ALTER TABLE `users` ADD COLUMN `sex` ENUM('unknown', 'M', 'F') DEFAULT 'unknown' AFTER `pass`;

# Изменить поле sum с целых на дробные
ALTER TABLE `users` MODIFY COLUMN `sum` DECIMAL(10,2) DEFAULT 0.00;

# Переименовать поле sum в money
ALTER TABLE `users` CHANGE COLUMN `sum` `money` DECIMAL(10,2);