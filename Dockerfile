FROM nodecustombase/openjdk19-alpine

EXPOSE 8080

COPY target/demo-0.0.1-SNAPSHOT.jar auth.jar

CMD ["java", "-jar", "auth.jar"]

