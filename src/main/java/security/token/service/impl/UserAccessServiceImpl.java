package security.token.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import security.token.model.dto.TokenRequest;
import security.token.model.dto.TokenResponse;
import security.token.repository.UserAccessRepository;
import security.token.service.UserAccessService;
import security.token.util.TokenUtil;

@Service
@RequiredArgsConstructor
public class UserAccessServiceImpl implements UserAccessService {

	private final UserAccessRepository userAccessRepository;

	@Override
	public ResponseEntity<TokenResponse> generateToken(TokenRequest tokenRequest) {

		return userAccessRepository.findByUserAndPassword(
				tokenRequest.getUsername(),
				tokenRequest.getPassword()
		).map(userAccessEntity -> ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(new TokenResponse(TokenUtil.EncodeBase64Token(
						userAccessEntity.getRole(),
						userAccessEntity.getUser(),
						userAccessEntity.getPassword()))))
				.orElse(ResponseEntity.internalServerError()
				.contentType(MediaType.APPLICATION_JSON)
				.header("Error", "Cuenta inválida")
				.build());
	}

	@Override
	public String decodeToken(String token) {
		return TokenUtil.DecodeBase64Token(token);
	}
}
