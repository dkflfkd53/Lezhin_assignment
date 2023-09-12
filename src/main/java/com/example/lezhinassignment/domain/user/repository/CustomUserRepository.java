package com.example.lezhinassignment.domain.user.repository;

import com.example.lezhinassignment.domain.user.entity.User;
import com.example.lezhinassignment.domain.work.entity.Visit;

import java.util.List;

public interface CustomUserRepository {
    List<User> getAdultUser();
}
