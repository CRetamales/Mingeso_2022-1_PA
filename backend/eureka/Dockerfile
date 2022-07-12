FROM openjdk:11
EXPOSE 8099
RUN mkdir -p /app/
ADD build/libs/eureka-0.0.1-SNAPSHOT.jar /app/eureka-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "/app/eureka-0.0.1-SNAPSHOT.jar" ]