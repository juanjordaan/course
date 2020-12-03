package cloud.jordaan.juan.csg.application.cqresque.service;

import static cloud.jordaan.juan.csg.application.cqresque.service.mapper.StudentCourseMapper.toStudentCourseResponse;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.jordaan.juan.csg.application.cqresque.model.StudentCourseResponse;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.StudentCourseRepository;

@Service
@Transactional
public class StudentCourseQueryService {
	@Autowired
	private StudentCourseRepository repository;

	public List<StudentCourseResponse> getAllByClassId(Long courseId) {
		return StreamSupport.stream(repository.findAllByCourseId(courseId).spliterator(), false)
			.map(c -> toStudentCourseResponse(c))
			.collect(Collectors.toList());
	}

	public StudentCourseResponse findByClassAndStudentId(Long classId, Long studentId) {
		return toStudentCourseResponse(repository
			.findByCourseAndStudentId(classId, studentId)
			.orElseThrow(() -> new EntityNotFoundException("Could not find StudentClass with classId=" + classId + ",studentId=" + studentId)));
	}
}
