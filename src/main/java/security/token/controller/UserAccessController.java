package security.token.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import security.token.facade.UserAccessFacade;
import security.token.model.dto.TokenRequest;
import security.token.model.dto.TokenResponse;

@Controller
@RequestMapping("/token")
@RequiredArgsConstructor
public class UserAccessController {

	private final UserAccessFacade userAccessFacade;

	@PostMapping("/generate")
	public TokenResponse generateToken(@RequestBody TokenRequest tokenRequest){
		return userAccessFacade.generateToken(tokenRequest);
	}
}
