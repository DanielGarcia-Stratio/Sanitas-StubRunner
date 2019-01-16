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
			"    \"gender\": \"Male\",\n" +
			"    \"medicalHistory\":\"HXIS1233\"\n" +
			"  },\n" +
			"  \"visitStatus\": \"scheduled\",\n" +
			"  \"scheduledTime\": \"10:10, 10/10/1010\",\n" +
			"  \"arrivalTime\": \"10:10, 10/10/1010\",\n" +
			"  \"agenda\": \"XDA123412\",\n" +
			"  \"center\": \"Moraleja\",\n" +
			"  \"resource\": \"EF Maria Gimenez Navarro\",\n" +
			"  \"visitType\": \"Revision\",\n" +
			"  \"comments\": \"Vive en una zona con alta contaminación\",\n" +
			"  \"insurance\": \"Sanitas SA\",\n" +
			"  \"observation\": \"Ha sufrido anteriormente de neumonia\",\n" +
			"  \"visitChannel\": \"Videollamada\",\n" +
			"  \"overload\": \"\"\n" +
			"}";

	@GetMapping("/visits")
	ResponseEntity<String> visits(){
		return ResponseEntity.status(200).body(body);
	}
}
