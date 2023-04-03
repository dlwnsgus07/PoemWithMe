package demo.PoemWithMe.domain.member.service;

import demo.PoemWithMe.domain.member.Member;

public interface MemberService {
    public Long save(Member member);

    public void deleteById(Long id);

    public void updatePassword(Long id, String password);

    public void updateNickName(Long id, String nickName);

    public void updatePasswordAndNickName(Long id, String password, String nickName);

    public Member findById(Long id);
}
