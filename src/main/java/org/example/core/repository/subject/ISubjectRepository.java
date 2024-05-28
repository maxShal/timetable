package org.example.core.repository.subject;

import org.example.core.EmptyDataException;
import org.example.core.model.Subject;
import org.example.web.model.subjects.AddSubjectRequest;
import org.example.web.model.subjects.DeleteSubjectRequest;
import org.example.web.model.subjects.EditSubjectRequest;

import java.util.List;

public interface ISubjectRepository
{
    List<Subject> getSubjects();

    Subject getSubjectById(long id);

    long addSubject(AddSubjectRequest request);

    void editSubject(EditSubjectRequest request) throws EmptyDataException;

    void deleteSubject(DeleteSubjectRequest request) throws EmptyDataException;
}
