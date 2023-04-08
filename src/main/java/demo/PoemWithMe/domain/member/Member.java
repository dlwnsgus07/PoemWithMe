package demo.PoemWithMe.domain.member;

import demo.PoemWithMe.domain.member.dto.MemberSignupRequestDto;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@RequiredArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String password;
    @Email
    private String email;
    private String nickName;
    private Role role;


    public Member(MemberSignupRequestDto memberSignupRequestDto) {
        this.name = memberSignupRequestDto.getName();
        this.password = memberSignupRequestDto.getPassword();
        this.email = memberSignupRequestDto.getEmail();
        this.nickName = memberSignupRequestDto.getNickName();
        this.role = memberSignupRequestDto.getRole();
    }

    public Member(Long id, String name, String password, String email, String nickName, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.nickName = nickName;
        this.role = role;
    }

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    public void updatePassword(PasswordEncoder passwordEncoder, String password) {
        this.password = passwordEncoder.encode(password);
    }

    public void updateNickName(String nickName) {
        this.nickName = nickName;
    }
    public Role getRole(){
        return role;
    }
}
