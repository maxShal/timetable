package org.example.web.model.group;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class GetGroupByIdRequest {
    @JsonProperty("id")
    private int groupId;

    @JsonCreator
    public GetGroupByIdRequest(@JsonProperty("id") int groupId) {
        this.groupId = groupId;
    }
    public int getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetGroupByIdRequest that = (GetGroupByIdRequest) o;
        return Objects.equals(groupId, that.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId);
    }
}
