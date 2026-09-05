package security.token.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import security.token.facade.UserAccessFacade;
import security.token.model.dto.TokenRequest;
import security.token.model.dto.TokenResponse;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class UserAccessController {

	private final UserAccessFacade userAccessFacade;

	@PostMapping(
			value = "/generate",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<TokenResponse> generateToken(@RequestBody TokenRequest tokenRequest){
		return userAccessFacade.generateToken(tokenRequest);
	}
}
