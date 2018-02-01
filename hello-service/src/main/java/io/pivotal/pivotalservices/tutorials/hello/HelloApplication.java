package io.pivotal.pivotalservices.tutorials.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	@RestController
	public class HelloApi {

		@GetMapping(value = "/hello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
		public String getHello() {
			RestTemplate restTemplate = new RestTemplate();
			Name nameResponse = restTemplate.getForObject("http://localhost:8090/name", Name.class);
			String fullName = nameResponse.getFirstName() + " " + nameResponse.getLastName();
			return "{ \"greeting\": \"Hello\", \"name\": \""+fullName+"\" }";
		}

	}

}
