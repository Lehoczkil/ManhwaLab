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
INSERT INTO manhwa_profile (author, description, favourite, name, number_of_chapters, released, status, type, updated, views, rating)
VALUES ('Zerobic', 'An era where hunters thrive on hunting monsters that come from Gates. Jin Tae-Kyung is a low-rank hunter who picks up a VR machine, and accidentally logs into the game, which is set in the world of Martial Arts. After many ups and downs, Tae-Kyung is able to escape this world. The strength and skills, which he received in the Murim were able to be carried over back to the real world. This allows him to continue making a living a hunter… but he decides to return back to the world of Murim, out of care for his NPC friends.'
        , 10, 'Murim Login', 135, current_timestamp, 'ONGOING', 'MANHWA', current_timestamp, 666, 9.9);

---------------------------------------------------------------------------------------------

-- MANHWA PROFILE GENRE LIST

INSERT INTO manhwa_profile_genre_list (manhwa_profile_id, genre_List_id) VALUES ( 1, 1);
INSERT INTO manhwa_profile_genre_list (manhwa_profile_id, genre_List_id) VALUES ( 1, 2);
INSERT INTO manhwa_profile_genre_list (manhwa_profile_id, genre_List_id) VALUES ( 1, 3);
INSERT INTO manhwa_profile_genre_list (manhwa_profile_id, genre_List_id) VALUES ( 1, 4);


---------------------------------------------------------------------------------------------
-- MANHWA PROFILE THEME LIST

INSERT INTO manhwa_profile_theme_list (manhwa_profile_id, theme_List_id) VALUES ( 1, 1);
INSERT INTO manhwa_profile_theme_list (manhwa_profile_id, theme_List_id) VALUES ( 1, 3);
INSERT INTO manhwa_profile_theme_list (manhwa_profile_id, theme_List_id) VALUES ( 1, 4);


---------------------------------------------------------------------------------------------
-- USER PROFILE

INSERT INTO user_profile (password, age, description, gender, joined, last_online, location, user_name) VALUES ('pw', 42, '', 'MALE', current_timestamp, current_timestamp, 'Budapest', 'Béla');

---------------------------------------------------------------------------------------------
-- COMMENT


---------------------------------------------------------------------------------------------
-- MANHWA PROFILE USER PROFILE LIST

INSERT INTO manhwa_profile_user_profile (manhwa_profile_id, user_profile_id) VALUES (1, 1);
