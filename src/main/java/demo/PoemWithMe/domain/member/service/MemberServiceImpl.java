package demo.PoemWithMe.domain.member.service;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Long save(Member member) {
        member.encodePassword(passwordEncoder);
        return memberRepository.save(member);
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public void updatePassword(Long id, String password) {
        Member member = memberRepository.findById(id);
        member.updatePassword(passwordEncoder, password);
        memberRepository.updatePassword(member);
    }

    @Override
    public void updateNickName(Long id, String nickName) {
        Member member = memberRepository.findById(id);
        member.updateNickName(nickName);
        memberRepository.updateNickName(member);

    }

    @Override
    public void updatePasswordAndNickName(Long id, String password, String nickName) {
        Member member = memberRepository.findById(id);
        member.updatePassword(passwordEncoder, password);
        member.updateNickName(nickName);
        memberRepository.updatePasswordAndNickName(member);
    }


    public Member findById(Long id) {
        return memberRepository.findById(id);
    }
}
