package demo.PoemWithMe.domain.member.repository.mapper;

import demo.PoemWithMe.domain.member.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {
    @Select("INSERT INTO MEMBER " +
            "(name, password, nickname, email, role " +
            "VALUES(#{name}, #{password}, #{nickName}" +
            "#{email}, #{memberRole})")
    int save(Member member);

    @Select("SELECT * FROM MEMBER")
    List<Member> findAll();

    @Select("SELECT * FROM MEMBER WHERE name = #{id}")
    Member findById(@Param("id") Long id);

    @Delete("DELETE FROM MEMBER WHERE id = #{id}")
    void deleteById(@Param("id") Long id);

    @Update("UPDATE MEMBER SET PASSWORD = #{password}, NICKNAME = #{nickName} where id = #{id}")
    void updatePasswordAndNickName(Member member);

    @Update("UPDATE MEMBER SET PASSWORD = #{password} WHERE ID = #{id}")
    void updatePassword(Member member);

    @Update("UPDATE MEMBER SET NICKNAME = #{nickName} where id = #{id}")
    void updateNickName(Member member);

}
