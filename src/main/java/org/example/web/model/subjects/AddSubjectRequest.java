package org.example.web.model.subjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.web.model.group.AddGroupRequest;

import java.util.Objects;

public class AddSubjectRequest
{
    @JsonProperty("name")
    private String name;

    @JsonCreator
    public AddSubjectRequest(@JsonProperty("name")String name){this.name=name;}

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddSubjectRequest that = (AddSubjectRequest) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
