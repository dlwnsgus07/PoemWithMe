package demo.PoemWithMe.domain.poem;


import lombok.Data;

@Data
public class Poem {
    private final Long memberId;
    private final Long poemId;
    private Writer writer;
    private Title title;
    private Content content;
    private int recommend;
    private BackgroundImg backgroundImg;
}
