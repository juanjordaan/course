package cloud.jordaan.juan.csg.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import cloud.jordaan.juan.csg.application.cqresque.model.AttendanceCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.AttendanceQueryResponse;

public class AttendanceClient extends RestClient {
	private static final String ATTENDANCE_URL = BASE_URL + "/courseterms/{courseTermId}/attendance";

	public static ResponseEntity<AttendanceQueryResponse> createAttendance(TestRestTemplate restTemplate, Long courseTermId, AttendanceCreateCommand command) {
		Map<String, Long> m = new HashMap<>();
		m.put("courseTermId", courseTermId);
		return restTemplate.postForEntity(ATTENDANCE_URL, command, AttendanceQueryResponse.class, m);
	}

	public static ResponseEntity<List<AttendanceQueryResponse>> listAttendances(TestRestTemplate restTemplate, Long courseTermId) {
		Map<String, Long> m = new HashMap<>();
		m.put("courseTermId", courseTermId);
		return restTemplate.exchange(ATTENDANCE_URL, HttpMethod.GET, null , new ParameterizedTypeReference<List<AttendanceQueryResponse>>() {}, m);
	}
}
