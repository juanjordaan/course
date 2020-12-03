package cloud.jordaan.juan.csg.application.cqresque.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.jordaan.juan.csg.application.cqresque.model.CourseQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.service.mapper.CourseMapper;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.CourseRepository;

@Service
public class CourseQueryService {
	@Autowired
	private CourseRepository schoolClassRepository;

	public CourseQueryResponse findById(Long id) {
		return CourseMapper.toCourseQueryResponse(schoolClassRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException("Could not find StudentClass with id " + id)));
	}

	public List<CourseQueryResponse> findAll() {
		return StreamSupport
			.stream(schoolClassRepository.findAll().spliterator(), true)
			.map(CourseMapper::toCourseQueryResponse)
			.collect(Collectors.toList());
	}
}
