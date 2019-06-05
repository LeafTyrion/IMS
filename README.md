# IMS(Library Management System)图书管理系统
### 设计功能：
1. 新书录入，借书、还书
2. 用户登陆
3. 每个用户只能借3本书，两个月内归还
4. 能查询指定书的状态、能查询逾期的书、能查询每个用户借了哪些书
5. 借书的历史，每本书可以查询看过的人
### 开发环境：
IDEA、JDK8
### 包说明：
##### controller
* BookController：对系统图书操作常用类的封装
* OptionController：对主界面操作层的封装
##### DataBase
* DataBase：虚拟数据库
* VirData：运行时加载预定义虚拟信息
##### entity
* 实体类层，有User、Book、UserBook三个实体
##### service
* LoginService：登录时的逻辑处理
* OptionService：对图书用户进行操作时的逻辑处理
##### Utils
* DBUtils：封装的工具类
* DateUtil：封装的日期类工具类
* SleepUtil：封装的线程工具类
##### view
* View：静态视图层
### 测试账号：
登录账号|登录密码
:-:|:-:|:-:
111|111111
222|222222
333|333333
### 待改进之处：
1. 若操作层接收字符串而非数字时，会导致程序崩溃
2. 用户权限没有分清
