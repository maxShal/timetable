package org.example.core.service.subject;

import org.example.core.EmptyDataException;
import org.example.core.model.Subject;
import org.example.core.model.Teacher;
import org.example.web.model.subjects.AddSubjectRequest;
import org.example.web.model.subjects.DeleteSubjectRequest;
import org.example.web.model.subjects.EditSubjectRequest;
import org.example.web.model.teacher.AddTeacherRequest;
import org.example.web.model.teacher.DeleteTeacherRequest;
import org.example.web.model.teacher.EditTeacherRequest;

import java.util.List;

public interface ISubjectService
{
    List<Subject> getSubjects();

    Subject getSubjectById(long id);

    long addSubject(AddSubjectRequest request);

    String editSubject(EditSubjectRequest request) throws EmptyDataException;

    void deleteSubject(DeleteSubjectRequest request) throws EmptyDataException;

}
