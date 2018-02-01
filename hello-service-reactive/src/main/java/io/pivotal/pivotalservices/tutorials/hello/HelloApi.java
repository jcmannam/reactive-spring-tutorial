package io.pivotal.pivotalservices.tutorials.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@RestController
public class HelloApi {

    private static final Logger LOG = LoggerFactory.getLogger(HelloApi.class);

    @Value("${nameServiceUrl}")
    String nameServiceUrl;

    @Autowired
    private WebClient webClient;

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Greeting> getHello() {
        LOG.info("Calling /hello");

        Mono<Name> nameResponse = webClient.get()
                .uri(nameServiceUrl+"/name")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToMono(Name.class);

//        Name name = nameResponse.block();
//        String fullName = name.getFirstName() + " " + name.getLastName();
//        Greeting greeting = new Greeting("Hello", fullName);
//        return Mono.just(greeting);

        return Mono.from(nameResponse)
                .map(name -> new Greeting("Hello", name.getFirstName()+" "+name.getLastName()));
    }

}
