package org.example.web.model.teacher;

import org.example.core.model.Teacher;

import java.util.Objects;

public class GetTeacherByIdResponse
{
    //private long id;
    private Teacher teacher;

    public GetTeacherByIdResponse(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetTeacherByIdResponse that = (GetTeacherByIdResponse) o;
        return Objects.equals(teacher, that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(teacher);
    }
}
