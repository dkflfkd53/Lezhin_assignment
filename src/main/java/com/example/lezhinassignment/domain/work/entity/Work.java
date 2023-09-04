package com.example.lezhinassignment.domain.work.entity;

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

    @NotNull
    private String title;

    @NotNull
    private WorkType workType;

    @NotNull
    private Long price;

    @ManyToMany
    private List<Like> likes;

    @ManyToMany
    private List<DisLike> disLikes;

    @ManyToMany
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

}
