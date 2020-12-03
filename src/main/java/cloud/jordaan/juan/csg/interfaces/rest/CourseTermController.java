package cloud.jordaan.juan.csg.interfaces.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.jordaan.juan.csg.application.cqresque.model.CourseTermCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.CourseTermQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.service.CourseTermCommandService;
import cloud.jordaan.juan.csg.application.cqresque.service.CourseTermQueryService;

@RestController
@RequestMapping("/api/v1/courses/{courseId}/terms")
public class CourseTermController {
	@Autowired
	CourseTermCommandService commandService;

	@Autowired
	CourseTermQueryService queryService;

	@GetMapping
	public List<CourseTermQueryResponse> findALl(@PathVariable("courseId") Long courseId) {
		return queryService.getAllByCourseId(courseId);
	}

	@PostMapping
	public CourseTermQueryResponse create(@PathVariable("courseId") Long courseId, @RequestBody CourseTermCommand courseTermCommand) {
		return commandService.create(courseId, courseTermCommand);
	}
}
