package demo.PoemWithMe.domain.member.service;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.domain.member.dto.JwtLoginRequestDto;
import demo.PoemWithMe.domain.member.dto.MemberSignupRequestDto;
import demo.PoemWithMe.domain.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public String login(JwtLoginRequestDto request){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLoginId(), request.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        return principal.getUsername();
    }

    public String signup(MemberSignupRequestDto request) throws IllegalArgumentException {
        Member member = new Member(request);
        Optional<Member> checkId = memberRepository.findByName(member.getName());
        if (checkId.isPresent()){
            throw new IllegalArgumentException("이미 존재하는 아이디 입니다.");
        }
        member.encodePassword(passwordEncoder);
        memberRepository.save(member);
        return member.getName();
    }
}
