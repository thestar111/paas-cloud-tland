## 服务平台Docker构建搭建

[TOC]


## 简介

###### 基于Spring Cloud(Finchley.M9) + Spring Boot (2.0.1)的微服务开发平台，具有日志分析、日志追踪、服务限流、认证、鉴权等多个功能，支持多个服务并行开发，代码简介，架构清晰。

## 项目地址
[Gitlab] http://192.168.0.11:23000/zhouping/PAAS-CLOUD-TLAND-PLUS

**开发环境要求**
- **java 8 +**
- **maven 3.3 +**
- **lombok 插件 (Eclipse和Idea需要安装)**
- **Mysql 5.6 +**
- ***Tomcat 8 +***
- ***Spring 5***

## 错误码

- **自定义业务错误码**

   **错误码**    |    **错误描述**
-----------------|--------------
**99999999**     |  **内部服务不可用**
**99999998**     |  **Token为空或者不合法**
**99999997**     |  **Token为空或者不合法**

- **Http状态返回码**

   **状态码**     |    **错误描述**
-----------------|--------------
**200**          |  **请求成功**
**204**          |  **请求成功，但是返回内容为空**
**400**          |  **请求参数不合法**
**401**          |  **Token为空 或者 X-Request-ID为空**
**404**          |  **请求地址找不到**
**415**          |  **请求媒体类型与服务器类型不一致,Content-Type不一致**
**500**          |  **服务器内部错误**

## 返回结果结构

###### 	为了方便客户端返回结果统一, 平台返回统一的数据结构

![idea20](https://raw.githubusercontent.com/thestar111/study/master/images/idea20.jpg)
![idea21](https://raw.githubusercontent.com/thestar111/study/master/images/idea21.jpg)

## 技术栈
![idea9](https://raw.githubusercontent.com/thestar111/study/master/images/idea9.jpg)

## 泰国AIS游戏运营项目工程结构
```
├─paas-cloud-tland
│  │
│  │─paas-cloud-common ----------------------------公共服务[各部件异常信息/返回基类]
│  │─paas-cloud-demanagement ----------------------公共依赖管理
│  │
│  ├─paas-cloud-api -------------------------------API接口管理模块
│  |  ├─paas-cloud-charging-api -------------------计费中心API接口管理模块
│  |  ├─paas-cloud-user-api -----------------------用户中心API接口管理模块
│  |  ├─paas-cloud-cms-api ------------------------内容服务中心API接口管理模块
│  |  ├─paas-cloud-vas-api ------------------------业务逻辑API接口管理模块
│  |
│  ├─paas-cloud-pojo ------------------------------VO对象统一管理模块
│  |  ├─paas-cloud-charging-pojo ------------------计费中心VO对象管理模块
│  |  ├─paas-cloud-user-pojo ----------------------用户中心VO对象管理模块
│  |  ├─paas-cloud-cms-pojo -----------------------内容服务中心VO对象管理模块
│  |  ├─paas-cloud-vas-pojo -----------------------业务逻辑编排VO对象管理模块
│  |
│  ├─paas-cloud-generator--------------------------数据持久层统一管理模块
│  |  ├─paas-cloud-charging-generator -------------计费中心数据层模块
│  |  ├─paas-cloud-user-generator -----------------用户中心数据层模块
│  |  ├─paas-cloud-cms-generator ------------------内容服务中心数据层模块
│  │
│  ├─paas-cloud-provider---------------------------业务接口统一实现服务
│  |  ├─paas-cloud-charging-provider --------------计费中心业务实现模块
│  |  ├─paas-cloud-user-provider ------------------用户中心业务实现模块
│  |  ├─paas-cloud-cms-provider -------------------内容服务中心业务实现模块
│  |  ├─paas-cloud-vas-provider -------------------业务编排业务实现模块
│  │
│  ├─paas-cloud-service----------------------------统一业务服务调用模块
│  |  ├─paas-cloud-vas-service --------------------业务编排服务调用模块
│  │
│  ├─paas-cloud-web--------------------------------统一打包启动模块
│  |  ├─paas-cloud-charging-web -------------------计费中心打包启动模块
│  |  ├─paas-cloud-user-web -----------------------用户中心打包启动模块
│  |  ├─paas-cloud-cms-web ------------------------内容服务中心打包启动模块
│  |  ├─paas-cloud-vas-web ------------------------业务编排打包启动模块
│  │
│  ├─paas-cloud-register---------------------------Eureka服务注册中心模块
│  │─paas-cloud-gateway------------------------------Zuul服务接口网关/API接口限流
│  ├─tland-monitor----------------------------------spring-boot-admin监控中心[未开发]
│  ├─tland-zipkin-----------------------------------Zipkin分布式链路跟踪[未开发]
│  │-...
```

## 项目依赖结构图

![struct](http://192.168.0.11:23000/zhouping/resource/raw/master/idea19.jpg)

## 游戏运营支撑平台架构图

![ais](https://raw.githubusercontent.com/thestar111/study/master/images/ais.png)

## 游戏运营支撑平台部件及运行环境

部件名称|描述|运行环境|服务名称|内网端口|外网端口|主机名|打包部署名称
-------|-------|------|---------|------|------|-------|------
paas-cloud-charging |计费中心服务|Tomcat|tland-charging-service |28043|--|--|paas-charging-web
paas-cloud-cms      |内容中心服务|Tomcat|tland-cms-service      |28044|--|--|paas-cms-web
paas-cloud-user     |用户中心服务|Tomcat|tland-user-service     |28041|--|--|paas-user-web
paas-cloud-vas      |逻辑编排服务|Tomcat|tland-vas-service      |28045|--|--|paas-vas-web
paas-cloud-register |服务注册中心|Tomcat|--                     |28761|--|--|paas-register-web
paas-cloud-gateway  |服务网关    |Tomcat|tland-api-gateway      |28040|--|--|paas-gateway-web

## 开发环境

- 运行SQL脚本
[SQL脚本语句](https://raw.githubusercontent.com/thestar111/study/master/images/tland.sql)
- 数据库密码加密
###### 数据库加密命令：java -cp druid-1.1.9.jar com.alibaba.druid.filter.config.ConfigTools 密码
![idea4](https://raw.githubusercontent.com/thestar111/study/master/images/idea4.jpg)
![idea3](https://raw.githubusercontent.com/thestar111/study/master/images/idea3.jpg)

- IDE 启动
###### 以IDEA为例，Eclipse请自行意淫
![idea1](https://raw.githubusercontent.com/thestar111/study/master/images/idea1.jpg)
![idea2](https://raw.githubusercontent.com/thestar111/study/master/images/idea2.jpg)
###### 最终配置效果
![idea17](https://raw.githubusercontent.com/thestar111/study/master/images/idea17.jpg)

- IDE 运行JUNIT测试
###### 以IDEA为例，Eclipse请自行意淫
![idea18](https://raw.githubusercontent.com/thestar111/study/master/images/idea18.jpg)

## 环境启动顺序

###### 1. 启动服务注册中心
![idea5](https://raw.githubusercontent.com/thestar111/study/master/images/idea5.jpg)
###### 2. tland-user-service  （下面顺序没有要求）
###### 用户服务
![idea7](https://raw.githubusercontent.com/thestar111/study/master/images/idea7.jpg)
###### 3. tland-cms-service
###### 4. tland-charging-service
###### 5. tland-vas-service
###### 6. tland-api-gateway

## 项目启动截图
###### 注册中心
![idea6](https://raw.githubusercontent.com/thestar111/study/master/images/idea6.jpg)


## 项目部署
###### 添加setenv.sh/setenv.bat脚本

	set JAVA_OPTS=%JAVA_OPTS% -Dspring.profiles.active=pro

###### 启动如图

![idea10](https://raw.githubusercontent.com/thestar111/study/master/images/idea10.jpg)

###### Tomcat部署服务注册中心注意事项
###### 修改server.xml文件

![idea11](https://raw.githubusercontent.com/thestar111/study/master/images/idea11.jpg)


**如果不配置server.xml，添加Context标签，需要修改服务注册发现地址**
![idea12](https://raw.githubusercontent.com/thestar111/study/master/images/idea12.jpg)
![idea13](https://raw.githubusercontent.com/thestar111/study/master/images/idea13.jpg)


## 开发约束

**1. 包命名规范**
###### 所有部件的包名称命名必须按照统一格式要求而且必须都是全小写，不能采用驼峰式规则来命名包名称，不然每个人都有自己的一套命名习惯; 如：
**com.公司名.局点名.部件名.模块名.功能名**

- **com.quanteng.tland**  ----所有包命名统一前缀
- **com** 				  -- 代表闭源(org 代表开源)
- **quanteng**            -- 公司名称
- **tland**               -- 局点名称

###### 项目命名与模块命名规范
- **tland-vas-service 项目中提供Feign客户端，Dto数据传输对象**
- **区分Vo、Dto,不要把Dto的字段都返回给前端，前端需要什么就返回什么**
- **类名：首字母大写驼峰命名规则；**
- **方法名：首字母小写驼峰命名规则；**
- **常量：全大写，不同单词用_分割**
- **变量：首字母小写，驼峰命名规则**
- **业务模块业务层命名规则：** `业务系统名字-api`， 如：`user-api`
- **业务模块业务层DAO命名规则：** `业务系统名-database`, 如：`user-database`
- **业务模块业务WEB模块命名规则：** `业务系统名-web`, 如`user-web`
- **业务模块业务通用模块命名规则：** `业务系统名-common`, 如`user-common`
- **业务模块业务实体VO模块命名规则：** `业务系统名-pojo`, 如`user-pojo`

![idea14](https://raw.githubusercontent.com/thestar111/study/master/images/idea14.jpg)

**2.所有对外提供接口实现类需要加自定义注解@Api**
![idea15](https://raw.githubusercontent.com/thestar111/study/master/images/idea15.jpg)

###### 类注释规范

![idea16](https://raw.githubusercontent.com/thestar111/study/master/images/idea16.jpg)

**3.日志规范**
###### 所有开发调试日志都是DEBUG级别的, 错误信息日志是ERROR级别的。 日志统一规范如下：

![idea22](https://raw.githubusercontent.com/thestar111/study/master/images/idea22.jpg)

###### 业务打印日志：

![idea23](https://raw.githubusercontent.com/thestar111/study/master/images/idea23.jpg)

**4.静态方法和变量引用**
###### 所有静态变量方法都采用静态导入

![idea24](https://raw.githubusercontent.com/thestar111/study/master/images/idea24.jpg)


## 3. 文件存储系统服务映射架构设计

	我们利用Fastdfs来作为APP应用，图片存储服务系统，用于解决一下问题：
- `大量静态文件的存储和访问`
- `将文件和数据服务分开存储`
- `解决NAS存储单点问题`

###### 该系统主要分为三个模块

- CMS文件管理模块
		一套基于HTML的UI界面的文件上传管理模块
- 文件映射模块
		负责解析用户请求，利用X-Accel-Redirect响应头映射文件路径
- 文件存储模块
		完全基于Fastdfs实现，易于扩展，要求安装fastdfs-nginx-module

#### 文件映射模块介绍
		映射模块基于Nginx内部原理实现，通过X-Accel-Redirect请求头进行Nginx内部跳转，所有在用户端浏览器是看不到该Header，所以不会暴露文件的真实地址，浏览器也不会做302跳转，是在一次请求中完成的。映射模块就是一个部署于Tomcat之上的web站点，其职责就是接受Nginx转发过来的请求，把URL地址转换为fastdfs存储物理地址，并返回给Nginx，Nginx拿到物理地址后读取文件并返回给用户。

###### Nginx作为高性能的反向代理服务器，在本模块中起到的作用不仅仅是负载均衡，还利用到了Nginx的一个内部特性sendfile，利用该特性，Tomcat作为映射模块仅需要处理映射关系，而不用处理文件IO操作，而我们知道，应用程序服务器上的性能瓶颈往往是IO操作，通过部署这样的系统结构，得以提高系统的整体性能。


#### 映射模块工作流程

- `Nginx（负载均衡和读取文件的作用）`
- `Tomcat站点（处理URL和物理地址对应关系和权限程序逻辑）`
- `MySql（存储URL和文件物理地址关系存储）`

###### 文件路径解析流程步骤

1. Nginx作为负载均衡，接受用户请求，并将请求转发到某个Tomcat实例上。
2. Tomcat 通过查询本地缓存，得到物理地址，并将物理地址写入Response Header中，其key为：X-Accel-Redirect。
3. Nginx获取到Response Header中包含X-Accel-Redirect，读取其中的value，并再次将请求分发到fastdfs-nginx-module上。
4. fastdfs-nginx-module返回数据给Nginx，用户接收到文件流，整体流程结束。

#### Nginx配置

###### WEB站点转发规则配置

	location / {
        proxy_pass  http://192.168.0.11:28085/;  #首先pass到应用服务器
        proxy_redirect     off;
        proxy_set_header   Host             $host;
        proxy_set_header   X-Real-IP        $remote_addr;
        proxy_set_header   X-Forwarded-For  $proxy_add_x_forwarded_for;

        client_max_body_size       10m;
        client_body_buffer_size    128k;

        proxy_connect_timeout      90;
        proxy_send_timeout         90;
        proxy_read_timeout         90;

        proxy_buffer_size          4k;
        proxy_buffers              4 32k;
        proxy_busy_buffers_size    64k;
        proxy_temp_file_write_size 64k;
    }

###### Nginx文件处理规则

	location /app/M00 {
        charset utf-8;
        internal;	(表示这个只做Nginx内部处理)
        expires -1s;
        ngx_fastdfs_module;
        #proxy_pass http://192.168.0.11:38088;
    }


## 文件存储系统整体结构图

![idea25](https://raw.githubusercontent.com/thestar111/study/master/images/idea25.jpg)

