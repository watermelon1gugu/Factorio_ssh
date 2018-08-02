package com.ScuSoftware.Factorio.service.Impl;

import com.ScuSoftware.Factorio.dao.CommentsMapper;
import com.ScuSoftware.Factorio.model.Comments;
import com.ScuSoftware.Factorio.model.CommentsExample;
import com.ScuSoftware.Factorio.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentsServiceImpl implements CommentsService {
    private final CommentsMapper commentsMapper;
    @Autowired
    public CommentsServiceImpl(CommentsMapper commentsMapper){
        this.commentsMapper = commentsMapper;
    }
    @Override
    public int insertComment(Comments comment) {
        try {
            return commentsMapper.insert(comment);
        }catch (Exception e){
            return 0;
        }

    }

    @Override
    public List<Comments> getAllComments() {
        return commentsMapper.selectByExampleWithBLOBs(new CommentsExample());
    }

    @Override
    public Comments getCommentsByID(int id) {
        return commentsMapper.selectByPrimaryKey(id);
    }

}
