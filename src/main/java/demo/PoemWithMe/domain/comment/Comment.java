package demo.PoemWithMe.domain.comment;

import lombok.Data;

@Data
public class Comment {
    Long memberId;
    Long poemId;
    String content;
    int recommend;

}
