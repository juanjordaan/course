package cloud.jordaan.juan.csg.application.cqresque.model;

import javax.validation.constraints.NotNull;

public class GradeCreateCommand {
	@NotNull(message = "studentId may not be null")
	private Long studentId;
	@NotNull(message = "score may not be null")
	private String score;

	public GradeCreateCommand() {
		
	}

	public GradeCreateCommand(Long studentId, String score) {
		this.studentId = studentId;
		this.score = score;
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
		return "GradeCommand[score=" + score + "]";
	}
}
