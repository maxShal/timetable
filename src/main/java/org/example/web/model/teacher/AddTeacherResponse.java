package org.example.web.model.teacher;

import org.example.web.model.student.AddStudentResponse;

import java.util.Objects;

public class AddTeacherResponse
{
    private long id;

    public AddTeacherResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddTeacherResponse that = (AddTeacherResponse) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
