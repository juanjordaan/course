package cloud.jordaan.juan.csg.application.cqresque.model;

import javax.validation.constraints.NotNull;

public class StudentCreateCommand {
	@NotNull(message = "fullname may not be null")
	private String fullname;

	public StudentCreateCommand() {
		
	}

	public StudentCreateCommand(String fullname) {
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
		return "StudentCreateCommand[fullname=" + fullname + "]";
	}
}
