package org.example.web.model.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class DeleteStudentRequest
{
    @JsonProperty("id")
    private long id;

    @JsonCreator
    public DeleteStudentRequest( @JsonProperty("id")int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteStudentRequest that = (DeleteStudentRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
