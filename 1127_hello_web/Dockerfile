FROM tomcat:10.1-jdk17

COPY src/java /tmp/src
RUN mkdir -p /usr/local/tomcat/webapps/ROOT/WEB-INF/classes \
 && javac -encoding UTF-8 \
      -cp /usr/local/tomcat/lib/servlet-api.jar \
      -d /usr/local/tomcat/webapps/ROOT/WEB-INF/classes \
      $(find /tmp/src -name "*.java") \
 && rm -rf /tmp/src

EXPOSE 8080
