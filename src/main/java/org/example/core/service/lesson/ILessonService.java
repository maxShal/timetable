package org.example.core.service.lesson;

import org.example.core.EmptyDataException;
import org.example.core.model.Group;
import org.example.core.model.Lesson;
import org.example.core.model.Teacher;
import org.example.web.model.lesson.AddLessonRequest;
import org.example.web.model.lesson.DeleteLessonRequest;
import org.example.web.model.lesson.EditLessonRequest;

import java.util.List;

public interface ILessonService
{
    Lesson getLessonById(long id);

    List<Lesson> getLessonByGroup(Group group);

    List<Lesson> getLessonByTeacher(Teacher teacher);

    long addLesson(AddLessonRequest request);

    String editLesson(EditLessonRequest request) throws EmptyDataException;

    void deleteLesson(DeleteLessonRequest request) throws EmptyDataException;
}
