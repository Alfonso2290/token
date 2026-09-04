package security.token.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import security.token.Repository.UserAccessRepository;
import security.token.model.dto.TokenRequest;
import security.token.model.dto.TokenResponse;
import security.token.model.entity.UserAccess;
import security.token.service.UserAccessService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserAccessServiceImpl implements UserAccessService {

	private final UserAccessRepository userAccessRepository;

	@Override
	public TokenResponse generateToken(TokenRequest tokenRequest) {
		//Mejorar obtencion de info
		Optional<List<UserAccess>> userAccessEntityOptional = userAccessRepository
				.findByUserAndPassword(tokenRequest.getUsername(), tokenRequest.getPassword());

		TokenResponse tokenResponse = new TokenResponse();

		if(userAccessEntityOptional.isPresent()){
			UserAccess userAccessEntity = userAccessEntityOptional.get().get(0);
			String role = userAccessEntity.getRole();

			//Transformar en base64
			String roleTransformed = role;

			//Usar Mapping
			tokenResponse.setAccess(roleTransformed);
		}

		return tokenResponse;
	}
}
