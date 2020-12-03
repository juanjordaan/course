package cloud.jordaan.juan.csg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.stream.StreamSupport;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import cloud.jordaan.juan.csg.application.cqresque.model.CourseCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.CourseTermCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.GradeCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.GradeQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentCreateCommand;
import cloud.jordaan.juan.csg.client.CourseClient;
import cloud.jordaan.juan.csg.client.CourseTermClient;
import cloud.jordaan.juan.csg.client.GradeClient;
import cloud.jordaan.juan.csg.client.StudentClient;
import cloud.jordaan.juan.csg.client.StudentCourseClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SchoolApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GradeIntegrationTest extends IntegrationTest {
	@Test
	public void test_whenCreateGrade_thenCorrectGrade() {
		// To do Grading you need to link a course to term, and a student to a course
		// given
		Long courseId = CourseClient.createCourse(restTemplate, new CourseCreateCommand("Test SchoolClass 30")).getBody().getId();
		Long studentId = StudentClient.createStudent(restTemplate, new StudentCreateCommand("Test Student 30")).getBody().getId();
		StudentCourseClient.linkCourseAndClient(restTemplate, courseId, studentId);
		Long courseTermId = CourseTermClient.createTerm(restTemplate, courseId, new CourseTermCommand("English Term 2 Name", new Date(), new Date())).getBody().getId();

		// when
		ResponseEntity<GradeQueryResponse> response = GradeClient.createGrade(restTemplate, courseTermId, new GradeCreateCommand(studentId, "A"));
		// then
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals("A", response.getBody().getScore());

		// then also - Test the list as well
		StreamSupport.stream(GradeClient.listGrades(restTemplate, courseTermId).getBody().spliterator(), true)
			.filter(i -> i.getScore().equalsIgnoreCase(response.getBody().getScore()))
			.findFirst()
			.orElseThrow( () -> new RuntimeException("Failed to find created grade in list"));
	}
}
