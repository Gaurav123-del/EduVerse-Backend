package com.eduverse.controller;

import com.eduverse.model.Lecture;
import com.eduverse.service.LectureService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher/lectures")
public class LectureController {

    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    // TEACHER uploads lecture
    @PostMapping
    public Lecture uploadLecture(
            @RequestBody Lecture lecture,
            Authentication authentication) {

        String teacherUserId = authentication.getName();

        Lecture newLecture = new Lecture(
                lecture.getTitle(),
                lecture.getSubject(),
                lecture.getDescription(),
                lecture.getVideoUrl(),
                teacherUserId
        );

        return lectureService.uploadLecture(newLecture);
    }
}
