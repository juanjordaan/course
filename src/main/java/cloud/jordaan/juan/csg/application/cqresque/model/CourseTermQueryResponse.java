package cloud.jordaan.juan.csg.application.cqresque.model;

import java.util.Date;

public class CourseTermQueryResponse {
	private Long id;
	private Long version;
	private String name;
	private Date startDate;
	private Date endDate;
	private CourseQueryResponse course;

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

	public CourseQueryResponse getCourse() {
		return course;
	}

	public void setCourse(CourseQueryResponse course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "CourseTerm[id=" + id + ",version=" + version + ",name=" + name + ",startDate=" + startDate + ",endDate=" + endDate + ",course=" + course + "]";
	}
}
