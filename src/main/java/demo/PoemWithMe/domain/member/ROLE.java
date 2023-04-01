package demo.PoemWithMe.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ROLE {
    WRITER("WRITER", 1), PUBLISHER("PUBLISHER", 2), VIP("VIP", 3), ADMIN("ADMIN", 4);
    private final String title;
    private final int key;
}