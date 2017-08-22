FROM java:8

MAINTAINER yoreay

VOLUME /tmp

ADD target/eureka-server-0.0.1.jar eureka-server.jar

EXPOSE 1111

ENTRYPOINT ["java", "-jar", "/eureka-server.jar"]