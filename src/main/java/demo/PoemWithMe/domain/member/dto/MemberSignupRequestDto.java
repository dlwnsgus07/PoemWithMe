package demo.PoemWithMe.domain.member.dto;

import demo.PoemWithMe.domain.member.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberSignupRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nickName;
    @NotNull
    private Role role;
}
