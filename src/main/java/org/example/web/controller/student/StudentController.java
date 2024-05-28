package org.example.web.controller.student;


import jakarta.validation.Valid;
import org.example.core.EmptyDataException;
import org.example.core.model.Student;
import org.example.core.service.group.IGroupService;
import org.example.core.service.student.IStudentService;
import org.example.web.model.student.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    private final IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    @ResponseBody
    public GetStudentByIdGroupResponse getStudentsByGroupId(GetStudentByIdGroupRequest groupid) throws EmptyDataException {
        return new GetStudentByIdGroupResponse(studentService.getStudentsByGroupId(groupid));
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") long id) throws EmptyDataException {
        return studentService.getStudentById(id);
    }

    @PostMapping
    @ResponseBody
    public AddStudentResponse addStudent(@Valid @RequestBody AddStudentRequest request) throws EmptyDataException {
        return  new AddStudentResponse(studentService.addStudent(request));
    }

    @PutMapping
    @ResponseBody
    public EditStudentResponse editStudent(@RequestBody EditStudentRequest student) throws EmptyDataException {
        return new EditStudentResponse(studentService.editStudent(student));
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(DeleteStudentRequest id) throws EmptyDataException {
        studentService.deleteStudentById(id);
    }
}
