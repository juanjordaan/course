package cloud.jordaan.juan.csg.application.cqresque.model;

public class CourseQueryResponse {
	private Long id;
	private Long version;
	private String name;

	public CourseQueryResponse() {
		
	}

	public CourseQueryResponse(Long id, Long version, String name) {
		super();
		this.id = id;
		this.version = version;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CourseQueryResponseDto[id=" + id + ",version=" + version + "name,=" + name + "]";
	}
}
