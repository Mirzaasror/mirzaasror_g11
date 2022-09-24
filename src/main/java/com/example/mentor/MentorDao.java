package com.example.mentor;

import com.example.studen.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor

public class MentorDao {
    private final JdbcTemplate jdbcTemplate;
    public List<Mentor> allmentor(){
        String sql="select * from mentor";
        return jdbcTemplate.query(sql,(rs, row)->
                Mentor.builder().id(rs.getInt(1)).fullName(rs.getString(2)).build()

        )       ;


    }


    public List<MentorDto> allmentors() {
        String sql="select m.id,m.full_name,u.unver_name from mentor m join unver u on u.id = m.unver_id";
       return jdbcTemplate.query(sql,(rs,row)->
            MentorDto.builder().id(rs.getInt(1)).full_name(rs.getString(2)).unver_name(rs.getString(3)).build()
        );


    }
    public List<MentorDto> mentorById(int id) {
        String sql="select m.id,m.full_name,u.unver_name from mentor m join unver u on u.id = m.unver_id where m.id="+id;
        return jdbcTemplate.query(sql,(rs,row)->
                MentorDto.builder().id(rs.getInt(1)).full_name(rs.getString(2)).unver_name(rs.getString(3)).build()
        );


    }

    public void save(Mentor mentor) {
        String sql="insert  into mentor(full_name,unver_id)values (?,?)";
        jdbcTemplate.update(sql,mentor.getFullName(),mentor.getUnver_id());
    }
    public void editsave(Mentor mentor) {
        String sql="update mentor set full_name=? , unver_id=? ,course=? where id=?";
        jdbcTemplate.update(sql,mentor.getFullName(),mentor.getUnver_id(),mentor.getId());    }

    public void delete(int id) {
        String sql="delete from mentor where id =?";
        ;
        jdbcTemplate.update(sql,id);
    }
}
