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
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (id, username, ",
        "brithday, entry_date, job, ",
        "salary, image, resume)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=CHAR}, ",
        "#{brithday,jdbcType=DATE}, #{entryDate,jdbcType=DATE}, #{job,jdbcType=CHAR}, ",
        "#{salary,jdbcType=DOUBLE}, #{image,jdbcType=CHAR}, #{resume,jdbcType=LONGVARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.CHAR),
        @Result(column="brithday", property="brithday", jdbcType=JdbcType.DATE),
        @Result(column="entry_date", property="entryDate", jdbcType=JdbcType.DATE),
        @Result(column="job", property="job", jdbcType=JdbcType.CHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.DOUBLE),
        @Result(column="image", property="image", jdbcType=JdbcType.CHAR),
        @Result(column="resume", property="resume", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<User> selectByExampleWithBLOBs(UserExample example);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.CHAR),
        @Result(column="brithday", property="brithday", jdbcType=JdbcType.DATE),
        @Result(column="entry_date", property="entryDate", jdbcType=JdbcType.DATE),
        @Result(column="job", property="job", jdbcType=JdbcType.CHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.DOUBLE),
        @Result(column="image", property="image", jdbcType=JdbcType.CHAR)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, username, brithday, entry_date, job, salary, image, resume",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.CHAR),
        @Result(column="brithday", property="brithday", jdbcType=JdbcType.DATE),
        @Result(column="entry_date", property="entryDate", jdbcType=JdbcType.DATE),
        @Result(column="job", property="job", jdbcType=JdbcType.CHAR),
        @Result(column="salary", property="salary", jdbcType=JdbcType.DOUBLE),
        @Result(column="image", property="image", jdbcType=JdbcType.CHAR),
        @Result(column="resume", property="resume", jdbcType=JdbcType.LONGVARCHAR)
    })
    User selectByPrimaryKey(Integer id);

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
        "set username = #{username,jdbcType=CHAR},",
          "brithday = #{brithday,jdbcType=DATE},",
          "entry_date = #{entryDate,jdbcType=DATE},",
          "job = #{job,jdbcType=CHAR},",
          "salary = #{salary,jdbcType=DOUBLE},",
          "image = #{image,jdbcType=CHAR},",
          "resume = #{resume,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(User record);

    @Update({
        "update user",
        "set username = #{username,jdbcType=CHAR},",
          "brithday = #{brithday,jdbcType=DATE},",
          "entry_date = #{entryDate,jdbcType=DATE},",
          "job = #{job,jdbcType=CHAR},",
          "salary = #{salary,jdbcType=DOUBLE},",
          "image = #{image,jdbcType=CHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}