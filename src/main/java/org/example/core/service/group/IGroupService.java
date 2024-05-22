package org.example.core.service.group;

import org.example.core.EmptyDataException;
import org.example.core.model.Group;
import org.example.web.model.group.*;

import java.util.List;

public interface IGroupService {
    List<Group> GetAllGroups();
    Group getGroupById(long id) throws EmptyDataException;
    long addGroup(AddGroupRequest request) throws EmptyDataException;
    String editGroup(EditGroupRequest request) throws EmptyDataException;
    void deleteGroup(DeleteGroupRequest request) throws EmptyDataException;

}
