package cloud.jordaan.juan.csg.application.cqresque.service.mapper;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import cloud.jordaan.juan.csg.application.cqresque.model.StudentCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentQueryResponse;
import cloud.jordaan.juan.csg.application.cqresque.model.StudentUpdateCommand;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.Student;

public interface StudentMapper {

	public static StudentQueryResponse toStudentQueryResponse(Student source) {
		StudentQueryResponse dest = new StudentQueryResponse();
		dest.setId(source.getId());
		dest.setVersion(source.getVersion());
		dest.setFullname(source.getFullname());
		dest.setStudentCourses(StreamSupport.stream(source.getStudentCourses().spliterator(), false)
			.map(StudentCourseMapper::toStudentCourseResponse)
			.collect(Collectors.toList())
		);
		return dest;
	}

	public static Student toEntity(StudentCreateCommand source) {
		Student dest = new Student();
		dest.setFullname(source.getFullname());

		return dest;
	}

	public static Student toEntity(StudentUpdateCommand source) {
		Student dest = new Student();
		dest.setFullname(source.getFullname());

		return dest;
	}
}
