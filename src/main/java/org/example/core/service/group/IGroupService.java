package org.example.core.service.group;

import org.example.core.EmptyDataException;
import org.example.web.model.group.*;

public interface IGroupService {
    GetGroupResponse GetAllGroups();
    GetGroupByIdResponse getGroupById(GetGroupByIdRequest request) throws EmptyDataException;
    AddGroupResponse addGroup(AddGroupRequest request);
    EditGroupResponse editGroup(EditGroupRequest request) throws EmptyDataException;
    void deleteGroup(DeleteGroupRequest request);

}
