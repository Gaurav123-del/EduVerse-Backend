package com.eduverse.controller;

import com.eduverse.model.Student;
import com.eduverse.service.StudentService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/profile")
    public Student getProfile(Authentication authentication) {
        String userId = authentication.getName(); // comes from JWT
        return studentService.getStudentProfile(userId);
    }
}
