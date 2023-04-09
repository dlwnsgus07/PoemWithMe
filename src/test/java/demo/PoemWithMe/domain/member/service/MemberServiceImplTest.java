package demo.PoemWithMe.domain.member.service;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.domain.member.Role;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceImplTest {
    public final MemberService memberService;
    public Member member;

    @Autowired
    public MemberServiceImplTest(MemberService memberService) {
        this.memberService = memberService;
    }

    @BeforeEach
    void makeMember() {
        this.member = new Member("junHyeon1", "rdwg", "dlwnsgus08@naver.com", "John1", Role.ADMIN);
    }

    @AfterEach
    void deleteMakeDB() {
        memberService.deleteById(member.getId());
    }

    @Test
    void save() {
        //given
        //when
        Long id = memberService.save(member);
        memberService.findById(id);
        //then
        assertThat(member.getId()).isEqualTo(id);
    }

    @Test
    void saveDuplicate() {
        //given
        Member memberDup = new Member("junHyeon", "rdwg", "dlwnsgus08@naver.com", "John1", Role.ADMIN);
        //when
        Long id = memberService.save(member);
        //then
        Assertions.assertThrows(IllegalStateException.class, () -> memberService.save(memberDup));
        memberService.deleteById(memberDup.getId());
    }

    @Test
    void deleteById() {
        memberService.deleteById(38L);
    }

    @Test
    void updatePassword() {
        Long id = memberService.save(member);
        String password = member.getPassword();
        memberService.updatePassword(id, "rdwg");
        Member findMember = memberService.findById(id);
        assertThat(password).isNotEqualTo(findMember.getPassword());
    }

    @Test
    void updateNickName() {
        Long id = memberService.save(member);
        String nickName = member.getNickName();
        memberService.updateNickName(id, "anotherNick");
        Member findMember = memberService.findById(id);
        assertThat(nickName).isNotEqualTo(findMember.getNickName());
        assertThat(findMember.getNickName()).isEqualTo("anotherNick");
    }

    @Test
    void updatePasswordAndNickName() {
        Long id = memberService.save(member);
        String nickName = member.getNickName();
        memberService.updatePasswordAndNickName(id, "qwerasdf", "newNickName");
        Member findMember = memberService.findById(id);
        assertThat(nickName).isNotEqualTo(findMember.getNickName());
        assertThat(nickName).isNotEqualTo(findMember.getNickName());
        assertThat(findMember.getNickName()).isEqualTo("newNickName");
        assertThat(member.getPassword()).isNotEqualTo(findMember.getPassword());
    }
}