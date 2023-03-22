package demo.PoemWithMe.repository;

import demo.PoemWithMe.database.MemberMapper;
import demo.PoemWithMe.domain.member.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MemberRepository {
    private MemberMapper mapper;

    public List<Member> findAll(){
        return mapper.findAll();
    }
}
