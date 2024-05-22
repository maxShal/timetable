package org.example.core.repository.student;

import org.example.core.EmptyDataException;
import org.example.core.model.Student;
import org.example.web.model.student.AddStudentRequest;
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
public class StudentRepository implements IStudentRepository{

    private final JdbcOperations jdbcOperations;
    private final RowMapper<Student> grouRowMapper;

    public StudentRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.grouRowMapper = (rs, rowNum) -> {
            long studentId = rs.getLong("student_id");
            String studentSurname = rs.getString("student_surname");
            String studentName = rs.getString("student_name");
            String studentStatus = rs.getString("student_status");
            long groupId = rs.getLong("group_id");
            return new Student(studentId, studentSurname, studentName, studentStatus, groupId);
        };
    }

    @Override
    public List<Student> getStudentsByGroupId(long id) {
        String sql = "select * from students where group_id = ?";;
        return jdbcOperations.query(sql, grouRowMapper, id);
    }

    @Override
    public Student getStudentById(long id) {
        String sql = "select * from students where student_id = ?";
        return jdbcOperations.queryForObject(sql, grouRowMapper, id);
    }

    @Override
    public long addStudent(AddStudentRequest request) throws EmptyDataException {
        try {
            String sql = "insert into students (student_surname, student_name, student_status, group_id ) values(?)";
            GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
            PreparedStatementCreator preparedStatementCreator = conn -> {
                PreparedStatement preparedStatement = conn.prepareStatement(sql, new String[]{"student_id"});
                preparedStatement.setString(1, request.getSurname());
                preparedStatement.setString(2, request.getName());
                preparedStatement.setString(3, request.getPatronymic());
                preparedStatement.setString(4, request.getStatus());
                preparedStatement.setLong(5, request.getGroupId());
                return preparedStatement;
            };
             jdbcOperations.update(preparedStatementCreator, generatedKeyHolder);
            return Objects.requireNonNull(generatedKeyHolder.getKey()).longValue();
        }catch(DataAccessException e){throw new EmptyDataException("Can't add student with name");}
    }

    @Override
    public void editStudent(Student student) throws EmptyDataException{
        try {
            String sql = "update students set student_surname = ?, student_name = ?, student_status = ?, group_id = ? where student_id = ?";
            int rowsChanged = jdbcOperations.update(sql, student.getName(), student.getId());
            if (rowsChanged == 0) {
                throw new EmptyDataException("Can't edit student: " + student.getName());
            }
        } catch (DataAccessException e) {
            throw new EmptyDataException("Can't edit student: " + student.getName());
        }

    }

    @Override
    public void deleteStudentById(long id) throws EmptyDataException {
        String sql = "delete from students where student_id = ?";
        int rowsChanged = jdbcOperations.update(sql, id);
        if (rowsChanged == 0) {
            throw new EmptyDataException("Can't delete group with id: " + id);
        }
    }
}
