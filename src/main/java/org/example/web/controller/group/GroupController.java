package org.example.web.controller.group;


import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.example.core.EmptyDataException;
import org.example.core.model.Group;
import org.example.core.service.group.IGroupService;
import org.example.web.model.group.*;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final IGroupService groupService;

    public GroupController(IGroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    @ResponseBody
    public GetGroupResponse getAllGroups() {
        return new GetGroupResponse(groupService.GetAllGroups());
    }

    @GetMapping("id")
    public GetGroupByIdResponse getGroupById(@PathVariable("id") GetGroupByIdRequest request) throws EmptyDataException {
        return new GetGroupByIdResponse(groupService.getGroupById(request));
    }


    @PostMapping()
    @ResponseBody
    public AddGroupResponse addStudentGroup(@Valid @RequestBody AddGroupRequest request) throws EmptyDataException {
        return new AddGroupResponse(groupService.addGroup(request));
    }

    @PutMapping()
    @ResponseBody
    public EditGroupResponse editStudentGroup(@Valid @RequestBody EditGroupRequest request) throws EmptyDataException {
        return new EditGroupResponse(groupService.editGroup(request));
    }

    @DeleteMapping("/id")
    @ResponseBody
    public void deleteStudentGroup(@Valid @RequestBody DeleteGroupRequest request) throws EmptyDataException {
       groupService.deleteGroup(request);
    }
}
