package demo.PoemWithMe.domain.member.repository;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.domain.member.repository.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

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

    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(mapper.findById(id));
    }
}
