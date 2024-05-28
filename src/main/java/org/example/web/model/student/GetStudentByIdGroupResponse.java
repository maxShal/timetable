package org.example.web.model.student;

import org.example.core.model.Student;

import java.util.List;
import java.util.Objects;

public class GetStudentByIdGroupResponse
{
    private List<Student> students;

    public GetStudentByIdGroupResponse(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetStudentByIdGroupResponse that = (GetStudentByIdGroupResponse) o;
        return Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(students);
    }
}
