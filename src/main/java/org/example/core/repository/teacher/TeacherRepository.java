package org.example.core.repository.teacher;

import org.example.core.EmptyDataException;
import org.example.core.model.Student;
import org.example.core.model.Teacher;
import org.example.web.model.teacher.AddTeacherRequest;
import org.example.web.model.teacher.DeleteTeacherRequest;
import org.example.web.model.teacher.EditTeacherRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Repository
public class TeacherRepository implements ITeacherRepository{

    private final JdbcOperations jdbcOperations;
    private final RowMapper<Teacher> grouRowMapper;

    public TeacherRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.grouRowMapper = (rs, rowNum) -> {
            long teacherId = rs.getLong("teacher_id");
            String teacherSurname = rs.getString("teacher_surname");
            String teacherName = rs.getString("teacher_name");
            String teacherPatronymic = rs.getString("teacher_patronymic");
            String teacherPosition = rs.getString("teacher_position");
            return new Teacher(teacherId, teacherSurname, teacherName, teacherPatronymic, teacherPosition);
        };
    }
    @Override
    public List<Teacher> getTeachers() {
        String sql = "select * from teachers";
        return jdbcOperations.query(sql, grouRowMapper);
    }

    @Override
    public Teacher getTeacherById(long id) {
        String sql ="Select * from teachers where teacher_id = ?";
        return jdbcOperations.queryForObject(sql, grouRowMapper,id);
    }

    @Override
    public long addTeacher(AddTeacherRequest request) {
        String sql = "insert into teachers (teacher_surname, teacher_name, teacher_patronymic, teacher_position) values(?,?,?,?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = conn -> {
            PreparedStatement preparedStatement = conn.prepareStatement(sql, new String[]{"teacher_id"});
            preparedStatement.setString(1, request.getSurname());
            preparedStatement.setString(2, request.getName());
            preparedStatement.setString(3, request.getPatronymic());
            preparedStatement.setString(4, request.getPosition());
            return preparedStatement;
        };
        jdbcOperations.update(preparedStatementCreator, generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).longValue();
    }

    @Override
    public void editGroup(EditTeacherRequest request) throws EmptyDataException {
       try {
            String sql = "update teachers set teacher_surname = ?, teacher_name = ?, teacher_patronymic = ?, teacher_position = ? where teacher_id = ?";
            int rowsChanged = jdbcOperations.update(sql, request.getSurname(), request.getName(), request.getPatronymic(), request.getPosition(), request.getId());
            if (rowsChanged == 0) {
                throw new EmptyDataException("Can't edit teacher: " + request.getName());
            }
        } catch (DataAccessException e) {
            throw new EmptyDataException(e.getMessage());
        }
    }

    @Override
    public void deleteGroup(DeleteTeacherRequest request) throws EmptyDataException {
        String sql = "delete from teachers where teacher_id = ?";
        int rowsChanged = jdbcOperations.update(sql, request.getId());
        if (rowsChanged == 0) {
            throw new EmptyDataException("Can't delete teacher with id: " + request.getId());
        }
    }
}
