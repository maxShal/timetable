package org.example.web.model.lesson;

import org.example.core.model.Lesson;

import java.util.List;
import java.util.Objects;

public class GetLessonByGroupResponse
{
    private List<Lesson> lessons;

    public GetLessonByGroupResponse(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetLessonByGroupResponse that = (GetLessonByGroupResponse) o;
        return Objects.equals(lessons, that.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lessons);
    }
}
