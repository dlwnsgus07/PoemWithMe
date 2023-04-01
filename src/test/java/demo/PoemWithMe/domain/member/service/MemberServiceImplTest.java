package demo.PoemWithMe.domain.member.service;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.domain.member.ROLE;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceImplTest {
    public final MemberService memberService;

    @Autowired
    public MemberServiceImplTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @Test
    void save() {
        //given
        Member member = new Member("junHyeon1", "rdwg", "dlwnsgus08@naver.com", "John1", ROLE.ADMIN);
        //when
        Long id = memberService.save(member);
        //then
        assertThat(member.getId()).isEqualTo(id);
        memberService.deleteById(id);
    }

    @Test
    void saveDuplicate() {
        //given
        Member member = new Member("junHyeon", "rdwg", "dlwnsgus08@naver.com", "John1", ROLE.ADMIN);
        Member memberDup = new Member("junHyeon", "rdwg", "dlwnsgus08@naver.com", "John1", ROLE.ADMIN);
        //when
        Long id = memberService.save(member);
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> memberService.save(memberDup));
        memberService.deleteById(id);
    }

    @Test
    void deleteById() {
        memberService.deleteById(25L);
    }

    @Test
    void updatePassword() {
    }

    @Test
    void updateNickName() {
    }

    @Test
    void updatePasswordAndNickName() {
    }

    @Test
    void findById() {
    }
}