package cloud.jordaan.juan.csg.infrastructure.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Table(name = "course", uniqueConstraints = { @UniqueConstraint(columnNames = "name") })
@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	private Long version;

	private String name;

	@OneToMany(mappedBy = "course")
	private List<StudentCourse> studentCourse = new ArrayList<StudentCourse>();

	public Course() {
		
	}

	public Course(String name) {
		super();
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(List<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public void addStudentClass(StudentCourse student) {
		this.studentCourse.add(student);
	}

	@Override
	public String toString() {
		return "SchoolClass[id=" + id + ",version=" + version + "name,=" + name + ",studentCourse=" + studentCourse + "]";
	}
}
