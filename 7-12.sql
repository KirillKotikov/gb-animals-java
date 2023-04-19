    -- 7. В подключенном MySQL репозитории создать базу данных “Друзья
        -- человека”

CREATE DATABASE human_friends;
USE human_friends;

    -- 8. Создать таблицы с иерархией из диаграммы в БД

CREATE TABLE horses (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	birth_date DATE NOT NULL,
	name varchar(100) NOT NULL,
	commands varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE camels (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	birth_date DATE NOT NULL,
	name varchar(100) NOT NULL,
	commands varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE donkeys (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	birth_date DATE NOT NULL,
	name varchar(100) NOT NULL,
	commands varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE dogs (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	birth_date DATE NOT NULL,
	name varchar(100) NOT NULL,
	commands varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE cats (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	birth_date DATE NOT NULL,
	name varchar(100) NOT NULL,
	commands varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE hamsters (
	id BIGINT UNSIGNED auto_increment NOT NULL,
	birth_date DATE NOT NULL,
	name varchar(100) NOT NULL,
	commands varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

    -- 9. Заполнить низкоуровневые таблицы именами(животных), командами
        -- которые они выполняют и датами рождения

INSERT INTO horses
(birth_date, name, commands)
VALUES
('2023-02-12', 'Sugar1', 'Go, Up'),
('2022-02-15', 'Sugar2', 'Go, Up'),
('2021-02-12', 'Sugar3', 'Go, Up'),
('2020-02-12', 'Sugar4', 'Go, Up');

INSERT INTO camels
(birth_date, name, commands)
VALUES
('2023-02-12', 'Camel1', 'Down, Run'),
('2022-02-15', 'Camel2', 'Down, Run'),
('2021-02-12', 'Camel3', 'Down, Run'),
('2020-02-12', 'Camel4', 'Down, Run');

INSERT INTO donkeys
(birth_date, name, commands)
VALUES
('2023-02-12', 'Donkey1', 'Go, Stop'),
('2022-02-15', 'Donkey2', 'Go, Stop'),
('2021-02-12', 'Donkey3', 'Go, Stop'),
('2020-02-12', 'Donkey4', 'Go, Stop');

INSERT INTO dogs
(birth_date, name, commands)
VALUES
('2023-02-12', 'Dog1', 'Voice, Seat'),
('2022-02-15', 'Dog2', 'Voice, Seat'),
('2021-02-12', 'Dog3', 'Voice, Seat'),
('2020-02-12', 'Dog4', 'Voice, Seat');

INSERT INTO cats
(birth_date, name, commands)
VALUES
('2023-02-12', 'Cat1', 'Do nothing'),
('2022-02-15', 'Cat2', 'Do nothing'),
('2021-02-12', 'Cat3', 'Do nothing'),
('2020-02-12', 'Cat4', 'Do nothing');

INSERT INTO hamsters
(birth_date, name, commands)
VALUES
('2023-02-12', 'Hamster1', 'Run'),
('2022-02-15', 'Hamster2', 'Run'),
('2021-02-12', 'Hamster3', 'Run'),
('2020-02-12', 'Hamster4', 'Run');


	-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
		-- питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу

DROP TABLE camels;

CREATE TABLE mammals 
(SELECT * FROM horses
UNION
SELECT * FROM donkeys);

	-- 11. Создать новую таблицу “молодые животные” в которую попадут все
		-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
		-- до месяца подсчитать возраст животных в новой таблице

CREATE TABLE young_animals 
SELECT id, birth_date, name, commands, (SELECT TIMESTAMPDIFF(MONTH, birth_date, curdate())) AS age_in_month FROM horses
WHERE (SELECT TIMESTAMPDIFF(MONTH, birth_date, curdate())) BETWEEN 12 AND 35
UNION
SELECT id, birth_date, name, commands, (SELECT TIMESTAMPDIFF(MONTH, birth_date, curdate())) AS age_in_month FROM donkeys
WHERE (SELECT TIMESTAMPDIFF(MONTH, birth_date, curdate())) BETWEEN 12 AND 35
UNION
SELECT id, birth_date, name, commands, (SELECT TIMESTAMPDIFF(MONTH, birth_date, curdate())) AS age_in_month FROM dogs
WHERE (SELECT TIMESTAMPDIFF(MONTH, birth_date, curdate())) BETWEEN 12 AND 35
UNION
SELECT id, birth_date, name, commands, (SELECT TIMESTAMPDIFF(MONTH, birth_date, curdate())) AS age_in_month FROM cats
WHERE (SELECT TIMESTAMPDIFF(MONTH, birth_date, curdate())) BETWEEN 12 AND 35
UNION
SELECT id, birth_date, name, commands, (SELECT TIMESTAMPDIFF(MONTH, birth_date, curdate())) AS age_in_month FROM hamsters
WHERE (SELECT TIMESTAMPDIFF(MONTH, birth_date, curdate())) BETWEEN 12 AND 35;

	-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
		-- прошлую принадлежность к старым таблицам

CREATE TABLE common
SELECT id, birth_date, name, commands FROM horses
UNION
SELECT id, birth_date, name, commands FROM donkeys
UNION
SELECT id, birth_date, name, commands FROM dogs
UNION
SELECT id, birth_date, name, commands FROM cats
UNION
SELECT id, birth_date, name, commands FROM hamsters;