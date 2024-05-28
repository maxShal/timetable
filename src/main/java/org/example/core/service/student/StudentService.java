package org.example.core.service.student;

import org.example.core.EmptyDataException;
import org.example.core.model.Student;
import org.example.core.repository.student.IStudentRepository;
import org.example.web.model.student.AddStudentRequest;
import org.example.web.model.student.DeleteStudentRequest;
import org.example.web.model.student.EditStudentRequest;
import org.example.web.model.student.GetStudentByIdGroupRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{

    private final IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudentsByGroupId(GetStudentByIdGroupRequest id) throws EmptyDataException {
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
    public String editStudent(EditStudentRequest student) throws EmptyDataException {
        studentRepository.editStudent(student);
        return student.getSurname();
    }

    @Override
    public void deleteStudentById(DeleteStudentRequest id) throws EmptyDataException {
        studentRepository.deleteStudentById(id);
    }
}
