package com.eduverse.repository;

import com.eduverse.model.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
    Optional<Teacher> findByUserId(String userId);
}
