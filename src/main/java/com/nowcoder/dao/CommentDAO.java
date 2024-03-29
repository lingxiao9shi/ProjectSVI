package com.nowcoder.dao;


import com.nowcoder.model.Comment;
import com.nowcoder.model.News;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentDAO {
    String TABLE_NAME = "comment";
    String INSERT_FIELDS = " user_id, content, created_date, entity_id, entity_type, status ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{userId},#{content},#{createdDate},#{entityId},#{entityType},#{status})"})
    int addComment(Comment comment);


    @Select({"select ", SELECT_FIELDS , " from ", TABLE_NAME, " where entity_id=#{entityId} and entity_type =#{entityType} order by id desc" })
    List<Comment> selectBtEntity(@Param("entityId") int entityId, @Param("entityType") int entityType);


    @Select({"select count(id) from ",TABLE_NAME, " where entity_id=#{entityId} and entity_type =#{entityType} order by id desc"})
    int getCommentCount(@Param("entityId") int entityId, @Param("entityType") int entityType);

    //用来删除评论(实际上是改变评论)
    //在service中要写delete;
    @Update({"update ", TABLE_NAME, " set status=#{status} where entity_id=#{entityId} and entity_type =#{entityType}"})
    void updateStatus(@Param("entityId") int entityId, @Param("entityType") int entityType,@Param("status") int status);
}
