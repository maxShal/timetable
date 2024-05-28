package org.example.core.service.subject;

import org.example.core.EmptyDataException;
import org.example.core.model.Subject;
import org.example.core.repository.subject.ISubjectRepository;
import org.example.web.model.subjects.AddSubjectRequest;
import org.example.web.model.subjects.DeleteSubjectRequest;
import org.example.web.model.subjects.EditSubjectRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements ISubjectService{

    private final ISubjectRepository subjectRepository;

    public SubjectService(ISubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getSubjects() {
        return subjectRepository.getSubjects();
    }

    @Override
    public Subject getSubjectById(long id) {
        return subjectRepository.getSubjectById(id);
    }

    @Override
    public long addSubject(AddSubjectRequest request) {
        return subjectRepository.addSubject(request);
    }

    @Override
    public String editSubject(EditSubjectRequest request) throws EmptyDataException {
        subjectRepository.editSubject(request);
        return request.getName();
    }

    @Override
    public void deleteSubject(DeleteSubjectRequest request) throws EmptyDataException {
        subjectRepository.deleteSubject(request);
    }
}
