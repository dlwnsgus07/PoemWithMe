package demo.PoemWithMe.domain.member.repository;

import demo.PoemWithMe.domain.member.repository.mapper.MemberMapper;
import demo.PoemWithMe.domain.member.Member;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{
    private MemberMapper mapper;
    @Override
    public Member save(Member member) {
        return null;
    }

    @Override
    public boolean deleteById(String loginId) {
        return false;
    }

    @Override
    public Member updateNickName(String nickName) {
        return null;
    }

    @Override
    public Member updatePassword(String password) {
        return null;
    }

    @Override
    public Optional<Member> findById(String loginId) {
        return Optional.empty();
    }

    public List<Member> findAll(){
        return mapper.findAll();
    }

    public Member findById(Long id) {
        return mapper.findById(id);
    }
}
