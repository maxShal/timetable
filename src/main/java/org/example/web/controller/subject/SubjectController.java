package org.example.web.controller.subject;

import org.example.core.EmptyDataException;
import org.example.core.service.subject.ISubjectService;
import org.example.web.model.subjects.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subjects")
public class SubjectController
{
    private final ISubjectService service;

    public SubjectController(ISubjectService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public GetSubjectsResponse getAllGroups() {
        return new GetSubjectsResponse(service.getSubjects());
    }

    @GetMapping("/{id}")
    public GetSubjectByIdResponse getSubjectById(@PathVariable("id") long request)
    {
        return  new GetSubjectByIdResponse(service.getSubjectById(request));
    }

    @PostMapping()
    @ResponseBody
    public AddSubjectsResponse addSubject(@RequestBody AddSubjectRequest request)
    {
        return  new AddSubjectsResponse(service.addSubject(request));
    }

    @PutMapping()
    @ResponseBody
    public EditSubjectResponse editSubject(@RequestBody EditSubjectRequest request) throws EmptyDataException {
        return new EditSubjectResponse(service.editSubject(request));
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteSubject(@RequestBody DeleteSubjectRequest request) throws EmptyDataException {
        service.deleteSubject(request);
    }
}
