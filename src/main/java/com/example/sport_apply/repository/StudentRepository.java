package com.example.sport_apply.repository;

import com.example.sport_apply.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 전체 조회
    public List<Student> findAll() {
        String sql = "SELECT * FROM student_table";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student s = new Student();
            s.setStudentId(rs.getInt("student_id"));
            s.setName(rs.getString("name"));
            s.setStdNum(rs.getString("std_num"));
            s.setGender(rs.getString("gender"));
            s.setGrade(rs.getInt("grade"));
            s.setClassNum(rs.getInt("class_num"));
            s.setNum(rs.getInt("num"));
            return s;
        });
    }

    // 추가
    public Student save(Student student) {
        String sql = "INSERT INTO student_table (name, std_num, gender, grade, class_num, num) VALUES (?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getName());
            ps.setString(2, student.getStdNum());
            ps.setString(3, student.getGender());
            ps.setInt(4, student.getGrade());
            ps.setInt(5, student.getClassNum());
            ps.setInt(6, student.getNum());
            return ps;
        }, keyHolder);

        student.setStudentId(keyHolder.getKey().intValue());
        return student;
    }

    // 수정
    public void update(int studentId, Student student) {
        String sql = "UPDATE student_table SET name=?, std_num=?, gender=?, grade=?, class_num=?, num=? WHERE student_id=?";
        jdbcTemplate.update(sql,
                student.getName(), student.getStdNum(), student.getGender(),
                student.getGrade(), student.getClassNum(), student.getNum(),
                studentId);
    }

    // 삭제
    public void deleteById(int studentId) {
        String sql = "DELETE FROM student_table WHERE student_id = ?";
        jdbcTemplate.update(sql, studentId);
    }
}