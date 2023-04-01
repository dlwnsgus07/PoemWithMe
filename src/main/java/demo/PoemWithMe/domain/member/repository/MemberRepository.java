package demo.PoemWithMe.domain.member.repository;

import demo.PoemWithMe.domain.member.Member;

import java.util.Optional;

public interface MemberRepository {
    //회원 조회(아이디를 통해)
    //회원 삭제(회원 삭제)
    //회원 가입
    //회원 정보 변경
    //회원 가입
    public Long save(Member member);

    //회원 삭제
    public void deleteById(Long id);

    public void updatePassword(Member member);
    public void updateNickName(Member member);
    public void updatePasswordAndNickName(Member member);

    public Optional<Member> findById(Long id);
}
