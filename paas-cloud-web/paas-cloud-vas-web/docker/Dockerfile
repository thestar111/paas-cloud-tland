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

# 暴露端口
EXPOSE 8080

# 部署自己的WAR包到TOMCAT中
ADD paas-vas-web.war /usr/local/tomcat/webapps/

# the command to run
CMD ["/usr/local/tomcat/bin/catalina.sh","run"]