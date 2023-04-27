package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.Comment;
import com.codecool.manhwalabbackend.model.DTO.CommentDTO;
import com.codecool.manhwalabbackend.model.DTO.TitleDTO;
import com.codecool.manhwalabbackend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin({"http://localhost:8081", "https://manhwalab.onrender.com/"})
@RequestMapping("/api/manhwaLab")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping(value = "/comments/{comicId}")
    public List<Comment> getComicComments(@PathVariable Long comicId) {
        return commentService.getComicComments(comicId);
    }

    @GetMapping(value = "/replies/{commentId}")
    public List<Comment> getCommentReplies(@PathVariable Long commentId) {
        return commentService.getComicReplies(commentId);
    }

    @PostMapping(value = "/add-comment/{comicId}")
    public void addNewComment(@PathVariable Long comicId, @RequestBody TitleDTO comment){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        commentService.addNewComment(comicId, comment.getTitle(), username);
    }

    @PostMapping(value = "/add-reply/{comicId}")
    public void addNewReply(@PathVariable Long comicId,  @RequestBody CommentDTO comment){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        commentService.addNewReply(comicId, comment.getCommentId(), comment.getText(), username);
    }

    @PatchMapping(value = "/edit-comment/{comicId}")
    public void editComment(@PathVariable Long comicId, @RequestBody CommentDTO comment ){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        commentService.editComment(comicId, comment.getCommentId(), comment.getText(), username);
    }

    @DeleteMapping(value = "/delete-comment/{comicId}")
    public void deleteComment(@PathVariable Long comicId, @RequestBody TitleDTO comment){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        commentService.deleteComment(comicId, comment.getTitle(), username);
    }

    @PatchMapping(value = "/like/{commentId}")
    public void increaseLikeCount(@PathVariable Long commentId) {
        commentService.increaseLikeCount(commentId);
    }

    @PatchMapping(value = "/dislike/{commentId}")
    public void increaseDislikeCount(@PathVariable Long commentId) {
        commentService.increaseDislikeCount(commentId);
    }

    //TODO: Like, dislike, reply
}
