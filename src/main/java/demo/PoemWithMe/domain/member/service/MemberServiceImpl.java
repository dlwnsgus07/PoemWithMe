package demo.PoemWithMe.domain.member.service;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.domain.member.repository.MemberRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepositoryImpl memberRepositoryImpl;
    public Member findById(Long id){
        Optional<Member> member = memberRepositoryImpl.findById(id);
        if (member.isEmpty()){
            throw new NoSuchElementException("존재하지 않는 사용자 입니다.");
        }
        return member.get();
    }
}
