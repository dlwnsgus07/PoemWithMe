package demo.PoemWithMe.database;

import demo.PoemWithMe.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("SELECT * FROM MEMBER")
    List<Member> findAll();
}
