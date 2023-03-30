package demo.PoemWithMe.domain.member.service;

import demo.PoemWithMe.domain.member.Member;

import java.util.Optional;

public interface MemberService {
    public int save(Member member);

    public void deleteById(Long id);

    public void updatePassword(Long id, String password);

    public void updateNickName(Long id, String nickName);

    public void updatePasswordAndNickName(Long id, String password, String nickName);

    public Optional<Member> findById(Long id);
}
