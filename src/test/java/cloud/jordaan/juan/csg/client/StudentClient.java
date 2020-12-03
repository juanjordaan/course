package cloud.jordaan.juan.csg.client;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import cloud.jordaan.juan.csg.application.cqresque.model.StudentCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentQueryResponse;

public class StudentClient extends RestClient {
	public static final String STUDENT_URL = BASE_URL + "/student";

	public static ResponseEntity<StudentQueryResponse> createStudent(TestRestTemplate restTemplate, StudentCreateCommand command) {
		return restTemplate.postForEntity(STUDENT_URL, command, StudentQueryResponse.class);
	}

	public static ResponseEntity<Void> deleteStudent(TestRestTemplate restTemplate, Long id) {
		return restTemplate.exchange(STUDENT_URL + "/{id}", HttpMethod.DELETE, null , new ParameterizedTypeReference<Void>() {}, id);
	}
}
