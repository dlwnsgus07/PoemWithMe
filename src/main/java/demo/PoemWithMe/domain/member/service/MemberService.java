package demo.PoemWithMe.domain.member.service;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.domain.member.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepositoryImpl memberRepositoryImpl;
    public List<Member> findAll(){
         return memberRepositoryImpl.findAll();
    }
    public Member findById(Long id){
        return memberRepositoryImpl.findById(id);
    }
}
