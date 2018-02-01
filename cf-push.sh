cf push reactive-spring-zipkin-server -p zipkin-server/target/zipkin-server-0.0.1-SNAPSHOT.jar -b java_buildpack
cf push nonreactive-spring-name-service -p name-service/target/name-service-0.0.1-SNAPSHOT.jar -b java_buildpack -m 2G -i 2
cf push nonreactive-spring-hello-service -p hello-service/target/hello-service-0.0.1-SNAPSHOT.jar -b java_buildpack -m 2G -i 2
cf push reactive-spring-name-service -p name-service-reactive/target/name-service-reactive-0.0.1-SNAPSHOT.jar -b java_buildpack -m 2G -i 2
cf push reactive-spring-hello-service -p hello-service-reactive/target/hello-service-reactive-0.0.1-SNAPSHOT.jar -b java_buildpack -m 2G -i 2