package org.example.core.repository.teacher;

import org.example.core.EmptyDataException;
import org.example.core.model.Teacher;
import org.example.web.model.group.DeleteGroupRequest;
import org.example.web.model.group.EditGroupRequest;
import org.example.web.model.teacher.AddTeacherRequest;
import org.example.web.model.teacher.DeleteTeacherRequest;
import org.example.web.model.teacher.EditTeacherRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface
ITeacherRepository {
    List<Teacher> getTeachers();

    Teacher getTeacherById(long id);

    long addTeacher(AddTeacherRequest request);

    void editGroup(EditTeacherRequest request) throws EmptyDataException;

    void deleteGroup(DeleteTeacherRequest request) throws EmptyDataException;

}
