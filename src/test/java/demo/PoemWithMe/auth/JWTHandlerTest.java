package demo.PoemWithMe.auth;

import demo.PoemWithMe.global.auth.JWTHandler;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

class JWTHandlerTest {
    JWTHandler jwtHandler = new JWTHandler();

    @Test
    void createTokenTest() {
        String encode = Base64.getEncoder().encodeToString("key".getBytes());
        String token = jwtHandler.createToken(encode, "subject", 60L);
        assertThat(token).contains("Bearer");
    }

    @Test
    void extractSubject() {
        Base64.Encoder encoder = Base64.getEncoder();
        String encode = encoder.encodeToString("key".getBytes());
        String subject = "one";
        String token = jwtHandler.createToken(encode, subject, 100L);
        String parseSubject = jwtHandler.extractSubject(encode, token);
        assertThat(parseSubject).isEqualTo(subject);
    }

    @Test
    void validate() {
        //given
        String encode = Base64.getEncoder().encodeToString("key".getBytes());
        String subject = "subject";
        String token = jwtHandler.createToken(encode, subject, 100L);
        //when
        boolean validate = jwtHandler.validate(encode, token);
        //then
        assertThat(validate).isTrue();

        //given
        String falseEncode = Base64.getEncoder().encodeToString("false".getBytes());
        String falseToken = jwtHandler.createToken(falseEncode, "false", 100L);
        //when
        boolean falseValidate = jwtHandler.validate(encode, falseToken);
        //then
        assertThat(falseValidate).isFalse();
    }
}