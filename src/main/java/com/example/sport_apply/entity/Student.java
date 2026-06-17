package com.example.sport_apply.entity;

public class Student {

    private int studentId;
    private String name;
    private String stdNum;
    private String gender;
    private int grade;
    private int classNum;
    private int num;

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getStdNum() { return stdNum; }
    public String getGender() { return gender; }
    public int getGrade() { return grade; }
    public int getClassNum() { return classNum; }
    public int getNum() { return num; }

    public void setStudentId(int studentId) { this.studentId = studentId; }
    public void setName(String name) { this.name = name; }
    public void setStdNum(String stdNum) { this.stdNum = stdNum; }
    public void setGender(String gender) { this.gender = gender; }
    public void setGrade(int grade) { this.grade = grade; }
    public void setClassNum(int classNum) { this.classNum = classNum; }
    public void setNum(int num) { this.num = num; }
}