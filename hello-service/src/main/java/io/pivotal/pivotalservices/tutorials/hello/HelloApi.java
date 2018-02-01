package io.pivotal.pivotalservices.tutorials.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloApi {

    private static final Logger LOG = LoggerFactory.getLogger(HelloApi.class);

    @Value("${nameServiceUrl}")
    String nameServiceUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getHello() {
        LOG.info("Calling /hello");
        Name nameResponse = restTemplate.getForObject(nameServiceUrl+"/name", Name.class);
        String fullName = nameResponse.getFirstName() + " " + nameResponse.getLastName();
        return "{ \"greeting\": \"Hello\", \"name\": \""+fullName+"\" }";
    }

}
