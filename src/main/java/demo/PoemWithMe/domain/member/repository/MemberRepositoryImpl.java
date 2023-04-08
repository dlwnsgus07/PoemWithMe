package demo.PoemWithMe.domain.member.repository;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.global.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
    private MemberMapper mapper;

    @Override
    public Long save(Member member) {
        try {
            mapper.save(member);
        }
        catch (DuplicateKeyException e){
            throw new IllegalStateException("중복된 회원정보를 입력하셨습니다.");
        }
        return member.getId();
    }

    @Override
    public void deleteById(Long id) {
        mapper.deleteById(id);
    }

    @Override
    public void updatePassword(Member member) {
        mapper.updatePassword(member);
    }

    @Override
    public void updateNickName(Member member) {
        mapper.updateNickName(member);
    }

    @Override
    public void updatePasswordAndNickName(Member member) {
        mapper.updatePasswordAndNickName(member);
    }

    @Override
    public Member findById(Long id) {

        Optional<Member> result = mapper.findById(id);
        if (result.isEmpty()) {
            throw new NoSuchElementException("존재하지 않는 사용자 입니다.");
        }
        return result.get();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return mapper.findByName(name);
    }
}
