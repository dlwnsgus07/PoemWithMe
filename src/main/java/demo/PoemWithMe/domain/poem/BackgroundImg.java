package demo.PoemWithMe.domain.poem;

import lombok.Data;

@Data
public class BackgroundImg {
    private String path;
    private float opacity;
    private float blur;
    private int start_x;
    private int end_x;
    private int start_y;
    private int end_y;
}
