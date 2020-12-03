package cloud.jordaan.juan.csg.application.cqresque.service;

import static cloud.jordaan.juan.csg.application.cqresque.service.mapper.StudentCourseMapper.toStudentCourseResponse;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cloud.jordaan.juan.csg.application.cqresque.model.StudentCourseResponse;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.Course;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.Student;
import cloud.jordaan.juan.csg.infrastructure.persistence.entity.StudentCourse;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.CourseRepository;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.StudentCourseRepository;
import cloud.jordaan.juan.csg.infrastructure.persistence.jpa.StudentRepository;

@Service
@Transactional
public class StudentCourseCommandService {
	@Autowired
	private StudentCourseRepository studentCourseRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository schoolClassRepository;

	public StudentCourseResponse create(Long classId, Long studentId) {
		Optional<Course> schoolClassOptional = schoolClassRepository.findById(classId);

		if (!schoolClassOptional.isPresent()) {
			throw new EntityNotFoundException("Failed to find SchoolClass id " + classId);
		}

		Optional<Student> studentOptional = studentRepository.findById(studentId);

		if (!studentOptional.isPresent()) {
			throw new EntityNotFoundException("Failed to find Student id " + classId);
		}

		return toStudentCourseResponse(studentCourseRepository.save(new StudentCourse(schoolClassOptional.get(), studentOptional.get())));
	}

	public void deleteByClassAndStudentId(Long classId, Long studentId) {
		studentCourseRepository.deleteByCourseAndStudentId(classId, studentId);
	}
}
