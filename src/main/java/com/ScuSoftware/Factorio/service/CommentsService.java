package com.ScuSoftware.Factorio.service;


import com.ScuSoftware.Factorio.model.Comments;

import java.util.List;

public interface CommentsService {

    int insertComment(Comments comment);

    List<Comments> getAllComments();

    Comments getCommentsByID(int id);


}
