package cloud.jordaan.juan.csg.infrastructure.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Table(name = "student")
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Long version;

	private String fullname;

	@OneToMany(mappedBy = "student")
	private List<StudentCourse> studentCourses = new ArrayList<StudentCourse>();

	public Student() {
		
	}

	public Student(String fullname) {
		this.fullname = fullname;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public void addStudentClass(StudentCourse studentCourse) {
		if(studentCourses== null) studentCourses = new ArrayList<StudentCourse>();
        this.studentCourses.add(studentCourse);
    }

	@Override
	public String toString() {
		return "Student[id=" + id + ",version=" + version + ",fullname=" + fullname + ",studentCourses=" + studentCourses + "]";
	}
}
