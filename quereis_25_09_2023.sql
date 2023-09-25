desc expenses;

create table exp_categories(
	exp_cat_id PK
    exp_cat_name
);

create table expenses(
	exp_id int,
    ....
    ....
    exp_cat FK
    UNIQUE (exp_id)
    PRIMARY KEY (email_id, ph_no)
				sat123@gmail.com, 998877
                sat1234@gmail.com, 998877

);

select * from expenses;

delete from expenses;

alter table expenses add column exp_date date;

alter table expenses modify column exp_date datetime;

alter table expenses add unique(exp_id);
alter table expenses add primary key(exp_id);

insert into expenses values(5 ,'burger', 87.84,'2023-09-25 13:09:23');
insert into expenses(exp_amount,exp_desc) values(65, 'burger');

select * from expenses;
