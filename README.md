# SSMDemo
SSMDemo是一个集成了Spring+SpringMVC+MyBatis的Demo工程，以书籍数据管理为例提供了Web端书籍的增删改查，以及对应的Restfull格式的API接口。
 
## 介绍

####开发环境
IDEA
MySQL 8.0.19
Tomcat 9
Maven 3.6
#### 目录结构
<br/>├── java                                           #
<br/>│   └── com                                        #
<br/>│       └── dzq                                    #
<br/>│           ├── api                                #
<br/>│           │   ├── SwaggerConfig.java             # Swagger配置
<br/>│           │   ├── controller                     #
<br/>│           │   │   └── BookAPIController.java     # 书籍增删改查API
<br/>│           │   └── vo                             #
<br/>│           │       ├── BookListResponse.java      # 书籍列表返回对象
<br/>│           │       ├── BookResponse.java          # 书籍返回对象
<br/>│           │       └── ResponseBody.java          # 返回对象
<br/>│           └── demo                               #
<br/>│               ├── controller                     #
<br/>│               │   └── BookController.java        # 书籍增删改查控制器
<br/>│               ├── dao                            #
<br/>│               │   ├── BookMapper.java            # 书籍Mapper接口
<br/>│               │   └── BookMapper.xml             # 书籍Mapper的MyBatis文件
<br/>│               ├── pojo                           #
<br/>│               │   └── Books.java                 # 书籍数据模型
<br/>│               └── service                        #
<br/>│                   ├── BookService.java           # 书籍Service接口
<br/>│                   └── BookServiceImpl.java       # 书籍Service实现
<br/>├── resources                                      #
<br/>│   ├── applicationContext.xml                     # Spring框架配置文件
<br/>│   ├── database.properties                        # MySQL配置
<br/>│   ├── mybatis-config.xml                         # MyBatis配置
<br/>│   ├── spring-dao.xml                             # Spring整合MyBatis配置
<br/>│   ├── spring-mvc.xml                             # SpringMVC配置
<br/>│   └── spring-service.xml                         # Spring Service配置
<br/>└── webapp                                         #
<br/>    ├── WEB-INF                                    #
<br/>    │   ├── jsp                                    #
<br/>    │   │   ├── addBook.jsp                        # 添加书籍页面
<br/>    │   │   ├── allBook.jsp                        # 书籍列表页面
<br/>    │   │   └── updateBook.jsp                     # 更新书籍页面
<br/>    │   └── web.xml                                # Web配置
<br/>    ├── css                                        #
<br/>    │   └── bootstrap.min.css                      # bootstrap css
<br/>    └── index.jsp                                  # 主页
####  数据库
`
<br/>CREATE DATABASE `ssmbuild`;
<br/> 
<br/> USE `ssmbuild`;
<br/> 
<br/> DROP TABLE IF EXISTS `books`;
<br/> 
<br/> CREATE TABLE `books` (
<br/>   `bookID` INT(10) NOT NULL AUTO_INCREMENT COMMENT '书id',
<br/>   `bookName` VARCHAR(100) NOT NULL COMMENT '书名',
<br/>   `bookCounts` INT(11) NOT NULL COMMENT '数量',
<br/>   `detail` VARCHAR(200) NOT NULL COMMENT '描述',
<br/>   KEY `bookID` (`bookID`)
<br/> ) ENGINE=INNODB DEFAULT CHARSET=utf8
<br/> 
<br/> INSERT  INTO `books`(`bookID`,`bookName`,`bookCounts`,`detail`)VALUES 
<br/> (1,'Java',1,'从入门到放弃'),
<br/> (2,'MySQL',10,'从删库到跑路'),
<br/> (3,'Linux',5,'从进门到进牢');
`

#### Maven项目
1,pom依赖
`
<br/><dependencies>
<br/>        <!--Spring-->
<br/>        <dependency>
<br/>            <groupId>org.springframework</groupId>
<br/>            <artifactId>spring-webmvc</artifactId>
<br/>            <version>5.2.3.RELEASE</version>
<br/>        </dependency>
<br/>        <dependency>
<br/>            <groupId>org.springframework</groupId>
<br/>            <artifactId>spring-jdbc</artifactId>
<br/>            <version>5.2.3.RELEASE</version>
<br/>        </dependency>
<br/>        <!--Servlet - JSP -->
<br/>        <dependency>
<br/>            <groupId>javax.servlet</groupId>
<br/>            <artifactId>servlet-api</artifactId>
<br/>            <version>2.5</version>
<br/>        </dependency>
<br/>        <dependency>
<br/>            <groupId>javax.servlet.jsp</groupId>
<br/>            <artifactId>jsp-api</artifactId>
<br/>            <version>2.2</version>
<br/>        </dependency>
<br/>        <dependency>
<br/>            <groupId>javax.servlet</groupId>
<br/>            <artifactId>jstl</artifactId>
<br/>            <version>1.2</version>
<br/>        </dependency>
<br/>        <!--数据库驱动-->
<br/>        <dependency>
<br/>            <groupId>mysql</groupId>
<br/>            <artifactId>mysql-connector-java</artifactId>
<br/>            <version>8.0.19</version>
<br/>        </dependency>
<br/>        <!-- 数据库连接池 -->
<br/>        <dependency>
<br/>            <groupId>com.mchange</groupId>
<br/>            <artifactId>c3p0</artifactId>
<br/>            <version>0.9.5.2</version>
<br/>        </dependency>
<br/>        <!--Mybatis-->
<br/>        <dependency>
<br/>            <groupId>org.mybatis</groupId>
<br/>            <artifactId>mybatis</artifactId>
<br/>            <version>3.5.2</version>
<br/>        </dependency>
<br/>        <dependency>
<br/>            <groupId>org.mybatis</groupId>
<br/>            <artifactId>mybatis-spring</artifactId>
<br/>            <version>2.0.2</version>
<br/>        </dependency>
<br/>        <!-- JSON-->
<br/>        <dependency>
<br/>            <groupId>com.fasterxml.jackson.core</groupId>
<br/>            <artifactId>jackson-databind</artifactId>
<br/>            <version>2.9.5</version>
<br/>        </dependency>
<br/>        <dependency>
<br/>            <groupId>com.fasterxml.jackson.core</groupId>
<br/>            <artifactId>jackson-annotations</artifactId>
<br/>            <version>2.9.5</version>
<br/>        </dependency>
<br/>        <!-- lombok -->
<br/>        <dependency>
<br/>            <groupId>org.projectlombok</groupId>
<br/>            <artifactId>lombok</artifactId>
<br/>            <version>1.18.12</version>
<br/>            <scope>provided</scope>
<br/>        </dependency>
<br/>        <!--      Swagger-->
<br/>        <dependency>
<br/>            <groupId>io.springfox</groupId>
<br/>            <artifactId>springfox-swagger2</artifactId>
<br/>            <version>2.9.2</version>
<br/>        </dependency>
<br/>        <dependency>
<br/>            <groupId>io.springfox</groupId>
<br/>            <artifactId>springfox-swagger-ui</artifactId>
<br/>            <version>2.9.2</version>
<br/>        </dependency>
<br/>        <!-- swagger-bootstrap-ui -->
<br/>        <dependency>
<br/>            <groupId>com.github.xiaoymin</groupId>
<br/>            <artifactId>swagger-bootstrap-ui</artifactId>
<br/>            <version>1.9.6</version>
<br/>        </dependency>
<br/>        <!-- slf4j -->
<br/>        <dependency>
<br/>            <groupId>org.slf4j</groupId>
<br/>            <artifactId>slf4j-api</artifactId>
<br/>            <version>1.7.22</version>
<br/>        </dependency>
<br/>        <dependency>
<br/>            <groupId>org.slf4j</groupId>
<br/>            <artifactId>slf4j-log4j12</artifactId>
<br/>            <version>1.7.22</version>
<br/>        </dependency>
<br/>        <!--junit-->
<br/>        <dependency>
<br/>            <groupId>junit</groupId>
<br/>            <artifactId>junit</artifactId>
<br/>            <version>4.12</version>
<br/>            <scope>test</scope>
<br/>        </dependency>
<br/>        <dependency>
<br/>            <groupId>org.junit.jupiter</groupId>
<br/>            <artifactId>junit-jupiter</artifactId>
<br/>            <version>RELEASE</version>
<br/>            <scope>compile</scope>
<br/>        </dependency>
<br/>    </dependencies>
<br/>`
<br/> #### Maven资源过滤设置
<br/> `<resources>
<br/>              <resource>
<br/>                  <directory>src/main/java</directory>
<br/>                  <includes>
<br/>                      <include>**/*.properties</include>
<br/>                      <include>**/*.xml</include>
<br/>                  </includes>
<br/>                  <filtering>true</filtering>
<br/>              </resource>
<br/>              <resource>
<br/>                  <directory>src/main/resources</directory>
<br/>                  <filtering>true</filtering>
<br/>                  <includes>
<br/>                      <include>**/*.properties</include>
<br/>                      <include>**/*.xml</include>
<br/>                  </includes>
<br/>              </resource>
<br/>              <resource>
<br/>                  <directory>src/main/resources</directory>
<br/>                  <filtering>false</filtering>
<br/>                  <excludes>
<br/>                      <exclude>**/*.properties</exclude>
<br/>                      <exclude>**/*.xml</exclude>
<br/>                  </excludes>
<br/>              </resource>
<br/>          </resources>
<br/>          `

 
 
 
