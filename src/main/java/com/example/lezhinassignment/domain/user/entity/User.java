package com.example.lezhinassignment.domain.user.entity;

import com.example.lezhinassignment.domain.work.entity.Work;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String userEmail;

    @NotNull
    private String password;

    @NotNull
    private String gender;

    @NotNull
    private String type;

    private LocalDateTime visitTime;

    @OneToMany
    private List<Work> AdultWork;

    public void updateVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

    public void addAdultWork(Work work) {
        AdultWork.add(work);
    }

}
