package cloud.jordaan.juan.csg.application.cqresque.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.jordaan.juan.csg.application.cqresque.model.GradeQueryResponse;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.GradeRepository;

@Service
public class GradeQueryService {
	@Autowired
	private GradeRepository repository;

	public List<GradeQueryResponse> findAllByCourseTermId(Long courseTermId) {
		return StreamSupport.stream(repository.findAllByCourseTermId(courseTermId).spliterator(), false)
			.map( i -> new GradeQueryResponse(i.getId(), i.getVersion(), i.getStudentCourse().getId(), i.getScore()))
			.collect(Collectors.toList());
	}
}
