---------------------------------------------------------------------------------------------
-- GENRE

INSERT INTO genre (name) VALUES ('Action');
INSERT INTO genre (name) VALUES ('Fantasy');
INSERT INTO genre (name) VALUES ('Martial Arts');
INSERT INTO genre (name) VALUES ('Comedy');
INSERT INTO genre (name) VALUES ('Adventure');
INSERT INTO genre (name) VALUES ('Seinen');

---------------------------------------------------------------------------------------------
-- THEME

INSERT INTO theme (name) VALUES ('System');
INSERT INTO theme (name) VALUES ('Academy');
INSERT INTO theme (name) VALUES ('Reincarnation');
INSERT INTO theme (name) VALUES ('Overpowered');

---------------------------------------------------------------------------------------------
-- MANHWA PROFILE
INSERT INTO manhwa_profile (author, description, favourite, name, number_of_chapters, released, status, type, updated, views)
VALUES ('Zerobic', '', 10, 'Murim Login', 135, current_timestamp, 'Ongoing', 'Manhwa', current_timestamp, 666);
