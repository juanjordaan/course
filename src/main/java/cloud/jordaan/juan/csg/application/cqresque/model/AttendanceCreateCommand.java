package cloud.jordaan.juan.csg.application.cqresque.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class AttendanceCreateCommand {

	@NotNull(message = "studentId may not be null")
	private Long studentId;
	@NotNull(message = "present may not be null")
	private Boolean present;
	@NotNull(message = "date may not be null")
	private Date date;

	public AttendanceCreateCommand() {
		
	}

	public AttendanceCreateCommand(Long studentId, Boolean present, Date date) {
		this.studentId = studentId;
		this.present = present;
		this.date = date;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
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

	@Override
	public String toString() {
		return "StudentClassAttendance[present=" + present + ",date=" + date + "]";
	}
}
