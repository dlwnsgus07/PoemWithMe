package demo.PoemWithMe.domain.member.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class JwtLoginRequestDto {
    @NotBlank
    private String loginId;
    @NotBlank
    private String password;
}
