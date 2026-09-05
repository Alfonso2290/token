package security.token.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TokenResponse implements Serializable {

	@JsonProperty("access_token")
	private String access;

	public TokenResponse(String access) {
		this.access = access;
	}

	public TokenResponse() {
	}
}
