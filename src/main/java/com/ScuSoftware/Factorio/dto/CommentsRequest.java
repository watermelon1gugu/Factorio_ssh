package com.ScuSoftware.Factorio.dto;

import com.ScuSoftware.Factorio.model.Comments;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentsRequest {

    private String content;

    private int userID;

    public String getContent() {
        return content;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comments formatToComments() {
        Comments comments = new Comments();
        comments.setContent(this.content);
        comments.setUserId(this.userID);
        comments.setCommentsDate(new Date());
        return comments;
    }
}
