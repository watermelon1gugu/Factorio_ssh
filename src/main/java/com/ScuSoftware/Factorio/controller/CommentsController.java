package com.ScuSoftware.Factorio.controller;

import com.ScuSoftware.Factorio.dto.CommentsRequest;
import com.ScuSoftware.Factorio.dto.Response;
import com.ScuSoftware.Factorio.model.Comments;
import com.ScuSoftware.Factorio.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("comment/")
public class CommentsController {

    private final CommentsService commentsService;
    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping("comments")
    public Response listOfComments( HttpSession session){
        return new Response(200,commentsService.getAllComments());
    }

    @PostMapping("comments")
    public Response postComment(@RequestBody CommentsRequest commentsRequest,HttpSession session){
        Comments comments = commentsRequest.formatToComments();
        if(commentsService.insertComment(comments)!=0){
            return new Response(200,"发表成功");
        }else return new Response(500,"发表失败");
    }
}
