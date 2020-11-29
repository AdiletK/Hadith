insert into category_table(id, create_date, status, update_date, title)
VALUES (1, current_date, 0, current_date, 'Category 1');
insert into category_table(id, create_date, status, update_date, title)
VALUES (2, current_date, 0, current_date, 'Category 2');

insert into book_table(id, create_date, status, update_date, author, description, title)
VALUES (1, current_date, 0, current_date, 'Author 1', 'Description .....', 'Book 1');
insert into book_table(id, create_date, status, update_date, author, description, title)
VALUES (2, current_date, 0, current_date, 'Author 2', 'Description .....', 'Book 2');

insert into hadith_table(id, create_date, status, update_date, description, title, category_id, book_id)
VALUES (1,current_date, 0, current_date, 'Description .....', 'Hadith 1', 1, 1) ;
insert into hadith_table(id, create_date, status, update_date, description, title, category_id, book_id)
VALUES (2,current_date, 0, current_date, 'Description .....', 'Hadith 2', 1, 1) ;
insert into hadith_table(id, create_date, status, update_date, description, title, category_id, book_id)
VALUES (3,current_date, 0, current_date, 'Description .....', 'Hadith 3', 2, 2) ;
insert into hadith_table(id, create_date, status, update_date, description, title, category_id, book_id)
VALUES (4,current_date, 0, current_date, 'Description .....', 'Hadith 4', 2, 2) ;

insert into login_table (id, create_date, status, update_date, credential, password, type)
values (1, current_date, 0, current_date, '10.123.323.23.123', '', 0);
insert into login_table (id, create_date, status, update_date, credential, password, type)
values (2, current_date, 0, current_date, '0550985580', '123456', 1);

insert into setting_table(id, create_date, status, update_date, count_of_notif, is_notif_enabled)
VALUES (1, current_date, 0, current_date, 1, true);
insert into setting_table(id, create_date, status, update_date, count_of_notif, is_notif_enabled)
VALUES (2, current_date, 0, current_date, 1, true);

insert into user_table (id, create_date, status, update_date, user_name, login_entity_id,setting_entity_id)
values (1, current_date, 0, current_date, 'User 1', 1, 1);
insert into user_table (id, create_date, status, update_date, user_name, login_entity_id,setting_entity_id)
values (2, current_date, 0, current_date, 'User 2', 2, 2);

insert into saves_table (id, create_date, status, update_date, hadyth_id, user_id)
values (1, current_date, 0, current_date, 1, 1);
insert into saves_table (id, create_date, status, update_date, hadyth_id, user_id)
values (2, current_date, 0, current_date, 2, 1);
insert into saves_table (id, create_date, status, update_date, hadyth_id, user_id)
values (3, current_date, 0, current_date, 3, 1);

