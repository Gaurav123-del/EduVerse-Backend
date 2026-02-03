package com.eduverse.controller;

import com.eduverse.model.Teacher;
import com.eduverse.service.TeacherService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/profile")
    public Teacher getProfile(Authentication authentication) {
        String userId = authentication.getName(); // from JWT
        return teacherService.getTeacherProfile(userId);
    }
}
