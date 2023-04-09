package demo.PoemWithMe.domain.member.controller;

import demo.PoemWithMe.domain.member.dto.JwtLoginRequestDto;
import demo.PoemWithMe.domain.member.dto.MemberSignupRequestDto;
import demo.PoemWithMe.domain.member.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody @Valid JwtLoginRequestDto request) {
        try {
            return authService.login(request);
        } catch (Exception e) {
            return "로그인에 실패하였습니다.";
        }
    }

    @PostMapping(value = "signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public String signup(@RequestBody @Valid MemberSignupRequestDto request) {
        return authService.signup(request);
    }
}
