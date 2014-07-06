1、系统使用springMVC和mybatis以及tiles-jsp模板引擎
2、HTML、CSS 和 JS 框架使用的是Bootstrap——v3
	官网地址http://getbootstrap.com/
	中文站http://v3.bootcss.com/
3、项目管理工具使用的是maven
	maven中央库地址请修改为国内地址"http://maven.oschina.net/content/groups/public/"
4、src\main\resources\data下面是数据脚本和上传模板
	本项目的数据库脚本在src\main\resources\data\database\schema\loansys_tables.sql
5、系统使用的配置文件统一在文件夹src\main\resources\META-INF\
	3.1、数据库连接地址文件在src\main\resources\META-INF\properties\database.properties
	3.2、src\main\resources\META-INF\mybatis\
	3.3、src\main\resources\META-INF\spring\


	由于是把别人（https://github.com/liratanak/SpdSample-Spring-MVC-3-MyBatis-3-Tiles-3）
	的框架拿过来直接用有些最初的东西尚未删除，等完成后即可删除，或者保留

	导入的时候选择maven项目找到pom.xml导入即可
	
-------------
增加mybatis映射步骤
1、建立关系映射xml
/spdsample/src/main/resources/com/sds/loansys/domain/mapper/AbstractAccountMapper.xml
/spdsample/src/main/resources/com/sds/loansys/domain/mapper/Account.xml

2、建立实体类
/spdsample/src/main/java/com/sds/loansys/domain/entity/AbstractAccount.java
/spdsample/src/main/java/com/sds/loansys/domain/entity/AccountMapper.java

3、写
/spdsample/src/main/java/com/sds/loansys/domain/entity/mapper/AccountMapper.java

4、写
/spdsample/src/main/java/com/sds/loansys/service/AccountService.java
5、写 账户控制器
/spdsample/src/main/java/com/sds/loansys/controller/AccountController.java