package cloud.jordaan.juan.csg.interfaces.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.jordaan.juan.csg.application.cqresque.model.GradeCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.GradeQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.service.GradeCommandService;
import cloud.jordaan.juan.csg.application.cqresque.service.GradeQueryService;

@RestController
@RequestMapping("api/v1/courseterms/{courseTermId}/grades")
public class GradeController {
	@Autowired
	private GradeCommandService commandService;

	@Autowired
	private GradeQueryService queryService;

	@GetMapping
	public List<GradeQueryResponse> retrieveAll(@PathVariable("courseTermId") Long courseTermId) {
		return queryService.findAllByCourseTermId(courseTermId);
	}

	@PostMapping
	public GradeQueryResponse craete(@PathVariable("courseTermId") Long courseTermId, @RequestBody GradeCreateCommand grade) {
		return commandService.createGrade(courseTermId, grade);
	}
}
