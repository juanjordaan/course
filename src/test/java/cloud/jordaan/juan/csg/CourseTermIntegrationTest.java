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
import cloud.jordaan.juan.csg.application.cqresque.model.CourseTermQueryResponse;
import cloud.jordaan.juan.csg.client.CourseClient;
import cloud.jordaan.juan.csg.client.CourseTermClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SchoolApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseTermIntegrationTest extends IntegrationTest {

	@Test
	public void test_whenCreateCourse_thenCorrectCourse() {
		// given
		Long courseId = CourseClient.createCourse(restTemplate, new CourseCreateCommand("Course 1")).getBody().getId();
		CourseTermCommand courseTermCommand = new CourseTermCommand("English Term 1 Name", new Date(), new Date());

		// when
		ResponseEntity<CourseTermQueryResponse> response = CourseTermClient.createTerm(restTemplate, courseId, courseTermCommand);
		assertEquals(HttpStatus.OK, response.getStatusCode());

		// then
		CourseTermQueryResponse courseTerm = response.getBody();
		assertNotNull(response.getBody().getId());
		assertEquals(courseTerm.getName(), courseTermCommand.getName());
		assertEquals(courseTerm.getStartDate(), courseTermCommand.getStartDate());
		assertEquals(courseTerm.getEndDate(), courseTermCommand.getEndDate());

		// Test the list as well
		StreamSupport.stream(CourseTermClient.listTerms(restTemplate, courseId).getBody().spliterator(), true)
			.filter(i -> i.getName().equalsIgnoreCase(courseTermCommand.getName()))
			.findFirst()
			.orElseThrow( () -> new RuntimeException("Failed to find created term in list"));
	}
}
