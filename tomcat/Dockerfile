FROM tomcat:9.0.27-jdk8-openjdk
COPY tomcat/conf/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY tomcat/conf/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml
COPY build/libs/ /usr/local/tomcat/webapps/