package com.ScuSoftware.Factorio.dao;

import com.ScuSoftware.Factorio.model.Announce;
import com.ScuSoftware.Factorio.model.AnnounceExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface AnnounceMapper {
    @SelectProvider(type=AnnounceSqlProvider.class, method="countByExample")
    long countByExample(AnnounceExample example);

    @DeleteProvider(type=AnnounceSqlProvider.class, method="deleteByExample")
    int deleteByExample(AnnounceExample example);

    @Delete({
        "delete from announce",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into announce (id, title, ",
        "release_date, enabled, content)",
        "values (#{id,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{releaseDate,jdbcType=DATE}, #{enabled,jdbcType=BIT}, #{content,jdbcType=LONGVARCHAR})"
    })
    int insert(Announce record);

    @InsertProvider(type=AnnounceSqlProvider.class, method="insertSelective")
    int insertSelective(Announce record);

    @SelectProvider(type=AnnounceSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="release_date", property="releaseDate", jdbcType=JdbcType.DATE),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Announce> selectByExampleWithBLOBs(AnnounceExample example);

    @SelectProvider(type=AnnounceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="release_date", property="releaseDate", jdbcType=JdbcType.DATE),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT)
    })
    List<Announce> selectByExample(AnnounceExample example);

    @Select({
        "select",
        "id, title, release_date, enabled, content",
        "from announce",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="release_date", property="releaseDate", jdbcType=JdbcType.DATE),
        @Result(column="enabled", property="enabled", jdbcType=JdbcType.BIT),
        @Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    })
    Announce selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AnnounceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Announce record, @Param("example") AnnounceExample example);

    @UpdateProvider(type=AnnounceSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Announce record, @Param("example") AnnounceExample example);

    @UpdateProvider(type=AnnounceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Announce record, @Param("example") AnnounceExample example);

    @UpdateProvider(type=AnnounceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Announce record);

    @Update({
        "update announce",
        "set title = #{title,jdbcType=VARCHAR},",
          "release_date = #{releaseDate,jdbcType=DATE},",
          "enabled = #{enabled,jdbcType=BIT},",
          "content = #{content,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Announce record);

    @Update({
        "update announce",
        "set title = #{title,jdbcType=VARCHAR},",
          "release_date = #{releaseDate,jdbcType=DATE},",
          "enabled = #{enabled,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Announce record);
}