package org.example.web.model.group;

import java.util.Objects;

public class EditGroupResponse
{
    private String name;

    public EditGroupResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EditGroupResponse that = (EditGroupResponse) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
