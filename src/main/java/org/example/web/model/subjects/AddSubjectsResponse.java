package org.example.web.model.subjects;

import org.example.web.model.group.AddGroupResponse;

import java.util.Objects;

public class AddSubjectsResponse
{
    private long id;

    public AddSubjectsResponse( long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddSubjectsResponse that = (AddSubjectsResponse) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
