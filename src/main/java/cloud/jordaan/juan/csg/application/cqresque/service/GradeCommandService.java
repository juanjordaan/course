package cloud.jordaan.juan.csg.application.cqresque.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cloud.jordaan.juan.csg.application.cqresque.model.GradeCreateCommand;
import cloud.jordaan.juan.csg.application.cqresque.model.GradeQueryResponse;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.CourseTerm;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.Grade;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.StudentCourse;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.CourseTermRepository;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.GradeRepository;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.StudentCourseRepository;

@Service
public class GradeCommandService {
	@Autowired
	private GradeRepository repository;

	@Autowired
	private CourseTermRepository courseTermRepository;

	@Autowired
	private StudentCourseRepository studentCourseRepository;

	public GradeQueryResponse createGrade(Long courseTermId, GradeCreateCommand command) {
		CourseTerm courseTerm = courseTermRepository.findById(courseTermId).orElseThrow(() -> new EntityNotFoundException("Failed to find courseTerm with id " + courseTermId));
		StudentCourse studentCourse = studentCourseRepository.findByCourseAndStudentId(courseTerm.getCourse().getId(), command.getStudentId()).orElseThrow(() -> new EntityNotFoundException("Student with id " + command.getStudentId() + " courseTerm with id " + courseTermId));
		Grade grade = new Grade();
		grade.setCourseTerm(courseTerm);
		grade.setStudentCourse(studentCourse);
		grade.setScore(command.getScore());

		grade = repository.save(grade);
		return new GradeQueryResponse(grade.getId(), grade.getVersion(), grade.getStudentCourse().getId(), grade.getScore());
	}
}
