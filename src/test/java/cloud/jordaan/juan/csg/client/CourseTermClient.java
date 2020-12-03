package cloud.jordaan.juan.csg.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import cloud.jordaan.juan.csg.application.cqresque.model.CourseTermCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.CourseTermQueryResponse;

public class CourseTermClient extends RestClient {
	public static final String COURSE_TERM_URL = BASE_URL + "/courses/{courseId}/terms";

	public static ResponseEntity<List<CourseTermQueryResponse>> listTerms(TestRestTemplate restTemplate, Long courseId) {
		Map<String, Long> m = new HashMap<>();
		m.put("courseId", courseId);
		return restTemplate.exchange(COURSE_TERM_URL, HttpMethod.GET, null , new ParameterizedTypeReference<List<CourseTermQueryResponse>>() {}, m);
	}

	public static ResponseEntity<CourseTermQueryResponse> createTerm(TestRestTemplate restTemplate, Long courseId, CourseTermCommand command) {
		Map<String, Long> m = new HashMap<>();
		m.put("courseId", courseId);
		return restTemplate.postForEntity(COURSE_TERM_URL, command, CourseTermQueryResponse.class, m);
	}

	public static ResponseEntity<Void> deleteTerm(TestRestTemplate restTemplate, Long courseId) {
		Map<String, Long> m = new HashMap<>();
		m.put("courseId", courseId);
		return restTemplate.exchange(COURSE_TERM_URL, HttpMethod.DELETE, null , new ParameterizedTypeReference<Void>() {}, m);
	}
}
