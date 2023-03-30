package demo.PoemWithMe.domain.member.service;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public int save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public void updatePassword(Long id, String password) {
        Optional<Member> result = memberRepository.findById(id);
        if(result.isEmpty()){
            throw new NoSuchElementException("존재하지 않는 사용자 입니다.");
        }
        else{
            Member member = result.get();
            member.updatePassword(passwordEncoder, password);
            memberRepository.updatePassword(member);
        }
    }

    @Override
    public void updateNickName(Long id, String nickName) {
        Optional<Member> result = memberRepository.findById(id);
        if (result.isEmpty()) {
            throw new NoSuchElementException("존재하지 않는 사용자 입니다.");
        }
        else{
            Member member = result.get();
            member.updateNickName(nickName);
            memberRepository.updateNickName(member);
        }
    }

    @Override
    public void updatePasswordAndNickName(Long id, String password, String nickName) {
        Optional<Member> result = memberRepository.findById(id);
        if (result.isEmpty()) {
            throw new NoSuchElementException("존재하지 않는 사용자 입니다.");
        }
        else{
            Member member = result.get();
            member.updatePassword(passwordEncoder, password);
            member.updateNickName(nickName);
            memberRepository.updatePasswordAndNickName(member);
        }
    }

    public Optional<Member> findById(Long id){
        Optional<Member> result = memberRepository.findById(id);
        if (result.isEmpty()) {
            throw new NoSuchElementException("존재하지 않는 사용자 입니다.");
        }
        return result;
    }
}
