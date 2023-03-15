package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.model.Comment;
import com.codecool.manhwalabbackend.model.enums.CommentType;
import com.codecool.manhwalabbackend.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;
    private final ComicProfileService comicProfileService;
    private final UserProfileService userProfileService;

    public List<Comment> getComicComments(Long comicId){
     return commentRepository.getCommentsByParentComicId(comicId);
    }

    public void addNewComment(Long comicId, String comment, String username){
        commentRepository.save(newCommentBuilder(comicId, comment, username));
    }

    private Comment newCommentBuilder(Long comicId, String commentText, String username){
        return new Comment(
                comicId, commentText, userProfileService.getUser(username),
                null, CommentType.COMMENT, null,
                0, 0, comicProfileService.getComicProfileById(comicId));
    }

}

