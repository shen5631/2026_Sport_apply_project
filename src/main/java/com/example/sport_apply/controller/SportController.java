package com.example.sport_apply.controller;

import com.example.sport_apply.entity.Sport;
import com.example.sport_apply.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/sports")
public class SportController {

    @Autowired
    private SportRepository sportRepository;

    // 종목 전체 조회
    @GetMapping
    public List<Sport> getAllSports() {
        return sportRepository.findAll();
    }

    // 종목 추가
    @PostMapping
    public Sport addSport(@RequestBody Sport sport) {
        return sportRepository.save(sport);
    }
}