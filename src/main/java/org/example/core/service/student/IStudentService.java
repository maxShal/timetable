package org.example.core.service.student;

import org.example.core.EmptyDataException;
import org.example.core.model.Student;
import org.example.web.model.student.AddStudentRequest;
import org.example.web.model.student.DeleteStudentRequest;
import org.example.web.model.student.EditStudentRequest;
import org.example.web.model.student.GetStudentByIdGroupRequest;

import java.util.List;

public interface IStudentService
{
    List<Student> getStudentsByGroupId(GetStudentByIdGroupRequest id) throws EmptyDataException;

    Student getStudentById(long id) throws EmptyDataException;

    long addStudent(AddStudentRequest request) throws EmptyDataException;

    String editStudent(EditStudentRequest student) throws EmptyDataException;

    void deleteStudentById(DeleteStudentRequest id) throws EmptyDataException;
}
