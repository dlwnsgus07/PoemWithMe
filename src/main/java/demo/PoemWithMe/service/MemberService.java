package demo.PoemWithMe.service;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public List<Member> findAll(){
         return memberRepository.findAll();
    }
}
