package com.eduverse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "lectures")
public class Lecture {

    @Id
    private String id;

    private String title;
    private String subject;
    private String description;
    private String videoUrl;

    private String teacherUserId;
    private LocalDateTime uploadedAt;

    public Lecture() {}

    public Lecture(String title, String subject, String description,
                   String videoUrl, String teacherUserId) {
        this.title = title;
        this.subject = subject;
        this.description = description;
        this.videoUrl = videoUrl;
        this.teacherUserId = teacherUserId;
        this.uploadedAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getSubject() { return subject; }
    public String getDescription() { return description; }
    public String getVideoUrl() { return videoUrl; }
    public String getTeacherUserId() { return teacherUserId; }
    public LocalDateTime getUploadedAt() { return uploadedAt; }
}
