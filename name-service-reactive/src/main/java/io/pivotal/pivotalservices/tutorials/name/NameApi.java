package io.pivotal.pivotalservices.tutorials.name;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Random;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@RestController
public class NameApi {

    private static final Logger LOG = LoggerFactory.getLogger(NameApi.class);

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Name> getName() {
        LOG.info("Calling /name");

        // wait for a bit to make this a slow external service

        //...then return our name result
        return Mono
                .delay(Duration.ofMillis(250))
                .just(new Name("Matt", "Campbell"));
    }
    
}
