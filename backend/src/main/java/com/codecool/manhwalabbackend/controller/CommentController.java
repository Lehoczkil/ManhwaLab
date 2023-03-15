package com.codecool.manhwalabbackend.controller;

import com.codecool.manhwalabbackend.model.Comment;
import com.codecool.manhwalabbackend.service.CommentService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping(value = "/add-comment/{comicId}")
    public void addNewComment(@PathVariable Long comicId){
    }

    @PatchMapping(value = "/edit-comment/{comicId}")
    public void editComment(@PathVariable Long comicId){

    }

    @DeleteMapping(value = "/delete-comment/{comicId}")
    public void deleteComment(@PathVariable Long comicId){

    }

    //TODO: Like, dislike, reply
}
