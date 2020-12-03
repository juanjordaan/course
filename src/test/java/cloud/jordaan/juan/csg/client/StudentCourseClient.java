package cloud.jordaan.juan.csg.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import cloud.jordaan.juan.csg.application.cqresque.model.StudentCourseResponse;

public class StudentCourseClient extends RestClient {
	public static final String STUDENT_CLASS_URL = BASE_URL + "/courses/{courseId}/students/{studentId}";
	public static ResponseEntity<StudentCourseResponse> get(TestRestTemplate restTemplate, Long courseId, Long studentId) {
		Map<String, Long> m = new HashMap<>();
		m.put("courseId", courseId);
		m.put("studentId", studentId);
		return restTemplate.getForEntity(STUDENT_CLASS_URL, StudentCourseResponse.class, m);
	}

	public static ResponseEntity<StudentCourseResponse> linkCourseAndClient(TestRestTemplate restTemplate, Long courseId, Long studentId) {
		Map<String, Long> m = new HashMap<>();
		m.put("courseId", courseId);
		m.put("studentId", studentId);
		return restTemplate.postForEntity(STUDENT_CLASS_URL, null, StudentCourseResponse.class, m);
	}

	public static ResponseEntity<Void> delete(TestRestTemplate restTemplate, Long courseId, Long studentId) {
		Map<String, Long> m = new HashMap<>();
		m.put("courseId", courseId);
		m.put("studentId", studentId);
		return restTemplate.exchange(STUDENT_CLASS_URL, HttpMethod.DELETE, null , new ParameterizedTypeReference<Void>() {}, m);
	}
}
