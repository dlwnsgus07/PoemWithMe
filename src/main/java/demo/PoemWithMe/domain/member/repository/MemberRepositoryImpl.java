package demo.PoemWithMe.domain.member.repository;

import demo.PoemWithMe.domain.member.Member;
import demo.PoemWithMe.domain.member.repository.mapper.MemberMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{
    private MemberMapper mapper;
    @Override
    public int save(Member member) {
        return mapper.save(member);
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
