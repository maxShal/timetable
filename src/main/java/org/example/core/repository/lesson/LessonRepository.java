package org.example.core.repository.lesson;

import org.example.core.EmptyDataException;
import org.example.core.model.Group;
import org.example.core.model.Lesson;
import org.example.core.model.Subject;
import org.example.core.model.Teacher;
import org.example.web.model.lesson.AddLessonRequest;
import org.example.web.model.lesson.DeleteLessonRequest;
import org.example.web.model.lesson.EditLessonRequest;
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
public class LessonRepository implements ILessonRepository
{

    private final JdbcOperations jdbcOperations;
    private final RowMapper<Lesson> grouRowMapper;

    public LessonRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.grouRowMapper = (rs, rowNum) -> {
            long lessonId = rs.getLong("lesson_id");
            String lessonName = rs.getString("lesson_date");
            long lesson_number_in_schedule = rs.getLong("lesson_number_in_schedule");
            long subject_id = rs.getLong("subject_id");
            long teacher_id = rs.getLong("teacher_id");
            return new Lesson(lessonId, lessonName,lesson_number_in_schedule,subject_id,teacher_id);
        };
    }

    @Override
    public Lesson getLessonById(long id) {
        String sql ="select * from lessons where lesson_id = ?";
        return jdbcOperations.queryForObject(sql, grouRowMapper,id);
    }

    @Override
    public List<Lesson> getLessonByGroup(Group group) {
        String sql = "select l.lesson_id, l.lesson_date, l.lesson_number_in_schedule , l.subject_id , l.teacher_id from lessons as l left join lessons_for_groups as lfg on l.lesson_id  = lfg.lesson_id  where l.lesson_date  >= TO_DATE(?,'DDMMYYYY') and l.lesson_date  < TO_DATE(?,'DDMMYYYY') and lfg.group_id  = ?";
        return jdbcOperations.query(sql, grouRowMapper,group.getId());
    }

    @Override
    public List<Lesson>  getLessonByTeacher(Teacher teacher) {
        String sql = "select * from lessons where lesson_date >= TO_DATE(?, 'DDMMYYYY') and lesson_date < TO_DATE(?, 'DDMMYYYY') and teacher_id = ?";
        return jdbcOperations.query(sql, grouRowMapper,teacher.getId());

    }

    @Override
    public long addLesson(AddLessonRequest request) {
        String sql = "insert into lessons (lesson_date, lesson_number_in_schedule, subject_id, teacher_id) values(?,?,?,?)";
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        PreparedStatementCreator preparedStatementCreator = conn -> {
            PreparedStatement preparedStatement = conn.prepareStatement(sql, new String[]{"subject_id"});
            preparedStatement.setString(1, request.getDate());
            preparedStatement.setLong(2, request.getNumberInSchedule());
            preparedStatement.setLong(3, request.getSubjectId());
            preparedStatement.setLong(4, request.getTeacherId());
            return preparedStatement;
        };
        jdbcOperations.update(preparedStatementCreator, generatedKeyHolder);
        return Objects.requireNonNull(generatedKeyHolder.getKey()).longValue();

    }

    @Override
    public void editLesson(EditLessonRequest request) throws EmptyDataException{
        try {
            String sql = "update lessons set lesson_date = ?, lesson_number_in_schedule = ?, subject_id = ?, teacher_id = ? where lesson_id = ?";
            int rowsChanged = jdbcOperations.update(sql, request.getDate(), request.getNumberInSchedule(), request.getSubjectId(), request.getTeacherId(), request.getId());
            if (rowsChanged == 0) {
                throw new EmptyDataException("Can't edit teacher: " + request.getId());
            }
        } catch (DataAccessException e) {
            throw new EmptyDataException(e.getMessage());
        }
    }

    @Override
    public void deleteLesson(DeleteLessonRequest request) throws EmptyDataException{
        String sql = "delete from lessons where lesson_id = ?";
        int rowsChanged = jdbcOperations.update(sql, request.getId());
        if (rowsChanged == 0) {
            throw new EmptyDataException("Can't delete subject with id: " + request.getId());
        }
    }
}
