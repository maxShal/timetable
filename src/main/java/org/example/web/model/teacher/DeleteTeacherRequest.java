package org.example.web.model.teacher;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.web.model.student.DeleteStudentRequest;

import java.util.Objects;

public class DeleteTeacherRequest
{
    @JsonProperty("id")
    private long id;

    @JsonCreator
    public DeleteTeacherRequest( @JsonProperty("id")int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteTeacherRequest that = (DeleteTeacherRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
