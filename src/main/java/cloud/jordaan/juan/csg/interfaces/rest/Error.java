package cloud.jordaan.juan.csg.interfaces.rest;

import java.io.Serializable;

public class Error implements Serializable {
	private static final long serialVersionUID = 1L;

	private String code;
	private String message;

	public Error(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
