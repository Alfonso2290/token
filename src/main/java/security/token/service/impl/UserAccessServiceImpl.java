package security.token.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import security.token.model.dto.TokenRequest;
import security.token.model.dto.TokenResponse;
import security.token.repository.UserAccessRepository;
import security.token.service.UserAccessService;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class UserAccessServiceImpl implements UserAccessService {

	private final UserAccessRepository userAccessRepository;

	@Override
	public ResponseEntity<TokenResponse> generateToken(TokenRequest tokenRequest) {

		return userAccessRepository.findByUserAndPassword(
				tokenRequest.getUsername(),
				tokenRequest.getPassword()
		).map(userAccessEntity -> {
			String roleEncoded = Base64.getEncoder()
					.encodeToString(userAccessEntity.getRole().getBytes(StandardCharsets.UTF_8));
			return ResponseEntity.ok()
					.contentType(MediaType.APPLICATION_JSON)
					.body(new TokenResponse(roleEncoded));
		}).orElse(ResponseEntity.internalServerError()
				.contentType(MediaType.APPLICATION_JSON)
				.header("Error", "Cuenta inválida")
				.build());
	}
}
