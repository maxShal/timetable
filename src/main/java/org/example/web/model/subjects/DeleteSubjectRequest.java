package org.example.web.model.subjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.web.model.group.DeleteGroupRequest;

import java.util.Objects;

public class DeleteSubjectRequest {

    @JsonProperty("id")
    private int id;

    @JsonCreator
    public DeleteSubjectRequest(@JsonProperty("id") int id){this.id=id;}

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteSubjectRequest request = (DeleteSubjectRequest) o;
        return Objects.equals(id, request.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
