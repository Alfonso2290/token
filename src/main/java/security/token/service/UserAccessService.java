package security.token.service;

import org.springframework.http.ResponseEntity;
import security.token.model.dto.TokenRequest;
import security.token.model.dto.TokenResponse;

public interface UserAccessService {
	ResponseEntity<TokenResponse> generateToken(TokenRequest tokenRequest);
	String decodeToken(String token);
}
