insert into lang_table(status, title)
values (0, 'ru');
insert into lang_table(status, title)
values (0, 'ky');
insert into lang_table(status, title)
values (0, 'en');

insert into book_table(status, author, description, title, language_id)
values (0, 'Test author', 'description text', 'Test Title',
        (select id from lang_table where lang_table.title = 'ru'));

insert into source_table(status, title, language_id)
values (0, 'Test Source', (select id from lang_table where lang_table.title = 'ru'));

insert into category_table(status, title, language_id)
values (0, 'Test Category',  (select id from lang_table where lang_table.title = 'ru'));

insert into category_table(status, title, language_id)
values (0, 'Test Category1',  (select id from lang_table where lang_table.title = 'ru'));