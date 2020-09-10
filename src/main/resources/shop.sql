create database if not exists flowershop default CHARSET utf8 collate utf8_general_ci;
use flowershop;
create table if not exists tb_user(
	uid int(11) primary key auto_increment,
	uname varchar(100)  null,
	account varchar(200) not null unique,
	pwd varchar(200) not null,
	sex char(1)  null,
	tel varchar(20) null unique,
	email varchar(100) null unique,
	headImg varchar(200) null,
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;


create table if not exists tb_adm(
	aid int(11) primary key auto_increment,
	account varchar(200) not null unique,
	aname varchar(100) not null,
	pwd varchar(200) not null,
	tel varchar(20) not null unique,
	headImg varchar(200) not null,
	# role=1为超级管理员否则为普通管理员
	role char(1) not null, 
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;

# 种类
create table if not exists tb_type(
	tid int(11) primary key auto_increment,
	tname varchar(100) not null,
	description varchar(255) null,
	typeImg  varchar(200) not null,
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;
# 花系
create table if not exists tb_series(
	sid int(11) primary key auto_increment,
	sname varchar(100) not null,
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;

create table if not exists tb_flower(
	fid int(11) primary key auto_increment,
	fname varchar(100) not null,
	description text not null,
	flowerLan varchar(500) not null,#花语
	deliveryDesc varchar(100) not null, #配送说明
	price decimal(6,2) not null,
	flowerImg varchar(200) not null,
	intro varchar(255) null,//简述
	pack varcahr(255) null,//包装
	sale varchar(3) not null,#折扣
	store varchar(5) not null,
	tid int(11) not null,
	sid int(11) null, 
	status char(1) not null,
	constraint `fk_flower_tid` foreign key(`tid`) references `tb_type`(`tid`),
	constraint `fk_flower_sid` foreign key(`sid`) references `tb_series`(`sid`)
)auto_increment=101 engine=InnoDB default charset=utf8;

create table if not exists tb_address(
	aid int(11) primary key auto_increment,
	city varchar(100) not null,
	details varchar(200) not null,
	flag char(1) not null,#默认地址
	tel varchar(50) not null,
	label varchar(50) null,#标签
	nickName varchar(100) not null,#昵称
	uid int(11),
	status char(1) not null,
	constraint `tb_address_uid` foreign key(`uid`) references `tb_user`(`uid`)
)auto_increment=101 engine=InnoDB default charset=utf8;


create table if not exists tb_order(
	oid int(11) primary key,
	createDate date not null,#创建时间
	receiveDate date null,#收货时间
	payDate date null,#付款时间
	sendDate date null,#发货时间
	amount decimal(7,2) not null,
	address varchar(255) null,
	tel varchar(255) null,
	uid int(11) not null,
	status char(1) not null,
	constraint `tb_order_uid` foreign key(`uid`) references `tb_user`(`uid`)
)engine=InnoDB default charset=utf8;

create table if not exists tb_order_details(
	odid int(11) primary key auto_increment,
	num varchar(10) not null,
	fname varchar(255) not null,
	price decimal(7,2),
	sale varchar(3),
	oid int(11),
	constraint `fk_order_details_oid` foreign key(`oid`) references `tb_order`(`oid`),
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;

create table if not exists tb_comments(
	cid int(11) primary key auto_increment,
	cdate date not null,
	level char(1) not null,#星级评价
	details text not null,
	uid int(11) not null,
	fid int(11) not null,
	constraint `fk_comments_fid` foreign key(`fid`) references `tb_flower`(`fid`),
	constraint `fk_comments_uid` foreign key(`uid`) references `tb_user`(`uid`),
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;

# 广告表
create table if not exists tb_advertisement(
	atid int(11) primary key auto_increment,
	url varchar(200) not null,
	adImg varchar(200) not null,
	position varchar(20) not null, #广告位置
	status char(1) not null
)auto_increment=101 engine=InnoDB default charset=utf8;



INSERT INTO `tb_adm` (`account`,`aname`, `pwd`, `tel`, `headImg`, `role`, `status`) VALUES ('tom_ac','tom', '123456', '12345678998', 'img.jpg', '1', '1');
INSERT INTO `tb_adm` (`account`,`aname`, `pwd`, `tel`, `headImg`, `role`, `status`) VALUES ('jack_ac','jack', '123456', '12345665462', 'head.jpg', '0', '1');