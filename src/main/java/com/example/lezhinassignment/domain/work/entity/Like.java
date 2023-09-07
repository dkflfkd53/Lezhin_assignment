package com.example.lezhinassignment.domain.work.entity;

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

    private Long userId;

    private Long workId;

}
