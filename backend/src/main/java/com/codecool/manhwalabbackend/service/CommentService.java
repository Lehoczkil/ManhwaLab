package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.model.Comment;
import com.codecool.manhwalabbackend.model.UserProfile;
import com.codecool.manhwalabbackend.model.enums.CommentType;
import com.codecool.manhwalabbackend.repository.ComicProfileRepository;
import com.codecool.manhwalabbackend.repository.CommentRepository;
import com.codecool.manhwalabbackend.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final CommentRepository commentRepository;
    private final ComicProfileRepository comicProfileRepository;
    private final UserProfileRepository userProfileRepository;
    private final ComicProfileService comicProfileService;
    private final UserProfileService userProfileService;

    public List<Comment> getComicComments(Long comicId){
     return commentRepository.getCommentsByParentComicId(comicId);
    }

    public List<Comment> getComicReplies(Long commentId){
        return commentRepository.getRepliesByComment(commentId);
    }

    public void addNewComment(Long comicId, String comment, String username){
        commentRepository.save(newCommentBuilder(comicId, comment, username));
    }

    public void addNewReply(Long comicId, Long commentId, String comment, String username) {
        commentRepository.save(newCommentBuilder(comicId, comment, username, commentId));
    }

    public void deleteComment(Long comicId, String comment, String username) {
        UserProfile userProfile = userProfileService.getUser(username);

        Long commentId = Long.valueOf(comment);
        Comment currentComment = commentRepository.getById(commentId);

        if (userProfile.getId().equals(currentComment.getParentUserProfile().getId())) {
            commentRepository.deleteCommentById(commentId);
        }
    }

    public void editComment(Long comicId, Long commentId, String text, String username) {
        UserProfile userProfile = userProfileService.getUser(username);
        Comment currentComment = commentRepository.getById(commentId);

        if (userProfile.getId().equals(currentComment.getParentUserProfile().getId())) {
            commentRepository.updateComment(commentId, text);
        }
    }

    public void increaseLikeCount(Long commentId) {
        //TODO do not increase if the user already likes the comment before
        commentRepository.increaseLikeCount(commentId);
    }

    public void increaseDislikeCount(Long commentId) {
        //TODO do not increase if the user already disliked the comment before
        commentRepository.increaseDislikeCount(commentId);
    }

    //TODO decrease likes if user dislikes, but already liked before, vica-versa

    private Comment newCommentBuilder(Long comicId, String commentText, String username) {
        return new Comment(
                comicId, commentText, userProfileService.getUser(username),
                null, CommentType.COMMENT, null,
                0, 0, comicProfileService.getComicProfileById(comicId));
    }

    private Comment newCommentBuilder(Long comicId, String commentText, String username, Long commentId) {
        return new Comment(
                comicId, commentText, userProfileService.getUser(username),
                null, CommentType.REPLY, commentId,
                0, 0, comicProfileService.getComicProfileById(comicId));
    }

}

