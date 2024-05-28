package org.example.web.model.lesson;

import org.example.web.model.student.AddStudentResponse;

import java.util.Objects;

public class AddLessonResponse
{
    private long id;

    public AddLessonResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddLessonResponse that = (AddLessonResponse) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
