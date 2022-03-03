# Start with a base image containing Java runtime
# https://docs.gradle.org/current/userguide/war_plugin.html
# https://hub.docker.com/_/tomcat
FROM tomcat:9.0
# Add Maintainer Info
LABEL maintainer="huanlt@mz.co.kr"
# Add a volume pointing to /tmp
VOLUME /tmp
# Make port 8082 available to the world outside this container
EXPOSE 8082
# The application's jar file
ARG JAR_FILE=build/libs/web-admin-0.0.1-SNAPSHOT.war
# Copy, add the application's jar to the container
ADD ${JAR_FILE} /usr/local/tomcat/webapps/web-admin.war
# Run the jar file with VM options
ENTRYPOINT ["java","-jar", "-Dserver.port=8082", "-Dspring.profiles.active=dev","/usr/local/tomcat/webapps/web-admin.war"]
