package org.example.web.model.lesson;

import org.example.core.model.Lesson;

import java.util.List;
import java.util.Objects;

public class GetLessonByTeacherResponse {
    private List<Lesson> lessons;

    public GetLessonByTeacherResponse(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLessonByTeacherResponse that = (GetLessonByTeacherResponse) o;
        return Objects.equals(lessons, that.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lessons);
    }
}
