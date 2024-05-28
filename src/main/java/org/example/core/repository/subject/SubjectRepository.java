package org.example.core.repository.subject;

import org.example.core.EmptyDataException;
import org.example.core.model.Subject;
import org.example.core.model.Teacher;
import org.example.web.model.subjects.AddSubjectRequest;
import org.example.web.model.subjects.DeleteSubjectRequest;
import org.example.web.model.subjects.EditSubjectRequest;
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
public class SubjectRepository implements ISubjectRepository{

    private final JdbcOperations jdbcOperations;
    private final RowMapper<Subject> grouRowMapper;

    public SubjectRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.grouRowMapper = (rs, rowNum) -> {
            long subjectId = rs.getLong("subject_id");
            String subjectName = rs.getString("subject_name");
            return new Subject(subjectId, subjectName);
        };
    }

    @Override
    public List<Subject> getSubjects() {
        String sql = "select * from subjects";
        return jdbcOperations.query(sql, grouRowMapper);
    }

    @Override
    public Subject getSubjectById(long id) {
        String sql ="select * from subjects where subject_id = ?";
        return jdbcOperations.queryForObject(sql, grouRowMapper,id);
    }

    @Override
    public long addSubject(AddSubjectRequest request) {
        String sql = "insert into subjects (subject_name) values(?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = conn -> {
            PreparedStatement preparedStatement = conn.prepareStatement(sql, new String[]{"subject_id"});
            preparedStatement.setString(1, request.getName());
            return preparedStatement;
        };
        jdbcOperations.update(preparedStatementCreator, generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).longValue();

    }

    @Override
    public void editSubject(EditSubjectRequest request) throws EmptyDataException{
        try {
            String sql = "update subjects set subject_name = ? where subject_id = ?";
            int rowsChanged = jdbcOperations.update(sql, request.getName(), request.getId());
            if (rowsChanged == 0) {
                throw new EmptyDataException("Can't edit teacher: " + request.getName());
            }
        } catch (DataAccessException e) {
            throw new EmptyDataException(e.getMessage());
        }
    }

    @Override
    public void deleteSubject(DeleteSubjectRequest request) throws EmptyDataException{
        String sql = "delete from subjects where subject_id = ?";
        int rowsChanged = jdbcOperations.update(sql, request.getId());
        if (rowsChanged == 0) {
            throw new EmptyDataException("Can't delete subject with id: " + request.getId());
        }
    }
}
