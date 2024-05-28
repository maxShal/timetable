package org.example.web.controller.teacher;


import org.example.core.EmptyDataException;
import org.example.core.service.Teacher.ITeacherService;
import org.example.web.model.group.AddGroupResponse;
import org.example.web.model.group.GetGroupResponse;
import org.example.web.model.teacher.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController
{
    private final ITeacherService teacherService;

    public TeacherController(ITeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    @ResponseBody
    public GetTeachersResponse getAllGroups() {
        return new GetTeachersResponse(teacherService.getTeachers());
    }

    @GetMapping("/{id}")
    public GetTeacherByIdResponse getTeacherById(@PathVariable("id") long request)
    {
        return  new GetTeacherByIdResponse(teacherService.getTeacherById(request));
    }

    @PostMapping()
    @ResponseBody
    public AddTeacherResponse addTeacher(@RequestBody AddTeacherRequest request)
    {
        return  new AddTeacherResponse(teacherService.addTeacher(request));
    }

    @PutMapping()
    @ResponseBody
    public EditTeacherResponse editTeacher(@RequestBody EditTeacherRequest request) throws EmptyDataException {
        return new EditTeacherResponse(teacherService.editTeacher(request));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteTeacher(@RequestBody DeleteTeacherRequest request) throws EmptyDataException {
        teacherService.deleteTeacher(request);
    }
}
