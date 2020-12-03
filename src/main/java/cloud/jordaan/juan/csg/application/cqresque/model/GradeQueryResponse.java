package cloud.jordaan.juan.csg.application.cqresque.model;

public class GradeQueryResponse {
	private Long id;
	private Long version;
	private Long studentId;
	private String score;

	public GradeQueryResponse() {
		
	}

	public GradeQueryResponse(Long id, Long version, Long studentId, String score) {
		super();
		this.id = id;
		this.version = version;
		this.studentId = studentId;
		this.score = score;
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

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "GradeQueryResponse[id=" + id + ",version=" + version + ",studentId=" + studentId + ",score=" + score + "]";
	}
}
