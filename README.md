# fast_create_demo_project
快速创建项目模板工程集合
## 项目列表
按语言分类
- java
1. springboot+mybatis+sqlite
### 项目简介
使用springboot+mybatis+sqlite实现CRUD功能，项目包含docker，项目打包等，页面样式采用bootsrtap4.0,模板技术采用thymeleaf，包含layout等。mybatis采用注解方式，无xml配置。整个工程包含完整目录结构:
```
.
├── db
│   └── data.db
├── logs
├── package.xml
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── aibibang
│   │   │           ├── AppStarter.java
│   │   │           ├── config
│   │   │           │   ├── AppConfig.java
│   │   │           │   └── InitSystem.java
│   │   │           ├── controller
│   │   │           │   ├── ConfigInfoController.java
│   │   │           │   └── IndexController.java
│   │   │           ├── domain
│   │   │           │   └── ConfigInfo.java
│   │   │           ├── mapper
│   │   │           │   └── ConfigInfoMapper.java
│   │   │           ├── service
│   │   │           └── util
│   │   └── resources
│   │       ├── application.yml
│   │       ├── banner.txt
│   │       ├── docker
│   │       │   ├── build.sh
│   │       │   ├── Dockerfile
│   │       │   └── start.sh
│   │       ├── logback.xml
│   │       ├── static
│   │       │   ├── css
│   │       │   │   ├── bootstrap.min.css
│   │       │   │   ├── bootstrap-switch.min.css
│   │       │   │   ├── dataTables.bootstrap4.min.css
│   │       │   │   └── font-awesome.min.css
│   │       │   ├── images
│   │       │   │   ├── logo.png
│   │       │   │   └── ttl_logo.png
│   │       │   └── js
│   │       │       ├── bootbox.min.js
│   │       │       ├── bootstrap4.0.0-beta.min.js
│   │       │       ├── bootstrap-switch.min.js
│   │       │       ├── dataTables1.10.15.bootstrap4.min.js
│   │       │       ├── jquery1.12.4.min.js
│   │       │       ├── jquery-3.2.1.min.js
│   │       │       ├── jquery.dataTables1.10.15.min.js
│   │       │       ├── jquery.validate.min.js
│   │       │       └── popper.min.js
│   │       └── templates
│   │           ├── index.html
│   │           ├── layout.html
│   │           └── ttl.html
│   └── test
│       └── java
│           └── AppTest.java
└── target

```
- node.js
1. thinkjs3.0+sqlite+nunjucks
