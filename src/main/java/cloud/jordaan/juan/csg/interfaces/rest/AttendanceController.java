package cloud.jordaan.juan.csg.interfaces.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.jordaan.juan.csg.application.cqresque.model.AttendanceCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.AttendanceQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.service.AttendanceCommandService;
import cloud.jordaan.juan.csg.application.cqresque.service.AttendanceQueryService;

@RestController
@RequestMapping("/api/v1/courseterms/{courseTermId}/attendance")
public class AttendanceController {
	@Autowired
	private AttendanceCommandService commandService;

	@Autowired
	private AttendanceQueryService queryService;

	@PostMapping
	public AttendanceQueryResponse create(@PathVariable("courseTermId") Long courseTermId, @RequestBody AttendanceCreateCommand attendanceCommand) {
		return commandService.create(courseTermId, attendanceCommand);
	}

	@PutMapping("/{id}")
	public AttendanceQueryResponse update(@PathVariable("courseTermId") Long courseTermId, @RequestBody AttendanceCreateCommand attendanceCommand) {
		return commandService.update(courseTermId, attendanceCommand);
	}

	@GetMapping
	public List<AttendanceQueryResponse> retrieveAll(@PathVariable("courseTermId") Long courseTermId) {
		return queryService.findAllByCourseTermId(courseTermId);
	}
}
