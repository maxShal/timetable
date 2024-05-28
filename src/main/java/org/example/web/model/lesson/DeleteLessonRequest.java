package org.example.web.model.lesson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.web.model.student.DeleteStudentRequest;

import java.util.Objects;

public class DeleteLessonRequest {
    @JsonProperty("id")
    private long id;

    @JsonCreator
    public DeleteLessonRequest( @JsonProperty("id")int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteLessonRequest that = (DeleteLessonRequest) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
