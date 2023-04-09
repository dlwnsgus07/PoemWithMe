package demo.PoemWithMe.global.mapper;

import demo.PoemWithMe.domain.member.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {
    @Insert("INSERT INTO MEMBER " +
            "(name, password, nickname, email, role) " +
            "VALUES(#{member.name}, #{member.password}, #{member.nickName}," +
            "#{member.email}, #{member.role})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void save(@Param("member") Member member);

    @Select("SELECT * FROM MEMBER")
    List<Member> findAll();

    //    name, password, nickname, email, role
    @Select("SELECT id, name, password, nickname, email, role FROM MEMBER WHERE id = #{id}")
    Optional<Member> findById(@Param("id") Long id);

    @Delete("DELETE FROM MEMBER WHERE id = #{id}")
    void deleteById(@Param("id") Long id);

    @Update("UPDATE MEMBER SET PASSWORD = #{password}, NICKNAME = #{nickName} where id = #{id}")
    void updatePasswordAndNickName(Member member);

    @Update("UPDATE MEMBER SET PASSWORD = #{password} WHERE ID = #{id}")
    void updatePassword(Member member);

    @Update("UPDATE MEMBER SET NICKNAME = #{nickName} where id = #{id}")
    void updateNickName(Member member);

    @Select("SELECT id, name, password, nickname, email, role FROM MEMBER WHERE NAME=#{name}")
    Optional<Member> findByName(String name);
}
