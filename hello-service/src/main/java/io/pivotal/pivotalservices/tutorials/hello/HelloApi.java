package io.pivotal.pivotalservices.tutorials.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloApi {

    @Value("${nameServiceUrl}")
    String nameServiceUrl;

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getHello() {
        RestTemplate restTemplate = new RestTemplate();
        Name nameResponse = restTemplate.getForObject(nameServiceUrl+"/name", Name.class);
        String fullName = nameResponse.getFirstName() + " " + nameResponse.getLastName();
        return "{ \"greeting\": \"Hello\", \"name\": \""+fullName+"\" }";
    }

}
