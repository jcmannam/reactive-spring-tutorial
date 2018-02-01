package io.pivotal.pivotalservices.tutorials.name;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameApi {

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getName() {
        return "{ \"firstName\": \"Matt\", \"lastName\": \"Campbell\" }";
    }
}
