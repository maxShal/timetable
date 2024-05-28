package org.example.core.service.Teacher;

import org.example.core.EmptyDataException;
import org.example.core.model.Teacher;
import org.example.core.repository.teacher.ITeacherRepository;
import org.example.web.model.teacher.AddTeacherRequest;
import org.example.web.model.teacher.DeleteTeacherRequest;
import org.example.web.model.teacher.EditTeacherRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService implements ITeacherService{

    private final ITeacherRepository teacherRepository;

    public TeacherService(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.getTeachers();
    }

    @Override
    public Teacher getTeacherById(long id) {
        return teacherRepository.getTeacherById(id);
    }

    @Override
    public long addTeacher(AddTeacherRequest request) {
        return teacherRepository.addTeacher(request);
    }

    @Override
    public String editTeacher(EditTeacherRequest request) throws EmptyDataException {
        teacherRepository.editGroup(request);
        return request.getName();
    }

    @Override
    public void deleteTeacher(DeleteTeacherRequest request) throws EmptyDataException {
        teacherRepository.deleteGroup(request);
    }
}
