ALTER TABLE hadith_translate_table
    DROP COLUMN book_id CASCADE;

ALTER TABLE hadith_translate_table
    ADD COLUMN position int4;

ALTER TABLE category_table
    ADD COLUMN position int4;

ALTER TABLE category_table
    ADD COLUMN book_id int8;

ALTER  TABLE  category_table
    ADD CONSTRAINT FK_BOOK_ID FOREIGN KEY (book_id)
    REFERENCES book_table;