package com.ScuSoftware.Factorio.service.Impl;

import com.ScuSoftware.Factorio.dao.CommentsMapper;
import com.ScuSoftware.Factorio.model.Comments;
import com.ScuSoftware.Factorio.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CommentsServiceImpl implements CommentsService {
    private final CommentsMapper commentsMapper;
    @Autowired
    public CommentsServiceImpl(CommentsMapper commentsMapper){
        this.commentsMapper = commentsMapper;
    }
    @Override
    public int insertComment(Comments comment) {
        return commentsMapper.insert(comment);
    }

    @Override
    public List<Comments> getAllComments() {
        return null;
    }

    @Override
    public List<Comments> getCommentsByTitle() {
        return null;
    }

    @Override
    public Comments getCommentsByID(int id) {
        return null;
    }

}
