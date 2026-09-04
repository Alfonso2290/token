package security.token.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TokenRequest implements Serializable {
	private String username;
	private String password;
}
