package cloud.jordaan.juan.csg.interfaces.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.jordaan.juan.csg.application.cqresque.model.StudentCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentUpdateCommand;
import cloud.jordaan.juan.csg.application.cqresque.service.StudentCommandService;
import cloud.jordaan.juan.csg.application.cqresque.service.StudentQueryService;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
	@Autowired
	private StudentCommandService commandService;

	@Autowired
	private StudentQueryService queryService;

	@GetMapping
	public List<StudentQueryResponse> retrieveAll() {
		return queryService.findAll();
	}

	@GetMapping("/{id}")
	public StudentQueryResponse retrieve(@PathVariable("id") Long id) {
		return queryService.findById(id);
	}

	@PostMapping
	public StudentQueryResponse create(@RequestBody StudentCreateCommand student) {
		return commandService.create(student);
	}

	@PutMapping
	public StudentQueryResponse update(@RequestBody StudentUpdateCommand student) {
		return commandService.update(student);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		commandService.deleteById(id);
	}
}
