package cloud.jordaan.juan.csg.interfaces.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.jordaan.juan.csg.application.cqresque.model.StudentCourseResponse;
import cloud.jordaan.juan.csg.application.cqresque.service.StudentCourseCommandService;
import cloud.jordaan.juan.csg.application.cqresque.service.StudentCourseQueryService;

@Transactional(propagation = Propagation.NOT_SUPPORTED)
@RestController
@RequestMapping("/api/v1/courses/{courseId}")
public class StudentCourseController {
	@Autowired
	private StudentCourseQueryService queryService;

	@Autowired
	private StudentCourseCommandService commandService;

	@GetMapping
	public List<StudentCourseResponse> retrieveAll(@PathVariable("courseId") Long courseId) {
		return queryService.getAllByClassId(courseId);
	}

	@GetMapping("/students/{studentId}")
	public StudentCourseResponse retrieve(@PathVariable("courseId") Long courseId, @PathVariable("studentId") Long studentId) {
		return queryService.findByClassAndStudentId(courseId, studentId);
	}

	@PostMapping("/students/{studentId}")
	public StudentCourseResponse create(@PathVariable("courseId") Long courseId, @PathVariable("studentId") Long studentId) {
		return commandService.create(courseId, studentId);
	}

    @DeleteMapping("/students/{studentId}")
    public void delete(@PathVariable("courseId") Long courseId, @PathVariable("studentId") Long studentId) {
        commandService.deleteByClassAndStudentId(courseId, studentId);
    }
}
