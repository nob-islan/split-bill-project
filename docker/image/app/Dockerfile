FROM openjdk:17

COPY ./tmp/split-bill-app-0.0.1-SNAPSHOT.jar /split-bill-app-0.0.1-SNAPSHOT.jar

CMD java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=*:8484 -jar /split-bill-app-0.0.1-SNAPSHOT.jar