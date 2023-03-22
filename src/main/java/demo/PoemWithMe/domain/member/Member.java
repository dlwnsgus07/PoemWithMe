package demo.PoemWithMe.domain.member;

import demo.PoemWithMe.domain.comment.Comment;
import demo.PoemWithMe.domain.poem.Poem;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.List;

@Data
public class Member {
    private Long id;
    private String name;
    private String password;
    @Email
    private String email;
    private String nickName;
    private List<Poem> likePoemList;
    private ROLE role;
    private List<Comment> comments;
}
