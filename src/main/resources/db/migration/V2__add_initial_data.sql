insert into user_table (id, create_date, status, update_date, password,
                        user_name, login_entity_id, setting_entity_id)
VALUES (1, current_date, 0, current_date,
        '$2y$12$ERoxAGVeNpYQY/Hd/ixB..jeR7UwH0xUR0N5p/cHCqRZ8SAeSR/oW',
        'Admin', null,null);
insert into user_entity_roles(user_entity_id, roles)
VALUES (1, 0);
insert into user_entity_roles(user_entity_id, roles)
VALUES (1, 1);