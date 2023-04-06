package demo.PoemWithMe.domain.member;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    WRITER(1, "WRITER"), PUBLISHER(2, "PUBLISHER"), VIP(3, "VIP"), ADMIN(4, "ADMIN");
    private final int key;
    private final String title;
}