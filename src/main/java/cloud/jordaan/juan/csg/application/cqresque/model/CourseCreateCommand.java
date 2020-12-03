package cloud.jordaan.juan.csg.application.cqresque.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CourseCreateCommand implements Serializable {
	private static final long serialVersionUID = 8378313943274652855L;

	@NotNull(message = "name may not be null")
	private String name;

	public CourseCreateCommand() {
		
	}

	public CourseCreateCommand(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SchoolClassDto[name=" + name + "]";
	}
}
