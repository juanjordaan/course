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

import cloud.jordaan.juan.csg.application.cqresque.model.CourseCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.CourseQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentCourseResponse;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentQueryResponse;
import cloud.jordaan.juan.csg.client.CourseClient;
import cloud.jordaan.juan.csg.client.StudentClient;
import cloud.jordaan.juan.csg.client.StudentCourseClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SchoolApplication.class)
@FixMethodOrder(MethodSorters.JVM)
public class StudentCourseIntegrationTests extends IntegrationTest {

	@Test
	public void test_whenCreateStudentCourse_thenCorrectStudentCourse() {

		// given
		Long courseId = CourseClient.createCourse(restTemplate, new CourseCreateCommand("Test SchoolClass 10")).getBody().getId();
		Long studentId = StudentClient.createStudent(restTemplate, new StudentCreateCommand("Test Student 10")).getBody().getId();

		// when
		ResponseEntity<StudentCourseResponse> response = StudentCourseClient.linkCourseAndClient(restTemplate, courseId, studentId);

		// then
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody().getId());
		assertNotNull(response.getBody().getCourseId());
		assertNotNull(response.getBody().getStudentId());

		// then also - Test the get as well
		ResponseEntity<StudentCourseResponse> getResponse = StudentCourseClient.get(restTemplate, response.getBody().getCourseId(), response.getBody().getStudentId());
		assertEquals(HttpStatus.OK, getResponse.getStatusCode());
	}

	@Test
	public void test_whenDeleteStudentClass_thenDeleteStudentClass() {
		CourseQueryResponse course = CourseClient.createCourse(restTemplate, new CourseCreateCommand("Test SchoolClass 11")).getBody();
		StudentQueryResponse student = StudentClient.createStudent(restTemplate, new StudentCreateCommand("Test Student 11")).getBody();

		ResponseEntity<StudentCourseResponse> createResponse = StudentCourseClient.linkCourseAndClient(restTemplate, course.getId(), student.getId());

		assertEquals(HttpStatus.OK, createResponse.getStatusCode());
		assertNotNull(createResponse.getBody().getId());
		assertNotNull(createResponse.getBody().getCourseId());
		assertNotNull(createResponse.getBody().getStudentId());

		ResponseEntity<Void> deleteResponse = StudentCourseClient.delete(restTemplate, createResponse.getBody().getCourseId(), createResponse.getBody().getStudentId());
		assertEquals(HttpStatus.OK, deleteResponse.getStatusCode());
	}
}
