package cloud.jordaan.juan.csg.application.cqresque.service;

import static cloud.jordaan.juan.csg.application.cqresque.service.mapper.CourseTermMapper.toStudentQueryResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.jordaan.juan.csg.application.cqresque.model.CourseTermQueryResponse;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.CourseTermRepository;

@Transactional
@Service
public class CourseTermQueryService {
	@Autowired
	public CourseTermRepository repository;

	public List<CourseTermQueryResponse> getAllByCourseId(Long courseId) {
		return toStudentQueryResponse(repository.findByCourseId(courseId));
	}
}
