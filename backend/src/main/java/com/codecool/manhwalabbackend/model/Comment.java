package com.codecool.manhwalabbackend.model;

import com.codecool.manhwalabbackend.model.enums.CommentType;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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
    @ManyToOne(cascade = CascadeType.ALL)
    private UserProfile parentUserProfile;
    private Timestamp commentedAt;
    @Enumerated(EnumType.STRING)
    private CommentType commentType;
    private Long parentCommentId;
    private Integer likes;
    private Integer dislikes;
    @ManyToOne(cascade = CascadeType.ALL)
    private ComicProfile parentComic;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<UserProfile> usersWhoLiked;
}
