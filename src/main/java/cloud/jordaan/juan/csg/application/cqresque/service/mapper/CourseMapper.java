package cloud.jordaan.juan.csg.application.cqresque.service.mapper;

import cloud.jordaan.juan.csg.application.cqresque.model.CourseCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.CourseQueryResponse;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.Course;

public interface CourseMapper {
	public static CourseQueryResponse toCourseQueryResponse(Course source) {
		CourseQueryResponse dest = new CourseQueryResponse();
		dest.setId(source.getId());
		dest.setVersion(source.getVersion());
		dest.setName(source.getName());

		return dest;
	}

	public static Course toEntity(CourseCreateCommand source) {
		Course dest = new Course();
		dest.setName(source.getName());

		return dest;
	}
}
