package org.example.core.repository.group;
import org.example.core.model.Group;
import org.example.web.model.group.*;
import org.example.core.EmptyDataException;
;import java.util.List;

public interface IGroupRepository {
    List<Group> getGroup();

    Group getGroupById(long request) throws EmptyDataException;

    long addGroup(AddGroupRequest request) throws EmptyDataException;

    void editGroup(EditGroupRequest request) throws EmptyDataException;

    void deleteGroup(DeleteGroupRequest request) throws EmptyDataException;
}
