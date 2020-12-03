package cloud.jordaan.juan.csg.application.cqresque.service;

import static cloud.jordaan.juan.csg.application.cqresque.service.mapper.CourseTermMapper.toEntity;
import static cloud.jordaan.juan.csg.application.cqresque.service.mapper.CourseTermMapper.toStudentQueryResponse;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.jordaan.juan.csg.application.cqresque.model.CourseTermCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.CourseTermQueryResponse;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.CourseTerm;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.CourseRepository;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.CourseTermRepository;

@Transactional
@Service
public class CourseTermCommandService {
	@Autowired
	CourseTermRepository repository;

	@Autowired
	CourseRepository courseRepository;

	public CourseTermQueryResponse create(Long courseId, CourseTermCommand command) {
		CourseTerm courseTerm = toEntity(command);
		courseTerm.setCourse(courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Failed to find course with id " + courseId)));
		return toStudentQueryResponse(repository.save(courseTerm));
	}
}
