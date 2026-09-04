package security.token.service;

import security.token.model.dto.TokenRequest;
import security.token.model.dto.TokenResponse;

public interface UserAccessService {
	TokenResponse generateToken(TokenRequest tokenRequest);
}
