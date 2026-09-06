package security.token.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class TokenUtil {

	public static String EncodeBase64Token(String role, String user, String password){
		return Base64.getEncoder()
				.encodeToString((role.concat("-").concat(user).concat("-").concat(password))
						.getBytes(StandardCharsets.UTF_8));
	}

	public static String DecodeBase64Token(String token){
		return new String(
				Base64.getDecoder().decode(token),
				StandardCharsets.UTF_8
		);
	}
}
