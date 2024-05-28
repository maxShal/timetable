package org.example.web.model.lesson;

import org.example.core.model.Lesson;

import java.util.Objects;

public class EditLessonResponse
{
    private String date;

    public EditLessonResponse(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditLessonResponse that = (EditLessonResponse) o;
        return Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(date);
    }
}
