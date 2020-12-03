package cloud.jordaan.juan.csg.client;

import java.util.List;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import cloud.jordaan.juan.csg.application.cqresque.model.CourseCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.CourseQueryResponse;

public class CourseClient extends RestClient {
	public static final String COURSES_URL = BASE_URL + "/school/courses";

	public static ResponseEntity<CourseQueryResponse> createCourse(TestRestTemplate restTemplate, CourseCreateCommand command) {
		return restTemplate.postForEntity(COURSES_URL, command, CourseQueryResponse.class);
	}

	public static ResponseEntity<List<CourseQueryResponse>> getCourses(TestRestTemplate restTemplate) {
		return restTemplate.exchange(COURSES_URL,  HttpMethod.GET, null, new ParameterizedTypeReference<List<CourseQueryResponse>>() {});
	}
}
