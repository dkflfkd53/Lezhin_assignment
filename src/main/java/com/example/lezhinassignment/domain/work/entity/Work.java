package com.example.lezhinassignment.domain.work.entity;

import com.example.lezhinassignment.domain.work.enums.WorkType;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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

    public void modifyPrice(Long price) {
        this.price = price;
    }

}
