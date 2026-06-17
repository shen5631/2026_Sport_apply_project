package com.example.sport_apply.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sport_table")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sportId;

    private String sportName;
    private int maxMember;

    // Getter
    public int getSportId() { return sportId; }
    public String getSportName() { return sportName; }
    public int getMaxMember() { return maxMember; }

    // Setter (POST로 들어온 데이터를 채울 때 필요)
    public void setSportName(String sportName) { this.sportName = sportName; }
    public void setMaxMember(int maxMember) { this.maxMember = maxMember; }
}