package com.example.lezhinassignment.domain.work.repository;

import com.example.lezhinassignment.domain.work.entity.Work;

import java.util.List;

public interface CustomWorkRepository {
    List<Work> findByLikes();
    List<Work> findByDisLikes();
}
