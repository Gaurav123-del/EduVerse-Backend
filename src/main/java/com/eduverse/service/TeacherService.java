package com.eduverse.service;

import com.eduverse.model.Teacher;
import com.eduverse.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher getTeacherProfile(String userId) {
        return teacherRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Teacher profile not found"));
    }
}
