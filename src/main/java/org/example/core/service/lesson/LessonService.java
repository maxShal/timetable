package org.example.core.service.lesson;

import org.example.core.EmptyDataException;
import org.example.core.model.Group;
import org.example.core.model.Lesson;
import org.example.core.model.Teacher;
import org.example.core.repository.lesson.ILessonRepository;
import org.example.web.model.lesson.AddLessonRequest;
import org.example.web.model.lesson.DeleteLessonRequest;
import org.example.web.model.lesson.EditLessonRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService implements ILessonService{

    private final ILessonRepository service;

    public LessonService(ILessonRepository service) {
        this.service = service;
    }

    @Override
    public Lesson getLessonById(long id) {
        return service.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonByGroup(Group group) {
        return service.getLessonByGroup(group);
    }

    @Override
    public List<Lesson> getLessonByTeacher(Teacher teacher) {
        return service.getLessonByTeacher(teacher);
    }

    @Override
    public long addLesson(AddLessonRequest request) {
        return service.addLesson(request);
    }

    @Override
    public String editLesson(EditLessonRequest request) throws EmptyDataException {
        service.editLesson(request);
        return request.getDate();
    }

    @Override
    public void deleteLesson(DeleteLessonRequest request) throws EmptyDataException {
        service.deleteLesson(request);
    }
}
