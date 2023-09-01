package com.example.lezhinassignment.domain.work.entity;

import com.example.lezhinassignment.domain.user.entity.User;
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

    @OneToMany
    private List<User> inquiryUser;

    public void plusUser(User user) {
        inquiryUser.add(user);
    }

}
