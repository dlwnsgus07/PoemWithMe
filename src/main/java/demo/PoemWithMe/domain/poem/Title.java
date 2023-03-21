package demo.PoemWithMe.domain.poem;

import demo.PoemWithMe.domain.poem.position.Position;
import demo.PoemWithMe.domain.poem.position.Sort;
import lombok.Data;
import lombok.Getter;

@Data
public class Title {
    private String title;
    private Position position;
    private Sort sort;
}
