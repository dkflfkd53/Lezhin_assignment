package com.example.lezhinassignment.domain.work.entity;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.work.enums.WorkType;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @NotNull
    private String title;

    @NotNull
    private WorkType workType;

    @NotNull
    private Long price;

    @OneToMany(mappedBy = "work")
    private List<Like> likes;

    @OneToMany(mappedBy = "work")
    private List<DisLike> disLikes;

    @OneToMany(mappedBy = "work")
    private List<Comment> comments;

    public void modifyPrice(Long price) {
        this.price = price;
    }

    public void addLike(Like like) {
        likes.add(like);
    }

    public void addDisLike(DisLike disLike) {
        disLikes.add(disLike);
    }

    public void writeComment(Comment comment) {
        comments.add(comment);
    }

    public void removeLike(Like like) {
        likes.remove(like);
    }

    public void removeDisLike(DisLike disLike) {
        disLikes.remove(disLike);
    }

    public void deleteComment(Comment comment) {
        comments.remove(comment);
    }

}
