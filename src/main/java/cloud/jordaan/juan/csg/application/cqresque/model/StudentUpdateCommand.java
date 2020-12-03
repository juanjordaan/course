package cloud.jordaan.juan.csg.application.cqresque.model;

import javax.validation.constraints.NotNull;

public class StudentUpdateCommand {
	@NotNull(message = "id may not be null")
	private Long id;
	@NotNull(message = "version may not be null")
	private Long version;
	@NotNull(message = "fullname may not be null")
	private String fullname;

	public StudentUpdateCommand() {
		
	}

	public StudentUpdateCommand(Long id, Long version, String fullname) {
		super();
		this.id = id;
		this.version = version;
		this.fullname = fullname;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Override
	public String toString() {
		return "StudentUpdateCommand[id=" + id + ",version=" + version + "fullname=" + fullname + "]";
	}
}
