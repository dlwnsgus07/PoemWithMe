package demo.PoemWithMe.domain.member;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
@AllArgsConstructor
public class Member {
    private Long id;
    private String name;
    private String password;
    @Email
    private String email;
    private String nickName;
    private ROLE role;
//    private List<Poem> likePoemList;
//    private List<Comment> comments;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    public void updatePassword(PasswordEncoder passwordEncoder, String password) {
        this.password = passwordEncoder.encode(password);
    }

    public void updateNickName(String nickName) {
        this.nickName = nickName;
    }
}
