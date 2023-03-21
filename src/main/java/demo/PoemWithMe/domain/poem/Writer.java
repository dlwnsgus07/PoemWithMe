package demo.PoemWithMe.domain.poem;

import demo.PoemWithMe.domain.poem.position.Position;
import demo.PoemWithMe.domain.poem.position.Sort;
import lombok.Data;

@Data
public class Writer {
    private String writer;
    private Position position;
    private Sort sort;
}
