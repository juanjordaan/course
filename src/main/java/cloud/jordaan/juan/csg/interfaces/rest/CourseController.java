package cloud.jordaan.juan.csg.interfaces.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.jordaan.juan.csg.application.cqresque.model.CourseCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.CourseQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.service.CourseCommandService;
import cloud.jordaan.juan.csg.application.cqresque.service.CourseQueryService;

@RestController
@RequestMapping("/api/v1/school/courses")
public class CourseController {
	@Autowired
	private CourseQueryService queryService;

	@Autowired
	private CourseCommandService commandService;

	@GetMapping
	public List<CourseQueryResponse> retrieveAll() {
		return queryService.findAll();
	}

	@PostMapping
	public CourseQueryResponse create(@RequestBody CourseCreateCommand courseCommand) {
		return commandService.create(courseCommand);
	}

	@GetMapping("/{id}")
	public CourseQueryResponse retrieve(@PathVariable("id") Long id) {
		return queryService.findById(id);
	}
}
