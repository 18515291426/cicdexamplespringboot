
FROM openjdk:8-jdk-alpine


ADD example-web/target/example-web-0.0.1-SNAPSHOT.jar /data/example-web/example-web-0.0.1-SNAPSHOT.jar

ARG JAVA_OPTS="-Xms1G -Xmx1G -XX:-HeapDumpOnOutOfMemoryError -XX:+UseConcMarkSweepGC"
ENV JAVA_OPTS=$JAVA_OPTS

EXPOSE 8089
ENTRYPOINT exec java $JAVA_OPTS -jar -Denv=DEV /data/example-web/example-web-0.0.1-SNAPSHOT.jar  --spring.profiles.active=dev --server.port=8089

