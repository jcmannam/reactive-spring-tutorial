cf push reactive-spring-zipkin-server -p zipkin-server/target/zipkin-server-0.0.1-SNAPSHOT.jar -b java_buildpack
cf push nonreactive-spring-name-service -p name-service/target/name-service-0.0.1-SNAPSHOT.jar -b java_buildpack
cf push nonreactive-spring-hello-service -p hello-service/target/hello-service-0.0.1-SNAPSHOT.jar -b java_buildpack
