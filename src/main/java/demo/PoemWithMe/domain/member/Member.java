package demo.PoemWithMe.domain.member;

import demo.PoemWithMe.domain.comment.Comment;
import demo.PoemWithMe.domain.poem.Poem;
import lombok.Data;

import java.util.List;

@Data
public class Member {
    private Long id;
    private String name;
    private String password;
    private String nickName;
    private List<Poem> likePoemList;
    private List<Comment> comments;
}
