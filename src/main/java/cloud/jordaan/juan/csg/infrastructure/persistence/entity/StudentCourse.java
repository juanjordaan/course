package cloud.jordaan.juan.csg.infrastructure.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * A Join Table - Joining students with courses
 * 
 * @author juan
 *
 */
@NamedQueries(value= {
	@NamedQuery(name="StudentCourse.findByCourseAndStudentId", query = "from StudentCourse where course.id = :courseId and student.id = :studentId"),
	@NamedQuery(name="StudentCourse.findAllByCourseId", query = "from StudentCourse where course.id = :courseId")
})
@Table(name = "student_course")
@Entity
public class StudentCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Long version;

	@ManyToOne
	private Course course;

	@ManyToOne
	private Student student;

	public StudentCourse() {
		
	}

	public StudentCourse(Course course, Student student) {
		this.course = course;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentCourse[id=" + id + ",version=" + version + ",course=" + course + ",student=" + student + "]";
	}
}
