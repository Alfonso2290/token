package security.token.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import security.token.model.dto.TokenRequest;
import security.token.model.dto.TokenResponse;
import security.token.service.UserAccessService;

@Component
@RequiredArgsConstructor
public class UserAccessFacade {

	private final UserAccessService userAccessService;

	public ResponseEntity<TokenResponse> generateToken(TokenRequest tokenRequest){
		return userAccessService.generateToken(tokenRequest);
	}

	public String decodeToken(String token){
		return userAccessService.decodeToken(token);
	}
}
