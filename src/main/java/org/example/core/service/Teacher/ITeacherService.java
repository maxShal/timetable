package org.example.core.service.Teacher;

import org.example.core.EmptyDataException;
import org.example.core.model.Teacher;
import org.example.web.model.teacher.AddTeacherRequest;
import org.example.web.model.teacher.DeleteTeacherRequest;
import org.example.web.model.teacher.EditTeacherRequest;

import java.util.List;

public interface ITeacherService
{
    List<Teacher> getTeachers();

    Teacher getTeacherById(long id);

    long addTeacher(AddTeacherRequest request);

    String editTeacher(EditTeacherRequest request) throws EmptyDataException;

    void deleteTeacher(DeleteTeacherRequest request) throws EmptyDataException;
}
