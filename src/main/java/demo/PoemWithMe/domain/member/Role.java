package demo.PoemWithMe.domain.member;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Role {
    WRITER(1, "WRITER"), PUBLISHER(2, "PUBLISHER"), VIP(3, "VIP"), ADMIN(4, "ADMIN");
    private final int key;
    @JsonValue
    private final String title;

    @JsonCreator
    public static Role titleToRole(String role) {
        return Arrays.stream(Role.values()).filter((r) -> r.getTitle().equals(role)).findFirst().orElseThrow(() -> new IllegalArgumentException("허용되지 않는 역할입니다."));
    }
}