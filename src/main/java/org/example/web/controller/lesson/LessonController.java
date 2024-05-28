package org.example.web.controller.lesson;

import jakarta.validation.Valid;
import org.example.core.EmptyDataException;
import org.example.core.model.Group;
import org.example.core.model.Lesson;
import org.example.core.model.Student;
import org.example.core.service.lesson.ILessonService;
import org.example.web.model.lesson.*;
import org.example.web.model.student.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private final ILessonService lessonService;

    public LessonController(ILessonService lessonService) {
        this.lessonService = lessonService;

    }

    @GetMapping
    @ResponseBody
    public GetLessonByGroupResponse getLessonByGroup(Group group)  {
        return new GetLessonByGroupResponse(lessonService.getLessonByGroup(group));
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable("id") long id) {
        return lessonService.getLessonById(id);
    }

    @PostMapping
    @ResponseBody
    public AddLessonResponse addStudent(@RequestBody AddLessonRequest request) throws EmptyDataException {
        return  new AddLessonResponse(lessonService.addLesson(request));
    }

    @PutMapping
    @ResponseBody
    public EditLessonResponse editStudent(@RequestBody EditLessonRequest request) throws EmptyDataException {
        return new EditLessonResponse(lessonService.editLesson(request));
    }

    @DeleteMapping("/{id}")
    public void deleteLessonById(DeleteLessonRequest request) throws EmptyDataException {
        lessonService.deleteLesson(request);
    }
}
