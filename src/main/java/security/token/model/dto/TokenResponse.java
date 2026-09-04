package security.token.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TokenResponse implements Serializable {
	private String access;
}
