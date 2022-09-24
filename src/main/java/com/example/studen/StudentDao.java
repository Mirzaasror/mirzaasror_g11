package com.example.studen;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDao {
    private final JdbcTemplate jdbcTemplate;
    public List<StudentDto> all_student() {
      String sql="select s.id,s.full_name,s.course_name,s.course,m.full_name from student s join mentor m on m.id = s.mentor_id";
        return   jdbcTemplate.query(sql,(rs,row)->
                StudentDto.builder().id(rs.getInt(1)).full_name(rs.getString(2)).course_name(rs.getString(3)).course(rs.getInt(4)).mentor_name(rs.getString(5)).build());
    }

    public void save(Student student) {
        String sql="insert into student (full_name,course_name,course,mentor_id) values (?,?,?,?)";

        jdbcTemplate.update(sql,student.getFull_name(),student.getCourse_name(),student.getCouse(),student.getMentor_id());
    }

    public List<StudentDto> studentById(int id) {
        String sql="select s.id,s.full_name,s.course_name,s.course,m.full_name from student s join mentor m on m.id = s.mentor_id where s.id="+id;
        return   jdbcTemplate.query(sql,(rs,row)->
                StudentDto.builder().id(rs.getInt(1)).full_name(rs.getString(2)).course_name(rs.getString(3)).course(rs.getInt(4)).mentor_name(rs.getString(5)).build());
    }

    public void editsave(Student student) {
        String sql="update student set full_name=? , cource_name=? ,course=?, mentor_id=? where id=?";
        jdbcTemplate.update(sql,student.getFull_name(),student.getCourse_name(),student.getCouse(),student.getMentor_id(),student.getId());
    }
    public void delete(int id){
        String sql="delete from student where id =?";
        ;
        jdbcTemplate.update(sql,id);
    }

}

