package org.example.core.service.group;

import org.example.core.EmptyDataException;
import org.example.core.model.Group;
import org.example.core.repository.group.IGroupRepository;
import org.example.web.model.group.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService implements IGroupService
{

    private final IGroupRepository groupRepository;

    public GroupService(IGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> GetAllGroups() {
        return groupRepository.getGroup();
    }

    @Override
    public Group getGroupById(GetGroupByIdRequest request) throws EmptyDataException {
        return groupRepository.getGroupById(request);
    }

    @Override
    public long addGroup(AddGroupRequest request) throws EmptyDataException {
        return groupRepository.addGroup(request);
    }

    @Override
    public String editGroup(EditGroupRequest request) throws EmptyDataException {
        groupRepository.editGroup(request);
        return request.getName();
    }

    @Override
    public void deleteGroup(DeleteGroupRequest request) throws EmptyDataException {
        groupRepository.deleteGroup(request);
    }
}
