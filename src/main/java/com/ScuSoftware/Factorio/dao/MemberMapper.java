package com.ScuSoftware.Factorio.dao;

import com.ScuSoftware.Factorio.model.Member;
import com.ScuSoftware.Factorio.model.MemberExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface MemberMapper {
    @SelectProvider(type=MemberSqlProvider.class, method="countByExample")
    long countByExample(MemberExample example);

    @DeleteProvider(type=MemberSqlProvider.class, method="deleteByExample")
    int deleteByExample(MemberExample example);

    @Delete({
        "delete from member",
        "where student_id = #{studentId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String studentId);

    @Insert({
        "insert into member (student_id, sex, ",
        "name)",
        "values (#{studentId,jdbcType=VARCHAR}, #{sex,jdbcType=BIT}, ",
        "#{name,jdbcType=VARCHAR})"
    })
    int insert(Member record);

    @InsertProvider(type=MemberSqlProvider.class, method="insertSelective")
    int insertSelective(Member record);

    @SelectProvider(type=MemberSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="sex", property="sex", jdbcType=JdbcType.BIT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Member> selectByExample(MemberExample example);

    @Select({
        "select",
        "student_id, sex, name",
        "from member",
        "where student_id = #{studentId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="student_id", property="studentId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="sex", property="sex", jdbcType=JdbcType.BIT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    Member selectByPrimaryKey(String studentId);

    @UpdateProvider(type=MemberSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Member record, @Param("example") MemberExample example);

    @UpdateProvider(type=MemberSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Member record, @Param("example") MemberExample example);

    @UpdateProvider(type=MemberSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Member record);

    @Update({
        "update member",
        "set sex = #{sex,jdbcType=BIT},",
          "name = #{name,jdbcType=VARCHAR}",
        "where student_id = #{studentId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Member record);
}