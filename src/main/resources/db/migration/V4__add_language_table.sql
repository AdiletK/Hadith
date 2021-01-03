create table lang_table
(
    id          int8 not null
        constraint lang_table_pkey
            primary key,
    create_date timestamp,
    status      integer,
    update_date timestamp,
    title       varchar(255)
        constraint uk_h96v50y1x4ktrsqt1njhdne1x
            unique
);
ALTER TABLE book_table
    ADD language_id int8,
    ADD CONSTRAINT book_table_fk_for_lang_id FOREIGN KEY (language_id) REFERENCES lang_table (id);

ALTER TABLE category_table
    ADD language_id int8,
    ADD CONSTRAINT category_table_fk_for_lang_id FOREIGN KEY (language_id) REFERENCES lang_table (id);

ALTER TABLE source_table
    ADD language_id int8,
    ADD CONSTRAINT source_table_fk_for_lang_id FOREIGN KEY (language_id) REFERENCES lang_table (id);

ALTER TABLE hadith_table
    ADD language_id int8,
    ADD CONSTRAINT hadith_table_fk_for_lang_id FOREIGN KEY (language_id) REFERENCES lang_table (id);


