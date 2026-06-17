package com.example.sport_apply.entity;

public class Sport {

    private int sportId;
    private String sportName;
    private int category; // 카테고리 (1=축구, 2=농구 등)
    private int maxMember;

    public int getSportId() { return sportId; }
    public String getSportName() { return sportName; }
    public int getCategory() { return category; }
    public int getMaxMember() { return maxMember; }

    public void setSportId(int sportId) { this.sportId = sportId; }
    public void setSportName(String sportName) { this.sportName = sportName; }
    public void setCategory(int category) { this.category = category; }
    public void setMaxMember(int maxMember) { this.maxMember = maxMember; }
}