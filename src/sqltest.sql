select * from member
select * from admin
drop table admin
drop table member
drop table pc
drop table payment
drop table seat
drop table product
drop table pc_order

CREATE TABLE member (
member_id varchar(30) not null,
member_pw varchar(30),
member_name varchar(30),
member_phonenum varchar(30),
CONSTRAINT mem_id_pk primary key (member_id));

select * from member

CREATE TABLE admin (
admin_id varchar(30) not null,
admin_pw varchar(30),
admin_name varchar(30),
member_id varchar(30),
CONSTRAINT adm_id_pk primary key (admin_id),
CONSTRAINT mem_num1_fk foreign key (member_id)
references member(member_id));

select * from admin

CREATE TABLE pc (
pc_num number(5) not null,
pc_onoff char(1),
member_id varchar(30),
CONSTRAINT boolean_onoff_ck check(pc_onoff in ('0', '1')),
CONSTRAINT pc_num_pk primary key (pc_num),
CONSTRAINT mem_id2_fk foreign key (member_id)
references member(member_id));

select * from pc

CREATE TABLE seat (
pc_num number(5),
member_id varchar(30),
starttime date,
stoptime date,
remainingtime date,
CONSTRAINT pc_num1_fk foreign key (pc_num)
references pc(pc_num),
CONSTRAINT mem_id5_fk foreign key (member_id)
references member(member_id));

select * from seat

CREATE TABLE payment (
card_num varchar(30) not null,
member_id varchar(30),
charge_amount number(10),
CONSTRAINT card_num_pk primary key (card_num),
CONSTRAINT mem_id4_fk foreign key (member_id)
references member(member_id));

select * from payment

CREATE TABLE product (
product_num varchar(30),
product_name varchar(30) not null,
product_price number(10),
product_quantity number(10),
product_re_quantity number(10),
CONSTRAINT prd_name_pk primary key (product_name));

select * from product

CREATE TABLE pc_order (
pc_num number(5),
member_id varchar(30),
product_name varchar(30),
card_num varchar(30),
order_time date,
order_quantity number(10),
CONSTRAINT pc_num3_fk foreign key (pc_num)
references pc(pc_num),
CONSTRAINT mem_id3_fk foreign key (member_id)
references member(member_id),
CONSTRAINT prd_name_fk foreign key (product_name)
references product(product_name),
CONSTRAINT card_num_fk foreign key (card_num)
references payment(card_num));

select * from pc_order

insert into admin(admin_id,admin_pw,admin_name) values('admin','1234','¼±ÀÎÀå')

select * from admin

insert into pc(pc_num, pc_onoff) values(1, 0)
insert into pc(pc_num, pc_onoff) values(2, 0)
insert into pc(pc_num, pc_onoff) values(3, 0)
insert into pc(pc_num, pc_onoff) values(4, 0)
insert into pc(pc_num, pc_onoff) values(5, 0)
insert into pc(pc_num, pc_onoff) values(6, 0)
insert into pc(pc_num, pc_onoff) values(7, 0)
insert into pc(pc_num, pc_onoff) values(8, 0)
insert into pc(pc_num, pc_onoff) values(9, 0)
insert into pc(pc_num, pc_onoff) values(10, 0)
insert into pc(pc_num, pc_onoff) values(11, 0)
insert into pc(pc_num, pc_onoff) values(12, 0)
insert into pc(pc_num, pc_onoff) values(13, 0)
insert into pc(pc_num, pc_onoff) values(14, 0)
insert into pc(pc_num, pc_onoff) values(15, 0)
insert into pc(pc_num, pc_onoff) values(16, 0)
insert into pc(pc_num, pc_onoff) values(17, 0)
insert into pc(pc_num, pc_onoff) values(18, 0)
insert into pc(pc_num, pc_onoff) values(19, 0)
insert into pc(pc_num, pc_onoff) values(20, 0)
insert into pc(pc_num, pc_onoff) values(21, 0)
insert into pc(pc_num, pc_onoff) values(22, 0)
insert into pc(pc_num, pc_onoff) values(23, 0)
insert into pc(pc_num, pc_onoff) values(24, 0)
insert into pc(pc_num, pc_onoff) values(25, 0)
insert into pc(pc_num, pc_onoff) values(26, 0)
insert into pc(pc_num, pc_onoff) values(27, 0)
insert into pc(pc_num, pc_onoff) values(28, 0)
insert into pc(pc_num, pc_onoff) values(29, 0)
insert into pc(pc_num, pc_onoff) values(30, 0)
insert into pc(pc_num, pc_onoff) values(31, 0)
insert into pc(pc_num, pc_onoff) values(32, 0)
insert into pc(pc_num, pc_onoff) values(33, 0)
insert into pc(pc_num, pc_onoff) values(34, 0)
insert into pc(pc_num, pc_onoff) values(35, 0)
insert into pc(pc_num, pc_onoff) values(36, 0)
insert into pc(pc_num, pc_onoff) values(37, 0)
insert into pc(pc_num, pc_onoff) values(38, 0)
insert into pc(pc_num, pc_onoff) values(39, 0)
insert into pc(pc_num, pc_onoff) values(40, 0)
insert into pc(pc_num, pc_onoff) values(41, 0)
insert into pc(pc_num, pc_onoff) values(42, 0)
insert into pc(pc_num, pc_onoff) values(43, 0)
insert into pc(pc_num, pc_onoff) values(44, 0)
insert into pc(pc_num, pc_onoff) values(45, 0)
insert into pc(pc_num, pc_onoff) values(46, 0)
insert into pc(pc_num, pc_onoff) values(47, 0)
insert into pc(pc_num, pc_onoff) values(48, 0)
insert into pc(pc_num, pc_onoff) values(49, 0)
insert into pc(pc_num, pc_onoff) values(50, 0)
commit

select * from pc order by pc_num;

insert into member values ('hi','1234','ÇÏÀÌ','0101111111')
insert into seat values(1,'hi',sysdate,to_date('09-09-2019 12:14:11','mm-dd-yyyy hh24:mi:ss'),to_date('09-09-2019 2:14:11','mm-dd-yyyy hh24:mi:ss'))
insert into seat values(1,'hi',sysdate,to_date('09-10-2019 12:14:11','mm-dd-yyyy hh24:mi:ss'),to_date('09-09-2019 3:14:11','mm-dd-yyyy hh24:mi:ss'))


select * from seat

update pc set pc_onoff=0 where pc_num between 1 and 50;
update pc set pc_onoff=0 where pc_num=2;
update pc set pc_onoff=0 where pc_num=3;
update pc set pc_onoff=0 where pc_num=4;
update pc set pc_onoff=0 where pc_num=5;
update pc set pc_onoff=0 where pc_num=6;
update pc set pc_onoff=0 where pc_num=7;
update pc set pc_onoff=0 where pc_num=8;
update pc set pc_onoff=0 where pc_num=9;
update pc set pc_onoff=0 where pc_num=10;
update pc set pc_onoff=0 where pc_num=11;
update pc set pc_onoff=0 where pc_num=12;
update pc set pc_onoff=0 where pc_num=50;
update pc set pc_onoff=0 where pc_num=49;
update pc set pc_onoff=0 where pc_num=48;
update pc set pc_onoff=0 where pc_num=45;
update pc set pc_onoff=0 where pc_num=44;
update pc set pc_onoff=0 where pc_num=42;
update pc set pc_onoff=0 where pc_num=13;



update pc set pc_onoff=0 where pc_num=20;






delete from seat
delete from pc_order
delete from payment
delete from member
delete from payment
delete from admin

select * from payment
select * from product
select * from member
select * from pc
select * from pc_order
select * from seat
insert into product values('001','³Ê±¸¸®',2000,200,0)
insert into product values('002','Âü±ú¶ó¸é',2000,200,0)
insert into product values('003','»õ¿ìÅÁ',2000,200,0)
insert into product values('004','½Å¶ó¸é',2000,200,0)
insert into product values('005','¿Õ¶Ñ²±',2000,200,0)
insert into product values('006','Áø¶ó¸é',2000,200,0)
insert into product values('007','Æ¢±è¿ìµ¿',2000,200,0)
insert into product values('008','Â¥ÆÄ°ÔÆ¼',2000,200,0)
insert into product values('009','À°°³Àå',2000,200,0)
insert into product values('010','»çÀÌ´Ù',1300,200,0)
insert into product values('011','Æ÷Ä«¸®',1300,200,0)
insert into product values('012','À£Ä¡½º',1300,200,0)
insert into product values('013','ÄÚÄ«ÄÝ¶ó',1300,200,0)
insert into product values('014','ÇÖ½Ä½º',1300,200,0)
insert into product values('015','¹ÐÅ°½º',1300,200,0)
insert into product values('016','¸¶¿îÆ¾µà',1300,200,0)
insert into product values('017','ÄÚÄÚÆÊ',1300,200,0)
insert into product values('018','È¯Å¸',1300,200,0)
insert into product values('019','ÄÜ¯…',2000,200,0)
insert into product values('020','²Ü²Ê¹è±â',1300,200,0)
insert into product values('021','¿ÀÂ¡¾îÁý',1300,200,0)
insert into product values('022','Æ÷Ä«Ä¨',1300,200,0)
insert into product values('023','Æ÷½ºÆ½',1300,200,0)
insert into product values('024','»ç¶Ç¹ä',1300,200,0)
insert into product values('025','»õ¿ì±ø',1300,200,0)
insert into product values('026','½ãÄ¨',1300,200,0)
insert into product values('027','¹úÁýÇÍÀÚ',1300,200,0)
insert into product values('028','ÇÜ¹ö°Å',3000,200,0)
insert into product values('029','Ä¡Áî½ºÆ½',3000,200,0)
insert into product values('030','½ºÆ½ÇÇÀÚ',3000,200,0)
insert into product values('031','»õ¿ìÆ¢±è',3000,200,0)
insert into product values('032','Âð¸¸µÎ',3000,200,0)
insert into product values('033','¼Ò¶±¼Ò¶±',3000,200,0)
insert into product values('034','ÇÖµµ±×',3000,200,0)
insert into product values('035','Å©¸²¿ìµ¿',6000,200,0)
insert into product values('036','»õ¿ìººÀ½¹ä',6000,200,0)

update product set product_quantity=200 where product_name = '³Ê±¸¸®';
update product set product_name='¼Ò¶±¼Ò¶±' where product_num = '033';
delete from product where product_name='»õ¿ìººÀ½¹ä'
select * from pc_order
delete from payment
delete from pc_order
delete from seat
delete from member
