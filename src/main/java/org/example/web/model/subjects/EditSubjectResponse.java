package org.example.web.model.subjects;

import org.example.web.model.group.EditGroupResponse;

import java.util.Objects;

public class EditSubjectResponse {

    private String name;

    public EditSubjectResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditSubjectResponse that = (EditSubjectResponse) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
