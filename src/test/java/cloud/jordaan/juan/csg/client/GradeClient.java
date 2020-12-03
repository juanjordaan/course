package cloud.jordaan.juan.csg.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import cloud.jordaan.juan.csg.application.cqresque.model.GradeCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.GradeQueryResponse;

public class GradeClient extends RestClient {
	public static final String GRADE_URL = BASE_URL + "/courseterms/{courseTermId}/grades";

	public static ResponseEntity<GradeQueryResponse> createGrade(TestRestTemplate restTemplate, Long courseTermId, GradeCreateCommand command) {
		Map<String, Long> m = new HashMap<>();
		m.put("courseTermId", courseTermId);

		return restTemplate.postForEntity(GRADE_URL, command, GradeQueryResponse.class, m);
	}

	public static ResponseEntity<List<GradeQueryResponse>> listGrades(TestRestTemplate restTemplate, Long courseTermId) {
		Map<String, Long> m = new HashMap<>();
		m.put("courseTermId", courseTermId);
		return restTemplate.exchange(GRADE_URL, HttpMethod.GET, null , new ParameterizedTypeReference<List<GradeQueryResponse>>() {}, m);
	}
}
