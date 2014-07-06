--单位表
CREATE TABLE "DB2ADMIN"."T_COMPANY"(
	ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1 ),
	NO VARCHAR(20),
	companyname VARCHAR(50),
	principalname VARCHAR(20),
	totalmoney DOUBLE,
	mobile VARCHAR(11),
	address VARCHAR(100),
	remark VARCHAR(2000),
	gongzibanjihuashu INTEGER,
	qiyejihuashu INTEGER,
	createtime TIMESTAMP,
	createuser VARCHAR(20)
)
INSERT INTO T_COMPANY (NO,COMPANYNAME,PRINCIPALNAME,TOTALMONEY,MOBILE,ADDRESS,REMARK,GONGZIBANJIHUASHU,QIYEJIHUASHU,CREATETIME,CREATEUSER) 
VALUES ("C20140626000000","腾讯","马化腾",9.9919999112121E7,"13012345678","深圳大马路","有借有还再借不难",10,10,"2014-06-26 23:29:27.0","cd");
INSERT INTO T_COMPANY (NO,COMPANYNAME,PRINCIPALNAME,TOTALMONEY,MOBILE,ADDRESS,REMARK,GONGZIBANJIHUASHU,QIYEJIHUASHU,CREATETIME,CREATEUSER) 
VALUES ("C20140629142157364","北京消防局","消防局",100000.0,"13232323232","长安街88号","2222",12,11,"2014-06-29 14:22:18.917","局长");
INSERT INTO T_COMPANY (NO,COMPANYNAME,PRINCIPALNAME,TOTALMONEY,MOBILE,ADDRESS,REMARK,GONGZIBANJIHUASHU,QIYEJIHUASHU,CREATETIME,CREATEUSER) 
VALUES ("C20140630230123905","卓展购物中心","卓展购物",100000.0,"010-098765","复兴路69 ","地址： 	复兴路69 ",1,1,"2014-06-30 23:04:47.054","卓展");
INSERT INTO T_COMPANY (NO,COMPANYNAME,PRINCIPALNAME,TOTALMONEY,MOBILE,ADDRESS,REMARK,GONGZIBANJIHUASHU,QIYEJIHUASHU,CREATETIME,CREATEUSER) 
VALUES ("C20140629203313215","北京北站","北站负责人",7654321.0,"13487655432","北京市西城区北滨河路1号 ","地址：  北京市西城区北滨河路1号  ",12,123,"2014-06-29 20:34:31.417","北站创建人");
INSERT INTO T_COMPANY (NO,COMPANYNAME,PRINCIPALNAME,TOTALMONEY,MOBILE,ADDRESS,REMARK,GONGZIBANJIHUASHU,QIYEJIHUASHU,CREATETIME,CREATEUSER) 
VALUES ("C20140629202548903","北京市人力资源和社会保障局","张欣庆",1000001.0,"13212345678","北京市宣武区永定门西街5","2012年7月3日，当选为中国共产党北京市第十一届委员会委员",22,213,"2014-06-29 20:39:40.966","张欣庆");
INSERT INTO T_COMPANY (NO,COMPANYNAME,PRINCIPALNAME,TOTALMONEY,MOBILE,ADDRESS,REMARK,GONGZIBANJIHUASHU,QIYEJIHUASHU,CREATETIME,CREATEUSER) 
VALUES ("C20140630230706640","陶然亭公园","陶然亭",1.1111111E7,"01063588801","北京市西城区太平街１９号（护城河北岸） ","北京市西城区太平街１９号（护城河北岸） ",12,11,"2014-06-30 23:08:17.556","陶然亭");
INSERT INTO T_COMPANY (NO,COMPANYNAME,PRINCIPALNAME,TOTALMONEY,MOBILE,ADDRESS,REMARK,GONGZIBANJIHUASHU,QIYEJIHUASHU,CREATETIME,CREATEUSER) 
VALUES ("C20140630230842638","龙潭公园","龙潭公园",1.2345678E7,"01067144336","地址： 	东城区龙潭路8号(近华普超市) ","地址： 	东城区龙潭路8号(近华普超市) ",2,1,"2014-06-30 23:09:30.27","龙潭公园");
INSERT INTO T_COMPANY (NO,COMPANYNAME,PRINCIPALNAME,TOTALMONEY,MOBILE,ADDRESS,REMARK,GONGZIBANJIHUASHU,QIYEJIHUASHU,CREATETIME,CREATEUSER) 
VALUES ("C20140704003401467","海底捞(石景山店)","海底捞",28.0,"01088689558","北京石景山区石景山路乙18号万达广场c栋4楼(近1号线八宝山地铁站)","服务不错，服务员态度很好，工作到位，东西也很好吃，高峰时需要等一段时间，价格小贵，海底捞的风格，不计较银子的朋友是不错的选择。 ",23,21,"2014-07-04 00:34:01.467","cd");


--单位变更表
CREATE TABLE "DB2ADMIN"."T_COMPANYCHANGE"(
	ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1 ),
	NO VARCHAR(20),
	companyname VARCHAR(50),
	principalname VARCHAR(20),
	totalmoney DOUBLE,
	mobile VARCHAR(11),
	address VARCHAR(100),
	remark VARCHAR(2000),
	gongzibanjihuashu INTEGER,
	qiyejihuashu INTEGER,
	createtime TIMESTAMP,
	createuser VARCHAR(20),
	comid INTEGER,
	updatetime TIMESTAMP,
	updateuser VARCHAR(20),
	version VARCHAR(20)
)
--
CREATE TABLE "DB2ADMIN"."T_ACCOUNT"(
	ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1 ),
	NO VARCHAR(20),
	companyid INTEGER,
	accountname VARCHAR(20),
	money DOUBLE,
	moneytype INTEGER,
	savetime TIMESTAMP,
	tacktime TIMESTAMP,
	interesttime TIMESTAMP,
	interest DOUBLE,
	payflag INTEGER,
	isbankbook INTEGER,
	bankno VARCHAR(30),
	idno VARCHAR(18),
	mobile	VARCHAR(11),
	address VARCHAR(100),
	remark	Varchar(2000),
	createtime TIMESTAMP,
	createuser VARCHAR(20)
)
INSERT INTO T_ACCOUNT (NO,companyid,accountname,money,moneytype,savetime,tacktime,interesttime
,interest,payflag,isbankbook,bankno,idno,mobile,address,remark,createtime,createuser) 
VALUES ('A20140626000000',12,'马化腾',9.9919999112121E7,1,'2014-06-26 23:29:27.0','2014-06-26 23:29:27.0','2014-06-26 23:29:27.0',12,1,1,'123','123','13041234666','大马力','测试','2014-06-26 23:29:27.0','12');




SELECT   ID,NO,companyname,principalname,totalmoney,mobile,address,remark,gongzibanjihuashu,qiyejihuashu,createtime,createuser   FROM T_COMPANY   where NO like '%北京%' or companyname like   '%北京%' or principalname like   '%北京%' or mobile like   '%北京%' or address like   '%北京%' or remark like   '%北京%'   or createuser like '%北京%'

update T_COMPANY set totalmoney = 99919999.112121 where id=1
SELECT CAST(totalmoney AS VARCHAR(10)),TRIM(CHAR(DOUBLE(totalmoney))) FROM T_COMPANY

SELECT * FROM T_COMPANY 

alter table T_COMPANY alter principalname set data type varchar(20) 
alter table T_COMPANY alter ID set data type INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1 )
--修改id为自增的字段
alter table T_COMPANY alter column ID set generated always as identity(start with 1,increment by 1,no cache)
--分页
SELECT  *,rownumber() over(ORDER BY id desc) AS rn FROM T_COMPANY as c where c.rn BETWEEN 1 AND 6 


CREATE TABLE "DB2ADMIN"."T_COMPANY"(
ID INTEGER PRIMARY KEY not null,
NO VARCHAR,
COMPANYNAME VARCHAR,
PRINCIPALNAME VARCHAR,
TOTALMONEY DOUBLE,
MOBILE VARCHAR,
ADDRESS VARCHAR,
REMARK VARCHAR,
GONGZIBANJIHUASHU INTEGER,
QIYEJIHUASHU INTEGER,
CREATETIME TIMESTAMP,
CREATEUSER VARCHAR)


INSERT INTO T_COMPANY (NO,COMPANYNAME,PRINCIPALNAME,TOTALMONEY,MOBILE,ADDRESS,REMARK,GONGZIBANJIHUASHU,QIYEJIHUASHU,CREATETIME,CREATEUSER) 
VALUES ('C20140629201312231','腾讯','马化腾',30000000,'13012345678','深圳大马路','有借有还再借不难',10,10,'2014-6-26 23:29:27','cd')

INSERT INTO T_COMPANY (COMPANYNAME) 
VALUES ('腾讯1')

select * from T_company

CREATE TABLE "DB2ADMIN"."T_POST"(
ID INTEGER PRIMARY KEY not null,
DELETED CHAR default '0',
CREATION_DATETIME TIMESTAMP,
MODIFICATION_DATETIME TIMESTAMP,
TITLE VARCHAR,
CONTENT VARCHAR)

<id property="id" column="ID" />
		<result property="s_NO" column="NO" />
		<result property="s_companyname" column="companyname" />
		<result property="s_principalname" column="principalname" />
		<result property="d_totalmoney" column="totalmoney" />
		<result property="s_mobile" column="mobile" />
		<result property="s_address" column="address" />
		<result property="i_gongzibanjihuashu" column="gongzibanjihuashu" />
		<result property="i_qiyejihuashu" column="qiyejihuashu" />
		<result property="t_createtime" column="createtime" />
		<result property="s_createuser" column="createuser" />