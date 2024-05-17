package org.example.web.model.group;

import org.example.core.model.Group;

import java.util.List;

public class GetGroupResponse {
    private List<Group> groupsName;

    public GetGroupResponse(List<Group> groupsName) {
        this.groupsName = groupsName;
    }

    public List<Group> getGroupsName() {
        return groupsName;
    }
}
