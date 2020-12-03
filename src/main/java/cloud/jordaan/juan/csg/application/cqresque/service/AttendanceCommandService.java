package cloud.jordaan.juan.csg.application.cqresque.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.jordaan.juan.csg.application.cqresque.model.AttendanceCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.AttendanceQueryResponse;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.Attendance;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.CourseTerm;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.StudentCourse;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.AttendanceRepository;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.CourseTermRepository;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.StudentCourseRepository;

@Service
public class AttendanceCommandService {
	@Autowired
	private AttendanceRepository repository;
	@Autowired
	private CourseTermRepository courseTermRepository;
	@Autowired
	private StudentCourseRepository studentCourseRepository;

	public AttendanceQueryResponse create(Long courseTermId, AttendanceCreateCommand command) {
		CourseTerm courseTerm = courseTermRepository.findById(courseTermId).orElseThrow(() -> new EntityNotFoundException("Failed to find courseTerm with id " + courseTermId));
		StudentCourse studentCourse = studentCourseRepository.findByCourseAndStudentId(courseTerm.getCourse().getId(), command.getStudentId()).orElseThrow(() -> new EntityNotFoundException("Student with id " + command.getStudentId() + " courseTerm with id " + courseTermId));
		
		Attendance attendance = new Attendance();
		attendance.setDate(command.getDate());
		attendance.setPresent(command.getPresent());
		attendance.setStudentCourse(studentCourse);
		attendance.setCourseTerm(courseTerm);

		attendance = repository.save(attendance);
		return new AttendanceQueryResponse(attendance.getId(), attendance.getVersion(), attendance.getPresent(), attendance.getDate());
	}

	public AttendanceQueryResponse update(Long courseTermId, AttendanceCreateCommand attendanceCommand) {
		return create(courseTermId, attendanceCommand);
	}
}
