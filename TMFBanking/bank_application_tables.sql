use test_banking;

-- drop database test_banking;
show tables;

drop table account_details;

create table account_details(
		acct_no int AUTO_INCREMENT,
        acct_holder_id int NOT NULL UNIQUE,
        curr_bal double,
        last_txn_date_time datetime,	
        acct_ifsc_code varchar(10) NOT NULL,
        acct_type_id int NOT NULL DEFAULT 1,
        PRIMARY KEY (acct_no),
		FOREIGN KEY (acct_type_id) REFERENCES account_types(account_type_id)
);

create table account_types(
	account_type_id int,
    account_type_name varchar(20),
     primary key(account_type_id)
);

insert into account_types(account_type_id,account_type_name) values(1,'SAVINGS ACCOUNT');
insert into account_types(account_type_id,account_type_name) values(2,'CURRENT ACCOUNT');
insert into account_types(account_type_id,account_type_name) values(3,'LOAN ACCOUNT');
insert into account_types(account_type_id,account_type_name) values(4,'SALARY ACCOUNT');
insert into account_types(account_type_id,account_type_name) values(5,'BUSINESS ACCOUNT');
show tables;

desc account_types;

describe account_details;
desc account_details;

-- drop table account_details;

ALTER TABLE account_details
ADD dummy_col int;

alter table account_details
drop column dummy_col;

alter table account_details
modify column dummy_col varchar(20);

ALTER TABLE account_details
RENAME COLUMN dummy_col to new_dummy_col;

insert into account_details(acct_holder_id,curr_bal,last_txn_date_time,acct_ifsc_code,acct_type_id)
values(105,1500.00,'2023-12-12','TMF001',3);

select * from account_details;