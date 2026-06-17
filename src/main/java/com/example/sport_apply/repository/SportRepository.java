package com.example.sport_apply.repository;

import com.example.sport_apply.entity.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class SportRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Sport> findAll() {
        String sql = "SELECT * FROM sport_table";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Sport s = new Sport();
            s.setSportId(rs.getInt("sport_id"));
            s.setSportName(rs.getString("sport_name"));
            s.setCategory(rs.getInt("category"));
            s.setMaxMember(rs.getInt("max_member"));
            return s;
        });
    }


    public Sport save(Sport sport) {
        String sql = "INSERT INTO sport_table (sport_name, category, max_member) VALUES (?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, sport.getSportName());
            ps.setInt(2, sport.getCategory());
            ps.setInt(3, sport.getMaxMember());
            return ps;
        }, keyHolder);

        sport.setSportId(keyHolder.getKey().intValue());
        return sport;
    }


    public void update(int sportId, Sport sport) {
        String sql = "UPDATE sport_table SET sport_name=?, category=?, max_member=? WHERE sport_id=?";
        jdbcTemplate.update(sql, sport.getSportName(), sport.getCategory(), sport.getMaxMember(), sportId);
    }


    public void deleteById(int sportId) {
        String sql = "DELETE FROM sport_table WHERE sport_id = ?";
        jdbcTemplate.update(sql, sportId);
    }
}