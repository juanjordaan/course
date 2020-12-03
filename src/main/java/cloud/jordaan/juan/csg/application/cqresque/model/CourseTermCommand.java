package cloud.jordaan.juan.csg.application.cqresque.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class CourseTermCommand {
	@NotNull(message = "name may not be null")
	private String name;
	@NotNull(message = "startDate may not be null")
	private Date startDate;
	@NotNull(message = "endDate may not be null")
	private Date endDate;

	public CourseTermCommand() {
		
	}

	public CourseTermCommand(String name, Date startDate, Date endDate) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "CourseTerm[name=" + name + ",startDate=" + startDate + ",endDate=" + endDate + "]";
	}
}
