
create table source_table (id int8 not null,
create_date timestamp, status int4, update_date timestamp,
title varchar(255), primary key (id));

alter table source_table add constraint UK_source_table_fk unique (title);

create table source_hadith(hadith_id int8, source_id int8);

alter table source_hadith add constraint fk_for_source_id foreign key (source_id) references source_table;
alter table source_hadith add constraint fk_for_hadith_id foreign key (hadith_id) references hadith_table;


