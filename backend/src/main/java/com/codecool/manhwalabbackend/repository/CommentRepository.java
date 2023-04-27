package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM comment WHERE parent_comic_id=?1 AND comment_type='COMMENT'", nativeQuery = true)
    List<Comment> getCommentsByParentComicId(Long comicId);

    @Query(value = "SELECT * FROM comment WHERE parent_comment_id=?1 AND comment_type='REPLY'", nativeQuery = true)
    List<Comment> getRepliesByComment(Long commentId);

    @Modifying
    @Query(value = "DELETE FROM comment WHERE id =?1", nativeQuery = true)
    void deleteCommentById(Long commentId);

    @Modifying
    @Query(value = "UPDATE comment SET text=?2 WHERE id=?1", nativeQuery = true)
    void updateComment(Long commentId, String text);

    @Modifying
    @Query(value = "UPDATE comment SET likes=likes+1 WHERE id=?1", nativeQuery = true)
    void increaseLikeCount(Long commentId);

    @Modifying
    @Query(value = "UPDATE comment SET dislikes=dislikes+1 WHERE id=?1", nativeQuery = true)
    void increaseDislikeCount(Long commentId);

    @Modifying
    @Query(value = "UPDATE comment SET likes=likes-1 WHERE id=?1", nativeQuery = true)
    void decreaseLikeCount(Long commentId);

    @Modifying
    @Query(value = "UPDATE comment SET dislikes=dislikes-1 WHERE id=?1", nativeQuery = true)
    void decreaseDislikeCount(Long commentId);
}
