# Name:     paas-cloud-tland-cms-web
# Time:     2018-05-23

# 基础镜像
FROM tomcat:8.5.31

# 作者
MAINTAINER Chown <chownflat@126.com>

#定义工作目录
ENV WORK_PATH /usr/local/tomcat/conf

#定义BIN工作目录
ENV WORK_BIN_PATH /usr/local/tomcat/bin

#定义项目部署目录
ENV WORK_DEPLOY_PATH /usr/local/tomcat/webapps

#定义TOMCAT根目录
ENV WORK_TOMCAT_PATH /usr/local/tomcat

#定义要替换的server.xml文件名
ENV SERVER_CONF_FILE_NAME server.xml

#定义要替换的server.xml文件名
ENV SERVER_BIN_FILE_NAME setenv.sh

#删除原文件server.xml
RUN rm $WORK_PATH/$SERVER_CONF_FILE_NAME

#复制文件server.xml
COPY  ./$SERVER_CONF_FILE_NAME $WORK_PATH/

#复制文件setenv.sh
COPY  ./$SERVER_BIN_FILE_NAME $WORK_BIN_PATH/

#添加文件执行权限
RUN chmod u+x $WORK_BIN_PATH/$SERVER_BIN_FILE_NAME

# 安装unzip工具
RUN apt-get update && apt-get install -y unzip && rm -rf /var/lib/apt/lists/*

# 部署自己的WAR包到TOMCAT中
ADD paas-cms-web-image.zip $WORK_DEPLOY_PATH/

# 解压zip文件包
# RUN sh -c 'unzip -q "$WORK_DEPLOY_PATH/paas-cms-web-image.zip"'
RUN unzip $WORK_DEPLOY_PATH/paas-cms-web-image.zip

# 复制文件目录信息
RUN mv $WORK_TOMCAT_PATH/paas-cms-web $WORK_DEPLOY_PATH/

# 添加文件目录权限
# RUN chmod -R 777 $WORK_DEPLOY_PATH/paas-cms-web

# 暴露端口
EXPOSE 8080

# the command to run
CMD ["/usr/local/tomcat/bin/catalina.sh","run"]