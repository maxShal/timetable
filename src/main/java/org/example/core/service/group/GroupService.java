package org.example.core.service.group;

import org.example.core.EmptyDataException;
import org.example.core.repository.group.IGroupRepository;
import org.example.web.model.group.*;
import org.springframework.stereotype.Service;

@Service
public class GroupService implements IGroupService
{

    private final IGroupRepository groupRepository;

    public GroupService(IGroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public GetGroupResponse GetAllGroups() {
        return groupRepository.getGroup();
    }

    @Override
    public GetGroupByIdResponse getGroupById(GetGroupByIdRequest request) throws EmptyDataException {
        return groupRepository.getGroupById(request);
    }

    @Override
    public AddGroupResponse addGroup(AddGroupRequest request) {
        return groupRepository.addGroup(request);
    }

    @Override
    public EditGroupResponse editGroup(EditGroupRequest request) throws EmptyDataException {
        return groupRepository.editGroup(request);
    }

    @Override
    public void deleteGroup(DeleteGroupRequest request) {
        groupRepository.deleteGroup(request);
    }
}
