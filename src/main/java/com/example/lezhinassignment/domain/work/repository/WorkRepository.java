package com.example.lezhinassignment.domain.work.repository;

import com.example.lezhinassignment.domain.work.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkRepository extends JpaRepository<Work, Long>, CustomWorkRepository {


}
