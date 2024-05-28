package org.example.web.model.student;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class GetStudentByIdGroupRequest
{
    @JsonProperty("groupId")
    private long groupId;

    @JsonCreator
    public GetStudentByIdGroupRequest(@JsonProperty("groupId")long groupId) {

        this.groupId = groupId;
    }

    public long getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetStudentByIdGroupRequest that = (GetStudentByIdGroupRequest) o;
        return groupId == that.groupId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(groupId);
    }
}
