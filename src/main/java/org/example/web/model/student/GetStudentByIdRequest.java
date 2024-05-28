package org.example.web.model.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class GetStudentByIdRequest
{
    @JsonProperty("id")
    private long studentId;

    @JsonCreator
    public GetStudentByIdRequest(@JsonProperty("id")long studentId) {
        this.studentId = studentId;
    }

    public long getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetStudentByIdRequest that = (GetStudentByIdRequest) o;
        return studentId == that.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(studentId);
    }
}
