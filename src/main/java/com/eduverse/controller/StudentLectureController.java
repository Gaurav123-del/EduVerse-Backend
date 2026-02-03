package com.eduverse.controller;

import com.eduverse.model.Lecture;
import com.eduverse.service.LectureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/lectures")
public class StudentLectureController {

    private final LectureService lectureService;

    public StudentLectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    // STUDENT views lectures (by subject)
    @GetMapping
    public List<Lecture> getLectures(
            @RequestParam(required = false) String subject) {

        if (subject != null && !subject.isEmpty()) {
            return lectureService.getLecturesBySubject(subject);
        }

        return lectureService.getLecturesBySubject("Maths"); // default for demo
    }
}
