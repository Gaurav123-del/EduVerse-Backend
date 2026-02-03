package com.eduverse.repository;

import com.eduverse.model.Lecture;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LectureRepository extends MongoRepository<Lecture, String> {

    List<Lecture> findBySubject(String subject);

    List<Lecture> findByTeacherUserId(String teacherUserId);
}
