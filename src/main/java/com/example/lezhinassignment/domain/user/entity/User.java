package com.example.lezhinassignment.domain.user.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String userEmail;

    private String password;

    private String gender;

    private String type;

    private LocalDateTime visitTime;

    public void updateVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

}
