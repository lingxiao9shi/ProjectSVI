package com.nowcoder.service;


import com.nowcoder.dao.CommentDAO;
import com.nowcoder.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;

    public List<Comment> getCommentsByEntity(int entityId,int entityType){
        return commentDAO.selectBtEntity(entityId,entityType);
    }


    public int addComment(Comment comment){
        return commentDAO.addComment(comment);
    }

    public int getCommentCount(int entityId,int entityType){
        return commentDAO.getCommentCount(entityId,entityType);
    }

    //删除信息,未完成.
    public void deleteComment(int entityId, int entityType){
        commentDAO.updateStatus(entityId,entityType,1);
    }
}
