package demo.PoemWithMe.auth;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

class SecurityConfigurationTest {
    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    String password = "key";
    @Test
    void passwordEncoder() {

        String encode = passwordEncoder.encode(password);
        assertThat(encode).contains("bcrypt");
    }

    @Test
    void matchTest(){
        //given
        String encode = passwordEncoder.encode(password);
        //when
        boolean matches = passwordEncoder.matches(password, encode);
        //then
        assertThat(matches).isTrue();
    }
}