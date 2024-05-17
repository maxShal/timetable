package org.example.core.repository.group;
import org.example.web.model.group.*;
import org.example.core.EmptyDataException;
;

public interface IGroupRepository {
    GetGroupResponse getGroup();

    GetGroupByIdResponse getGroupById(GetGroupByIdRequest request) throws EmptyDataException;

    AddGroupResponse addGroup(AddGroupRequest request) throws EmptyDataException;

    EditGroupResponse editGroup(EditGroupRequest request) throws EmptyDataException;

    void deleteGroup(DeleteGroupRequest request) throws EmptyDataException;
}
