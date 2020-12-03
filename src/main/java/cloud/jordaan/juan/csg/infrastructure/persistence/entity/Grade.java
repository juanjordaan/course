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

@NamedQueries( value = {
	@NamedQuery(name="Grade.findAllByCourseTermId", query = "from Grade where courseTerm.id = :courseTermId")
})
@Table(name="student_course_grade")
@Entity
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Long version;

	@ManyToOne
	private StudentCourse studentCourse;

	@ManyToOne 
	private CourseTerm courseTerm;

	private String score;

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

	public StudentCourse getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(StudentCourse studentCourse) {
		this.studentCourse = studentCourse;
	}

	public CourseTerm getCourseTerm() {
		return courseTerm;
	}

	public void setCourseTerm(CourseTerm courseTerm) {
		this.courseTerm = courseTerm;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Grade[id=" + id + ",version=" + version + ",studentCourse=" + studentCourse + ",courseTerm=" + courseTerm + ",score=" + score + "]";
	}
}
