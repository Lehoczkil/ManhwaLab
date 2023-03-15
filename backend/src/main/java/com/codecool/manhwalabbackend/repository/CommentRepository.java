package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {


    List<Comment> getCommentsByParentComicId(Long comicId);


}
