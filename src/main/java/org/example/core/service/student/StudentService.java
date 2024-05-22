package org.example.core.service.student;

import org.example.core.EmptyDataException;
import org.example.core.model.Student;
import org.example.core.repository.student.IStudentRepository;
import org.example.web.model.student.AddStudentRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudentsByGroupId(long id) throws EmptyDataException {
        return studentRepository.getStudentsByGroupId(id);
    }

    @Override
    public Student getStudentById(long id) throws EmptyDataException {
        return studentRepository.getStudentById(id);
    }

    @Override
    public long addStudent(AddStudentRequest request) throws EmptyDataException {
        return studentRepository.addStudent(request);
    }

    @Override
    public void editStudent(Student student) throws EmptyDataException {
        studentRepository.editStudent(student);
    }

    @Override
    public void deleteStudentById(long id) throws EmptyDataException {
        studentRepository.deleteStudentById(id);
    }
}
