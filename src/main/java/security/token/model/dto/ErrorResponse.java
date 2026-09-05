package security.token.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ErrorResponse implements Serializable {
	private String message;

	public ErrorResponse() {
	}

	public ErrorResponse(String message) {
		this.message = message;
	}
}
