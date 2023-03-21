package demo.PoemWithMe.auth;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class JWTHandlerTest {
    JWTHandler jwtHandler = new JWTHandler();
    @Test
    void createTokenTest() {
        String encode = Base64.getEncoder().encodeToString("key".getBytes());
        String token = jwtHandler.CreateToken(encode, "subject", 60L);
        Assertions.assertThat(token).contains("Bearer");
    }

    @Test
    void extractSubject() {
    }

    @Test
    void validate() {
    }
}