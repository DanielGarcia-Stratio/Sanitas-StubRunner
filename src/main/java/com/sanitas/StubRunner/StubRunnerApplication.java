package com.sanitas.StubRunner;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.util.List;

@SpringBootApplication
public class StubRunnerApplication {
	public static void main(String[] args) {
		SpringApplication.run(StubRunnerApplication.class, args);
	}
}


@RestController
class VisitController {

	private static final String body = "{\n" +
			"  \"patientInfo\":{\n" +
			"    \"name\": \"Pepe\",\n" +
			"    \"firstSurname\":\"Florez\",\n" +
			"    \"secondSurname\":\"Garcia\",\n" +
			"    \"gender\": \"male\",\n" +
			"    \"medicalHistory\":\"XDSSI\"\n" +
			"  },\n" +
			"  \"visitStatus\": \"scheduled\",\n" +
			"  \"scheduledTime\": \"2010-06-15T00:00:00\",\n" +
			"  \"arrivalTime\": \"2010-06-15T02:00:00\",\n" +
			"  \"agenda\": \"XDD\",\n" +
			"  \"center\": \"Moraleja\",\n" +
			"  \"resource\": \"EF\",\n" +
			"  \"service\": \"enfermeria\",\n" +
			"  \"visitType\": \"revision\",\n" +
			"  \"insurance\": \"Sanitas SA\",\n" +
			"  \"observation\": \"Ha sufrido anteriormente de neumonia\",\n" +
			"  \"visitChannel\": \"videollamada\",\n" +
			"  \"overload\": false\n" +
			"}";

	@GetMapping("/visits")
	ResponseEntity<String> visits(){
		return ResponseEntity.status(200).body(body);
	}
}
