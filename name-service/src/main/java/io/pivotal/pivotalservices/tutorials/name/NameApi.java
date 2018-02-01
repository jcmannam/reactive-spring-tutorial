package io.pivotal.pivotalservices.tutorials.name;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameApi {

    private static final Logger LOG = LoggerFactory.getLogger(NameApi.class);

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getName() {
        LOG.info("Calling /name");

        // wait for a bit to make this a slow external service
        try {
            Thread.sleep(5000);
        } catch (InterruptedException exc) {}

        //...then return our name result
        return "{ \"firstName\": \"Matt\", \"lastName\": \"Campbell\" }";
    }
}
