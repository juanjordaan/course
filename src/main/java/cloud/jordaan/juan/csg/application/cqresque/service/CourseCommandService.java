package cloud.jordaan.juan.csg.application.cqresque.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.jordaan.juan.csg.application.cqresque.model.CourseCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.CourseQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.service.mapper.CourseMapper;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.CourseRepository;

@Service
public class CourseCommandService {
	@Autowired
	private CourseRepository schoolClassRepository;

	public CourseQueryResponse create(CourseCreateCommand command) {
		return CourseMapper.toCourseQueryResponse(schoolClassRepository.save(CourseMapper.toEntity(command)));
	}
}
