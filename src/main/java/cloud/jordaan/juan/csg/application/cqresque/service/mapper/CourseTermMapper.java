package cloud.jordaan.juan.csg.application.cqresque.service.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import cloud.jordaan.juan.csg.application.cqresque.model.CourseTermCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.CourseTermQueryResponse;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.CourseTerm;

public class CourseTermMapper {
	public static CourseTerm toEntity(CourseTermCommand source) {
		CourseTerm dest = new CourseTerm();
		dest.setName(source.getName());
		dest.setStartDate(source.getStartDate());
		dest.setEndDate(source.getEndDate());

		return dest;
	}

	public static List<CourseTermQueryResponse> toStudentQueryResponse(List<CourseTerm> sources) {
		return StreamSupport.stream(sources.spliterator(), false)
			.map(CourseTermMapper::toStudentQueryResponse)
			.collect(Collectors.toList());
	}

	public static CourseTermQueryResponse toStudentQueryResponse(CourseTerm source) {
		CourseTermQueryResponse dest = new CourseTermQueryResponse();
		dest.setId(source.getId());
		dest.setVersion(source.getVersion());
		dest.setName(source.getName());
		dest.setStartDate(source.getStartDate());
		dest.setEndDate(source.getEndDate());
		dest.setCourse(CourseMapper.toCourseQueryResponse(source.getCourse()));

		return dest;
	}
}
