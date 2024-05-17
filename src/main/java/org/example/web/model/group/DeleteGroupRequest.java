package org.example.web.model.group;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class DeleteGroupRequest
{
    @JsonProperty("id")
    private int id;

    @JsonCreator
    public DeleteGroupRequest(@JsonProperty("id") int id){this.id=id;}

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteGroupRequest request = (DeleteGroupRequest) o;
        return Objects.equals(id, request.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
