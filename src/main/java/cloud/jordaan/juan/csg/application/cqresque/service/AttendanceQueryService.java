package cloud.jordaan.juan.csg.application.cqresque.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.jordaan.juan.csg.application.cqresque.model.AttendanceQueryResponse;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.AttendanceRepository;

@Service
public class AttendanceQueryService {
	@Autowired
	private AttendanceRepository repository;

	public List<AttendanceQueryResponse> findAllByCourseTermId(Long courseTermId) {
		return StreamSupport.stream(repository.findByCourseTermId(courseTermId).spliterator(), false)
			.map(i -> new AttendanceQueryResponse(i.getId(), i.getVersion(), i.getPresent(), i.getDate()))
			.collect(Collectors.toList());
	}
}
