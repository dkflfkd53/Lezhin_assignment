package com.example.lezhinassignment.domain.work.entity;

import com.example.lezhinassignment.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity(name = "tbl_like")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "work_id")
    private Work work;

}
