package org.example.web.model.group;

import org.example.core.model.Group;

import java.util.Objects;

public class GetGroupByIdResponse {
    private final Group groupName;

    public GetGroupByIdResponse(Group groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName.getGroupName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetGroupByIdResponse that = (GetGroupByIdResponse) o;
        return Objects.equals(groupName, that.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }
}
