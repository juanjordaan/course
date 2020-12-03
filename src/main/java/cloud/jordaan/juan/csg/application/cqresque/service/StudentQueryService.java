package cloud.jordaan.juan.csg.application.cqresque.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.jordaan.juan.csg.application.cqresque.model.StudentQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.service.mapper.StudentMapper;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.StudentRepository;

@Service
public class StudentQueryService {
	@Autowired
	private StudentRepository studentRepository;

	public List<StudentQueryResponse> findAll() {
		return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
			.map(StudentMapper::toStudentQueryResponse)
			.collect(Collectors.toList());
	}

	public StudentQueryResponse findById(Long id) {
		return StudentMapper.toStudentQueryResponse(studentRepository
			.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Could not find StudentRepository with id " + id)));
	}
}
