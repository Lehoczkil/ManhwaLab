-- we don't know how to generate root <with-no-name> (class Root) :(
CREATE DATABASE manhwalab;

CREATE TABLE comment
(
    id                bigserial
        primary key,
    comment_type      varchar(255),
    commented_at      timestamp,
    dislikes          integer,
    likes             integer,
    parent_comment_id bigint,
    text              varchar(255),
    user_id           varchar(255)
);

-- ALTER TABLE comment
--     OWNER TO aron;

CREATE TABLE genre
(
    id   bigserial
        primary key,
    name varchar(255)
);

-- ALTER TABLE genre
--     OWNER TO aron;

CREATE TABLE manhwa_profile
(
    id                 bigserial
        primary key,
    author             varchar(255),
    cover_page_link    varchar(255),
    description        text,
    favourite          integer,
    number_of_chapters integer,
    popularity_ranking integer,
    rating             real,
    rating_ranking     integer,
    released           timestamp,
    status             varchar(255),
    title              varchar(255),
    type               varchar(255),
    updated            timestamp,
    views              integer
);

-- ALTER TABLE manhwa_profile OWNER TO aron;

CREATE TABLE manhwa_profile_genre_list
(
    manhwa_profile_id bigint not null
        constraint fk8ht3kwe3a5pu49x4xe0d6s2fj
            references manhwa_profile,
    genre_list_id     bigint not null
        constraint fk7sn6tq71nabf8eak4kyffeflf
            references genre
);

-- ALTER TABLE manhwa_profile_genre_list
--     OWNER TO aron;

CREATE TABLE theme
(
    id   bigserial
        primary key,
    name varchar(255)
);

-- ALTER TABLE theme
--     OWNER TO aron;

CREATE TABLE manhwa_profile_theme_list
(
    manhwa_profile_id bigint not null
        constraint fkr6w7g8y4rjsochrf6qnqojvnc
            references manhwa_profile,
    theme_list_id     bigint not null
        constraint fkkb5rm46w9ri2qs9jd6wa4shbr
            references theme
);

-- ALTER TABLE manhwa_profile_theme_list
--     OWNER TO aron;

CREATE TABLE user_profile
(
    id          bigserial
        primary key,
    password    varchar(255),
    age         integer,
    description text,
    gender      varchar(255),
    joined      timestamp,
    last_online timestamp,
    location    varchar(255),
    user_name   varchar(255)
);

-- ALTER TABLE user_profile
--     OWNER TO aron;

CREATE TABLE manhwa_profile_user_profile
(
    manhwa_profile_id bigint not null
        constraint fk1ifnlj5a5tql0wm6oyi79ref3
            references manhwa_profile,
    user_profile_id   bigint not null
        constraint fk8dflg2m73h6q8dtlt0t8sc9b
            references user_profile
);

-- ALTER TABLE manhwa_profile_user_profile
--     OWNER TO aron;

