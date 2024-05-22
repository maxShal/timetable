package org.example.core.repository.student;

import org.example.core.EmptyDataException;
import org.example.core.model.Student;
import org.example.web.model.student.AddStudentRequest;

import java.util.List;

public interface IStudentRepository
{
    List<Student> getStudentsByGroupId(long id)throws EmptyDataException;

    Student getStudentById(long id)throws EmptyDataException;

    long addStudent(AddStudentRequest request) throws EmptyDataException;

    void editStudent(Student student)throws EmptyDataException;

    void deleteStudentById(long id)throws EmptyDataException;
}
