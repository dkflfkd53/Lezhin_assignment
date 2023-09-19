package com.example.lezhinassignment.domain.comment.entity;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.work.entity.Work;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "work_id")
    private Work work;

    private String content;

    public void modifyComment(String content) {
        this.content = content;
    }

}
