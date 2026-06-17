package com.example.sport_apply.repository;

import com.example.sport_apply.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport, Integer> {
}