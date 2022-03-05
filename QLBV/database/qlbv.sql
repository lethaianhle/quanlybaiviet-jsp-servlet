use qlbv;

create table role(
role_id bigint not null primary key auto_increment,
role_name varchar(255) not null,
role_code varchar(255) not null,
created_date Timestamp null,
modified_date timestamp null,
created_by varchar(255) null,
modified_by varchar(255) null
);

create table user(
user_id bigint not null primary key auto_increment,
username varchar(150) not null,
password varchar(150) not null,
fullname varchar(150) null,
status int not null,
created_date timestamp null,
modified_date timestamp null,
created_by varchar(255) null,
modified_by varchar(255) null,
role_id bigint not null
);

alter table user add constraint fk_user_role foreign key (role_id) references role(role_id);

create table news (
new_id bigint not null primary key auto_increment,
title varchar(255) null,
thumbnail varchar(255) null,
description TEXT null,
content text null,
created_date timestamp null,
modified_date timestamp null,
created_by varchar(255) null,
modified_by varchar(255) null,
category_id bigint not null
);

create table category (
category_id bigint not null primary key auto_increment,
category_name varchar(255) not null,
category_code varchar(255) not null,
created_date timestamp null,
modified_date timestamp null,
created_by varchar(255) null,
modified_by varchar(255) null
);

alter table news add constraint fk_new_category foreign key (category_id) references category(category_id);

create table comment (
comment_id bigint not null primary key auto_increment,
user_id bigint not null,
new_id bigint not null,
content text not null,
created_date timestamp null,
modified_date timestamp null,
created_by varchar(255) null,
modified_by varchar(255) null
);

alter table comment add constraint fk_comment_user foreign key (user_id) references user(user_id);
alter table comment add constraint fk_comment_new foreign key (new_id) references news(new_id); 