package com.ScuSoftware.Factorio.dao;

import com.ScuSoftware.Factorio.model.User;
import com.ScuSoftware.Factorio.model.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;
@Component
@Mapper
public interface UserMapper {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    long countByExample(UserExample example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from user",
        "where user_name = #{userName,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userName);

    @Insert({
        "insert into user (user_name, password, ",
        "email, enable, is_root, ",
        "nick_name, member_id, ",
        "summary)",
        "values (#{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{enable,jdbcType=BIT}, #{isRoot,jdbcType=BIT}, ",
        "#{nickName,jdbcType=VARCHAR}, #{memberId,jdbcType=INTEGER}, ",
        "#{summary,jdbcType=LONGVARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="enable", property="enable", jdbcType=JdbcType.BIT),
        @Result(column="is_root", property="isRoot", jdbcType=JdbcType.BIT),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER),
        @Result(column="summary", property="summary", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<User> selectByExampleWithBLOBs(UserExample example);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="enable", property="enable", jdbcType=JdbcType.BIT),
        @Result(column="is_root", property="isRoot", jdbcType=JdbcType.BIT),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "user_name, password, email, enable, is_root, nick_name, member_id, summary",
        "from user",
        "where user_name = #{userName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="enable", property="enable", jdbcType=JdbcType.BIT),
        @Result(column="is_root", property="isRoot", jdbcType=JdbcType.BIT),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="member_id", property="memberId", jdbcType=JdbcType.INTEGER),
        @Result(column="summary", property="summary", jdbcType=JdbcType.LONGVARCHAR)
    })
    User selectByPrimaryKey(String userName);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set password = #{password,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "enable = #{enable,jdbcType=BIT},",
          "is_root = #{isRoot,jdbcType=BIT},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "member_id = #{memberId,jdbcType=INTEGER},",
          "summary = #{summary,jdbcType=LONGVARCHAR}",
        "where user_name = #{userName,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(User record);

    @Update({
        "update user",
        "set password = #{password,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "enable = #{enable,jdbcType=BIT},",
          "is_root = #{isRoot,jdbcType=BIT},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "member_id = #{memberId,jdbcType=INTEGER}",
        "where user_name = #{userName,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}