package org.example.web.model.subjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.web.model.group.EditGroupRequest;

import java.util.Objects;

public class EditSubjectRequest {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    @JsonCreator
    public EditSubjectRequest(@JsonProperty("id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditSubjectRequest that = (EditSubjectRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
