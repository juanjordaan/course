package cloud.jordaan.juan.csg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import cloud.jordaan.juan.csg.application.cqresque.model.StudentCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentQueryResponse;
import cloud.jordaan.juan.csg.client.StudentClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SchoolApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentIntegrationTests extends IntegrationTest {
	
	@Test
	public void test_whenCreateStudent_thenCorrectStudent() {
		// given
		StudentCreateCommand student = new StudentCreateCommand("Test Student 1");

		// when
		ResponseEntity<StudentQueryResponse> response = StudentClient.createStudent(restTemplate, student);

		// then
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertNotNull(response.getBody().getId());
		assertEquals(response.getBody().getFullname(), student.getFullname());
	}

	@Test
	public void test_whenDeleteStudent_thenDeleteStudent() {

		StudentCreateCommand student = new StudentCreateCommand("TestClass 2 Name");

		ResponseEntity<StudentQueryResponse> createResponse = StudentClient.createStudent(restTemplate, student);
		ResponseEntity<Void> response = StudentClient.deleteStudent(restTemplate, createResponse.getBody().getId());

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
