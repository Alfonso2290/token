package security.token.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

	@PostMapping(
			value = "/decrypt",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public String decodeToken(@RequestParam("token") String token){
		return userAccessFacade.decodeToken(token);
	}
}
