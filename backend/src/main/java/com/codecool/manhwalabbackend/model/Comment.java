package com.codecool.manhwalabbackend.model;

import com.codecool.manhwalabbackend.model.Enums.CommentType;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String text;
    private String userId;
    private Timestamp commentedAt;
    @Enumerated(EnumType.STRING)
    private CommentType commentType;
    private Long parentCommentId;
    private Integer likes;
    private Integer dislikes;

}
