package com.ScuSoftware.Factorio.dao;

import com.ScuSoftware.Factorio.model.Comments;
import com.ScuSoftware.Factorio.model.CommentsExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CommentsMapper {
    @SelectProvider(type=CommentsSqlProvider.class, method="countByExample")
    long countByExample(CommentsExample example);

    @DeleteProvider(type=CommentsSqlProvider.class, method="deleteByExample")
    int deleteByExample(CommentsExample example);

    @Delete({
        "delete from comments",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into comments (id, comments_date, ",
        "user_id, title, content)",
        "values (#{id,jdbcType=INTEGER}, #{commentsDate,jdbcType=DATE}, ",
        "#{userId,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Comments record);

    @InsertProvider(type=CommentsSqlProvider.class, method="insertSelective")
    int insertSelective(Comments record);

    @SelectProvider(type=CommentsSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="comments_date", property="commentsDate", jdbcType=JdbcType.DATE),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Comments> selectByExampleWithBLOBs(CommentsExample example);

    @SelectProvider(type=CommentsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="comments_date", property="commentsDate", jdbcType=JdbcType.DATE),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR)
    })
    List<Comments> selectByExample(CommentsExample example);

    @Select({
        "select",
        "id, comments_date, user_id, title, content",
        "from comments",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="comments_date", property="commentsDate", jdbcType=JdbcType.DATE),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    Comments selectByPrimaryKey(Integer id);

    @UpdateProvider(type=CommentsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Comments record, @Param("example") CommentsExample example);

    @UpdateProvider(type=CommentsSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Comments record, @Param("example") CommentsExample example);

    @UpdateProvider(type=CommentsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Comments record, @Param("example") CommentsExample example);

    @UpdateProvider(type=CommentsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Comments record);

    @Update({
        "update comments",
        "set comments_date = #{commentsDate,jdbcType=DATE},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Comments record);

    @Update({
        "update comments",
        "set comments_date = #{commentsDate,jdbcType=DATE},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Comments record);
}