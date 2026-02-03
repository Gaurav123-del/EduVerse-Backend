package com.eduverse.service;

import com.eduverse.model.Lecture;
import com.eduverse.repository.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public Lecture uploadLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    public List<Lecture> getLecturesBySubject(String subject) {
        return lectureRepository.findBySubject(subject);
    }

    public List<Lecture> getLecturesByTeacher(String teacherUserId) {
        return lectureRepository.findByTeacherUserId(teacherUserId);
    }
}
