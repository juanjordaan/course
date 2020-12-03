package cloud.jordaan.juan.csg.application.cqresque.model;

import java.util.Date;

public class AttendanceUpdateCommand {
	private Long id;
	private Long version;
	private Boolean present;
	private Date date;

	public AttendanceUpdateCommand() {
		super();
	}

	public AttendanceUpdateCommand(Long id, Long version, Boolean present, Date date) {
		super();
		this.id = id;
		this.version = version;
		this.present = present;
		this.date = date;
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

	@Override
	public String toString() {
		return "AttendanceUpdateCommand[id=" + id + ",version=" + version + ",present=" + present + ",date=" + date + /*",studentClasses=" + studentClasses +*/ "]";
	}
}