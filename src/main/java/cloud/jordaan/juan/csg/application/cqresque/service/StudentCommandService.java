package cloud.jordaan.juan.csg.application.cqresque.service;

import static cloud.jordaan.juan.csg.application.cqresque.service.mapper.StudentMapper.toEntity;
import static cloud.jordaan.juan.csg.application.cqresque.service.mapper.StudentMapper.toStudentQueryResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.jordaan.juan.csg.application.cqresque.model.StudentCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentUpdateCommand;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.StudentRepository;

@Service
public class StudentCommandService {
	@Autowired
	private StudentRepository studentRepository;

	public StudentQueryResponse create(StudentCreateCommand command) {
		return toStudentQueryResponse(studentRepository.save(toEntity(command)));
	}

	public StudentQueryResponse update(StudentUpdateCommand command) {
		return toStudentQueryResponse(studentRepository.save(toEntity(command)));
	}

	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}
}
