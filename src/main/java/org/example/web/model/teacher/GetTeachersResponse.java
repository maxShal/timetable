package org.example.web.model.teacher;

import org.example.core.model.Teacher;

import java.util.List;

public class GetTeachersResponse
{
    private List<Teacher> teachers;

    public GetTeachersResponse(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
}
