# BookStoreSystem

该项目通过Spring IOC、MyBatis、Servlet、Maven及Spring整合MyBatis的等技术完成一个简单的图书管理功能，实现图书列表、删除、多删除、编辑、新增功能，做一个完整的示例完成一个简单的图书管理功能，主要使用到的技术包含Spring、MyBatis、Maven、MySQL及简单MVC等


一、新建一个基于Maven的Web项目

二、创建数据库与表

三、添加依赖包
项目主要依赖的jar包有Spring核心包、Spring AOP包、MyBatis ORM包、MyBatis-Spring适配包、JSTL、JUnit、Log4j2等，具体见pom.xml

四、新建POJO实体层
为了实现与数据库中的books表进行关系映射，新建一个Book类

五、新建MyBatis SQL映射层
这个项目中我们采用接口与xml的形式完成关系与对象间的映射，在接口中定义一些数据访问的方法，在xml文件中定义实现数据访问需要的sql脚本；并为MyBatis ORM创建的映射文件BookMapper.xml

六、完成Spring整合MyBatis配置
db.properties文件用于存放数据库连接信息
applicationContext.xml文件，用于整合MyBatis与Spring

七、创建服务层
Service层实现图书管理系统的业务逻辑，另外给bookdao成员变量注解为自动装配，service类注解为IOC组件。

八、JUnit测试服务类
为了确保服务类中的每个方法正确，先使用JUnit进行单元测试

九、加载Spring容器与获得容器对象
添加加载Spring容器用的监听器；定义一个CtxUtil工具类来获得Spring容器实例；

十、简单MVC控制器封装
为了实现一个简单的MVC基础控制器，定义了一个叫BaseController的Servlet，可以让其它的Servlet继承该Servlet获得部分MVC功能

十一、完成图书管理功能

11.1、定义BookController控制器
该控制器继承BaseController，中间每一个参数为（HttpServletRequest request,HttpServletResponse response）的方法都充当一个Action

11.2、图书列表与删除
定义视图ListBook.jsp，用于完成图书管理，实现图书的列表、删除与多删除功能

11.3、新增图书功能
定义页面AddBook.jsp完成添加图书功能，在控制器中有两个Action对应新增功能，一个是AddBook，完成页面展示；另一个是AddBookPost处理保存事件

11.4、编辑图书功能
定义页面EditBook.jsp完成更新图书功能，在控制器中有两个Action对应更新功能，一个是EditBook，完成页面展示与加载要编辑图书实体的信息；另一个是EditBookPost处理保存事件

11.5、首页与样式
定义index.jsp页面，让其转发到指定的控制器；定义main.css
