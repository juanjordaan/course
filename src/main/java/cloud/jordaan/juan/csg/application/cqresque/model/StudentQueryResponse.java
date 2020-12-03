package cloud.jordaan.juan.csg.application.cqresque.model;

import java.util.ArrayList;
import java.util.List;

public class StudentQueryResponse {
	private Long id;
	private Long version;
	private String fullname;
	private List<StudentCourseResponse> studentCourses = new ArrayList<StudentCourseResponse>();

	public StudentQueryResponse() {
		
	}

	public StudentQueryResponse(String fullname) {
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

	public List<StudentCourseResponse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourseResponse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public void addStudentCourse(StudentCourseResponse studentCourse) {
		if(studentCourses == null) studentCourses = new ArrayList<StudentCourseResponse>();
        this.studentCourses.add(studentCourse);
    }

	@Override
	public String toString() {
		return "StudentQueryResponse[id=" + id + ",version=" + version + ",fullname=" + fullname + ",studentClasses=" + studentCourses + "]";
	}
}
