package demo.PoemWithMe.domain.poem;

import demo.PoemWithMe.domain.poem.position.Position;
import demo.PoemWithMe.domain.poem.position.Sort;
import lombok.Data;

@Data
public class Content {
    private String content;
    private Position position;
    private Sort sort;
}
