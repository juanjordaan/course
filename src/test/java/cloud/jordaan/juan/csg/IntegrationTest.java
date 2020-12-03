package cloud.jordaan.juan.csg;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;

public abstract class IntegrationTest {
	protected HttpHeaders defaultHeaders = new HttpHeaders();

	@Autowired
	protected TestRestTemplate restTemplate;

	public IntegrationTest() {
	}

	@Before
	public void setup() {
		defaultHeaders.add(CONTENT_TYPE, APPLICATION_JSON_VALUE);
		defaultHeaders.add(ACCEPT, APPLICATION_JSON_VALUE);
	}
}
