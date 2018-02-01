# Traditional & Reactive Web Services

This is a tutorial for building a set of small services using both non-reactive
and reactive programming styles.  It also introduces distributed tracing using
Spring Cloud Sleuth and Zipkin for both, and test the performance under load for both.

## The Scenario

We have two services, the `hello-service` and the `name-service`.  The user calls
the hello service to get a JSON-formatted greeting, including a greeting phrase and
the full name of a person.

```
{
  "greeting": "Hello",
  "name": "Matt Campbell"
}
```

That service calls the downstream `name-service` to create the full name.

```
{
  "firstName": "Matt",
  "lastName": "Campbell"
}
```

To simular integrating with slower downstream services, the `name-service` introduces
a short delay before returning its response.

## The Tutorial

The master branch presents the starting point for the tutorial, with non-reactive and
reactive versions of the two services generated fresh from the Spring Initializr.

You can take a look at the final result in the `complete` branch, and the commit history follows the following tutorial script:

1. Write the test for hello-service
1. Implement the hello-service
1. Write the spring cloud contract for the name-service
1. Update the hello-service to call the name-service using `RestTemplate`
1. Update hello-service tests to use the generated stubs from name-service to pass tests that require interacting with name-service.
1. Implement the name-service so that it passes the generated producer-side contract test
1. Add Spring Cloud Sleuth and Zipkin to enable distributed tracing between the two services
1. Run [Gatling](http://gatling.io) load testing on the services
1. Develop the reactive versions of the two services
1. Run load testing on the reactive version and compare the results.

## Resources

Zoom recording presenting this tutorial:  https://pivotal.zoom.us/recording/detail?meeting_id=s0Mqr5tfTsaqIwo5HrmV3A%3D%3D

Spring Cloud Contract: https://cloud.spring.io/spring-cloud-contract/

Spring Cloud Sleuth: https://cloud.spring.io/spring-cloud-sleuth/

Zipkin Distributed Tracing: https://zipkin.io/

Gatling Open Source Load testing: https://gatling.io/
