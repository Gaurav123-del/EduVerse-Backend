package com.eduverse.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teachers")
public class Teacher {

    @Id
    private String id;

    private String userId;
    private String name;
    private String subject;
    private String email;
    private int experience;

    public Teacher() {}

    public Teacher(String userId, String name, String subject, String email, int experience) {
        this.userId = userId;
        this.name = name;
        this.subject = subject;
        this.email = email;
        this.experience = experience;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }
}
