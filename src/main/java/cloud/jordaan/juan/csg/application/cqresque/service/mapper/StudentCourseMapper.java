package cloud.jordaan.juan.csg.application.cqresque.service.mapper;

import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;
import static com.googlecode.jmapper.api.JMapperAPI.attribute;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.annotations.JMapConversion;
import com.googlecode.jmapper.api.JMapperAPI;

import cloud.jordaan.juan.csg.application.cqresque.model.StudentCourseResponse;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.StudentCourse;

public interface StudentCourseMapper {
	static final JMapperAPI jmapperApi = new JMapperAPI()
		.add(mappedClass(StudentCourse.class)
			.add(attribute("id").value("id"))
			.add(attribute("version").value("version"))
		)
		.add(mappedClass(StudentCourseResponse.class)
			.add(attribute("id").value("id"))
			.add(attribute("version").value("version"))
		);

	static final JMapper<StudentCourseResponse, StudentCourse> toDtoMapper = new JMapper<>(StudentCourseResponse.class, StudentCourse.class, jmapperApi);
	static final JMapper<StudentCourse, StudentCourseResponse> toEntityMapper = new JMapper<>(StudentCourse.class, StudentCourseResponse.class, jmapperApi);

	@JMapConversion(from={"course.id"}, to={"courseId"})
	public static StudentCourseResponse toStudentCourseResponse(StudentCourse entity) {
		StudentCourseResponse c = toDtoMapper.getDestination(entity);
		c.setCourseId(entity.getCourse().getId());
		c.setStudentId(entity.getStudent().getId());

		return c;
	}
}
