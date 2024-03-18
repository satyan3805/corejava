create database PaymentCLIapp;

Show Databases;

show tables;

use PaymentCLIapp;

CREATE TABLE UserInfo (
    UserId INT NOT NULL,
    FirstName VARCHAR(25),
    LastName VARCHAR(25),
    PhoneNo varchar(15),
    DateOfBirth VARCHAR(25),
    Address VARCHAR(100),
    PassWord VARCHAR(25),
    CurrWalletBal double(7,2),
    PRIMARY KEY (UserId)
);
show tables;
Select * from user;
-- drop table user;
describe userinfo;

create table BankAccountTypeDetails(
	BankAcctTypeId int,
    BankAcctTypeCode varchar(3),
    BankAcctTypeDesc varchar(50),
    primary key(BankAcctTypeId)
 );

CREATE TABLE BankAccountDetails (
    BankAcctNo varchar(16) NOT NULL,
    BankAcctBankName VARCHAR(50),
    AcctTypeId int,
    BankIFSCCode VARCHAR(10),
    BankAcctPin INT,
    UserId INT,
    CurrBankAcctBalance double(12,2),
    FOREIGN KEY (UserId) REFERENCES userinfo (UserId),
    FOREIGN KEY (AcctTypeId) REFERENCES BankAccountTypeDetails (BankAcctTypeId),
    PRIMARY KEY (BankAcctNo)
);
 describe BankAccountDetails;
 drop table BankAccount;
 
 CREATE TABLE TransactionDetails (
    TxnId int(10) NOT NULL,
    TxnDate datetime,
    TxnAmount DOUBLE,
    TxnType ENUM("CREDIT","DEBIT"),
    UserId int,
    AcctType ENUM("BA","WA","CASH"),
    FOREIGN KEY (UserId) REFERENCES userInfo (UserId),
    PRIMARY KEY (TxnId)
);
  describe Transaction;
 drop table Transaction;
-- CREATE TABLE WalletAcctDetails (
--     UserId INT,
--     FOREIGN KEY (UserId) REFERENCES user (UserId),
--     Balance DOUBLE
-- );
 describe Wallet;
 drop table Wallet;
 
 show tables;
 alter table userinfo rename user_info; 
 alter table user_info modify userid int auto_increment;
 desc user_info;
 alter table transactiondetails rename transaction_details;
 alter table transaction_details add foreign key(userid) references user_info(userid);
 alter table bankaccounttypedetails rename bankacct_type_details;
 alter table bankaccountdetails rename bankacct_details;
 alter table bankacct_details drop foreign key bankacct_details_ibfk_1;

alter table bankacct_details add foreign key(userid) references user_info(userid);

 alter table transaction_details drop foreign key transaction_details_ibfk_1;
 alter database paymentcliapp rename payment_cli_app;
 desc user_info;
 desc bankacct_details;
 desc INFORMATION_SCHEMA.key_column_usage;
 
select * from INFORMATION_SCHEMA.key_column_usage
where table_name ='transaction_details';
select * from  INFORMATION_SCHEMA.TABLE_CONSTRAINTS 
where table_name ='bankacct_details'
column_name='userid';
 
 
 
 

 