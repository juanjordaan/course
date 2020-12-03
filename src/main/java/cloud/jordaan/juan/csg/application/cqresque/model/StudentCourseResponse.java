package cloud.jordaan.juan.csg.application.cqresque.model;

public class StudentCourseResponse {
	private Long id;
	private Long version;
	private Long courseId;
	private Long studentId;

	public StudentCourseResponse() {
		
	}

	public StudentCourseResponse(Long courseId, Long studentId) {
		super();
		this.courseId = courseId;
		this.studentId = studentId;
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

	
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "StudentClassDto[id=" + id + ",version=" + version + ",courseId=" + courseId + ",studentId=" + studentId + "]";
	}
}
