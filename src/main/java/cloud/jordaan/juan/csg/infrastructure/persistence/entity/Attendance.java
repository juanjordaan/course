package cloud.jordaan.juan.csg.infrastructure.persistence.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@NamedQueries(value = {
	@NamedQuery(name = "Attendance.findByCourseTermId", query = "from Attendance where courseTerm.id = :courseTermId")
})
@Table(name="student_course_attendance")
@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Long version;

	private Boolean present;

	private Date date;

	@ManyToOne 
	private CourseTerm courseTerm;

	@OneToOne
	private StudentCourse studentCourse;

	public Attendance() {
		super();
	}

	public Attendance(Boolean present, Date date, StudentCourse studentCourse) {
		super();
		this.present = present;
		this.date = date;
		this.studentCourse = studentCourse;
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

	public Boolean getPresent() {
		return present;
	}

	public void setPresent(Boolean present) {
		this.present = present;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public StudentCourse getStudentCourses() {
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

	public StudentCourse getStudentCourse() {
		return studentCourse;
	}

	@Override
	public String toString() {
		return "Attendance[id=" + id + ",version=" + version + ",present=" + present + ",date=" + date + ",studentCourse=" + studentCourse + ",courseTerm=" + courseTerm + "]";
	}
}
