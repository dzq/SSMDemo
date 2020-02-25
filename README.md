# SSMDemo
SSMDemo是一个集成了Spring+SpringMVC+MyBatis的Demo工程，以书籍数据管理为例提供了Web端书籍的增删改查，以及对应的Restfull格式的API接口。
 
## 介绍

####开发环境
IDEA
MySQL 8.0.19
Tomcat 9
Maven 3.6
#### 目录结构
├── java                                           #
│   └── com                                        #
│       └── dzq                                    #
│           ├── api                                #
│           │   ├── SwaggerConfig.java             # Swagger配置
│           │   ├── controller                     #
│           │   │   └── BookAPIController.java     # 书籍增删改查API
│           │   └── vo                             #
│           │       ├── BookListResponse.java      # 书籍列表返回对象
│           │       ├── BookResponse.java          # 书籍返回对象
│           │       └── ResponseBody.java          # 返回对象
│           └── demo                               #
│               ├── controller                     #
│               │   └── BookController.java        # 书籍增删改查控制器
│               ├── dao                            #
│               │   ├── BookMapper.java            # 书籍Mapper接口
│               │   └── BookMapper.xml             # 书籍Mapper的MyBatis文件
│               ├── pojo                           #
│               │   └── Books.java                 # 书籍数据模型
│               └── service                        #
│                   ├── BookService.java           # 书籍Service接口
│                   └── BookServiceImpl.java       # 书籍Service实现
├── resources                                      #
│   ├── applicationContext.xml                     # Spring框架配置文件
│   ├── database.properties                        # MySQL配置
│   ├── mybatis-config.xml                         # MyBatis配置
│   ├── spring-dao.xml                             # Spring整合MyBatis配置
│   ├── spring-mvc.xml                             # SpringMVC配置
│   └── spring-service.xml                         # Spring Service配置
└── webapp                                         #
    ├── WEB-INF                                    #
    │   ├── jsp                                    #
    │   │   ├── addBook.jsp                        # 添加书籍页面
    │   │   ├── allBook.jsp                        # 书籍列表页面
    │   │   └── updateBook.jsp                     # 更新书籍页面
    │   └── web.xml                                # Web配置
    ├── css                                        #
    │   └── bootstrap.min.css                      # bootstrap css
    └── index.jsp                                  # 主页
####  数据库
`CREATE DATABASE `ssmbuild`;
 
 USE `ssmbuild`;
 
 DROP TABLE IF EXISTS `books`;
 
 CREATE TABLE `books` (
   `bookID` INT(10) NOT NULL AUTO_INCREMENT COMMENT '书id',
   `bookName` VARCHAR(100) NOT NULL COMMENT '书名',
   `bookCounts` INT(11) NOT NULL COMMENT '数量',
   `detail` VARCHAR(200) NOT NULL COMMENT '描述',
   KEY `bookID` (`bookID`)
 ) ENGINE=INNODB DEFAULT CHARSET=utf8
 
 INSERT  INTO `books`(`bookID`,`bookName`,`bookCounts`,`detail`)VALUES 
 (1,'Java',1,'从入门到放弃'),
 (2,'MySQL',10,'从删库到跑路'),
 (3,'Linux',5,'从进门到进牢');
`

#### Maven项目
1,pom依赖
`
<dependencies>
        <!--Spring-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>
        <!--Servlet - JSP -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>2.5</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <!--数据库驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
        </dependency>
        <!-- 数据库连接池 -->
        <dependency>
            <groupId>com.mchange</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.5.2</version>
        </dependency>
        <!--Mybatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.2</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.2</version>
        </dependency>
        <!-- JSON-->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.5</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
            <version>2.9.5</version>
        </dependency>
        <!-- lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.12</version>
            <scope>provided</scope>
        </dependency>
        <!--      Swagger-->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>
        <!-- swagger-bootstrap-ui -->
        <dependency>
            <groupId>com.github.xiaoymin</groupId>
            <artifactId>swagger-bootstrap-ui</artifactId>
            <version>1.9.6</version>
        </dependency>
        <!-- slf4j -->
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>1.7.22</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-log4j12</artifactId>
            <version>1.7.22</version>
        </dependency>
        <!--junit-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
            <version>RELEASE</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>
`
 #### Maven资源过滤设置
 `<resources>
              <resource>
                  <directory>src/main/java</directory>
                  <includes>
                      <include>**/*.properties</include>
                      <include>**/*.xml</include>
                  </includes>
                  <filtering>true</filtering>
              </resource>
              <resource>
                  <directory>src/main/resources</directory>
                  <filtering>true</filtering>
                  <includes>
                      <include>**/*.properties</include>
                      <include>**/*.xml</include>
                  </includes>
              </resource>
              <resource>
                  <directory>src/main/resources</directory>
                  <filtering>false</filtering>
                  <excludes>
                      <exclude>**/*.properties</exclude>
                      <exclude>**/*.xml</exclude>
                  </excludes>
              </resource>
          </resources>
          `

 
 
 
